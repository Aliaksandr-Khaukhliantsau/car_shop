import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY secondname ASC;";
    private static final String SQL_ADD_A_NEW_CUSTOMER = "INSERT INTO customers (secondname, firstname, middlename) VALUES (?, ?, ?);";


    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all customers");
            System.out.println("2 - Show customers by the sample");
            System.out.println("3 - Change a customer");
            System.out.println("4 - Add a new customer");
            System.out.println("5 - Delete a customer");
            System.out.println("0 - Exit");

            int userCommand = scanner.nextInt();

            if (userCommand == 0) {
                // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                connection.close();
                System.exit(0);
            } else if (userCommand == 1) {
                // Показать всех клинтов
                Statement statement = connection.createStatement();
                // объект, который содержит результат SQL запроса
                ResultSet result = statement.executeQuery(SQL_SHOW_ALL_CUSTOMERS);

                while (result.next()) {
                    System.out.println(result.getString("id") + " " +
                            result.getString("secondname") + " " +
                            result.getString("firstname") + " " +
                            result.getString("middlename"));
                }
                System.out.println();
                result.close();
                statement.close();
            } else if (userCommand == 2) {
                // Показать клиентов по выборке
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample");
                    System.out.println("1 - id");
                    System.out.println("2 - Second name");
                    System.out.println("3 - First name");
                    System.out.println("4 - Middle name");
                    System.out.println("0 - Back to the previous menu");

                    userCommand = scanner.nextInt();

                    if (userCommand == 0) {
                        // Выход в предыдущее меню
                        System.out.println("Exit to the previous menu.\n");
                        break;
                    } else if (userCommand == 1) {
                        // Выборка по id
                        System.out.println("Insert the id:");
                        String idCustomer = scanner.next();
                        String SQL_SHOW_CUSTOMERS_BY_ID = "SELECT * FROM customers WHERE id = " + "'" + idCustomer + "'" + " ORDER BY secondname ASC;";
                        Statement statement = connection.createStatement();
                        // объект, который содержит результат SQL запроса
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_ID);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                        result.close();
                        statement.close();
                    } else if (userCommand == 2) {
                        // Выборка по фамилии
                        System.out.println("Insert the second name:");
                        String secondName = scanner.next();
                        String SQL_SHOW_CUSTOMERS_BY_SECOND_NAME = "SELECT * FROM customers WHERE secondname = " + "'" + secondName + "'" + " ORDER BY secondname ASC;";
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_SECOND_NAME);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                        result.close();
                        statement.close();
                    } else if (userCommand == 3) {
                        // Выборка по имени
                        System.out.println("Insert the first name:");
                        String firstName = scanner.next();
                        String SQL_SHOW_CUSTOMERS_BY_FIRST_NAME = "SELECT * FROM customers WHERE firstname = " + "'" + firstName + "'" + " ORDER BY secondname ASC;";
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_FIRST_NAME);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                        result.close();
                        statement.close();
                    } else if (userCommand == 4) {
                        // Выборка по отчеству
                        System.out.println("Insert the middle name:");
                        String middleName = scanner.next();
                        String SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middlename = '" + middleName + "' ORDER BY secondname ASC;";
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                        result.close();
                        statement.close();
                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }
            } else if (userCommand == 3) {
                // Изменить клиента
                System.out.println("Insert the customer's id:");
                String idCustomer = scanner.next();
                String SQL_CHANGE_A_CUSTOMER = "UPDATE customers SET secondname = ?, firstname = ?, middlename = ? WHERE id = '" + idCustomer + "';";
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_CHANGE_A_CUSTOMER);
                // Ввести новые данные клиента
                for (int i = 1; i < 4; i++) {
                    if (i == 1) {
                        System.out.println("Enter the last name of the new customer:");
                    } else if (i == 2) {
                        System.out.println("Enter the first name of the new customer:");
                    } else {
                        System.out.println("Enter the middle name of the new customer:");
                    }
                    String dataAboutTheNewCustomer = scanner.next();
                    preparedStatement.setString(i, dataAboutTheNewCustomer);
                }
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } else if (userCommand == 4) {
                // Добавить нового клиента
                PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_A_NEW_CUSTOMER);
                // Ввести данные нового клиента
                for (int i = 1; i < 4; i++) {
                    if (i == 1) {
                        System.out.println("Enter the last name of the new customer:");
                    } else if (i == 2) {
                        System.out.println("Enter the first name of the new customer:");
                    } else {
                        System.out.println("Enter the middle name of the new customer:");
                    }
                    String dataAboutTheNewCustomer = scanner.next();
                    preparedStatement.setString(i, dataAboutTheNewCustomer);
                }
                preparedStatement.executeUpdate();
                preparedStatement.close();
            } else if (userCommand == 5) {
                // Удалить клиента
                System.out.println("Insert the customer's id:");
                String idCustomer = scanner.next();
                String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE id = '" + idCustomer + "' RETURNING *;";
                Statement statement = connection.createStatement();
                // объект, который содержит результат SQL запроса
                ResultSet result = statement.executeQuery(SQL_DELETE_A_CUSTOMER);
                System.out.println("Customer's record deleted:");

                while (result.next()) {
                    System.out.println(result.getString("id") + " " +
                            result.getString("secondname") + " " +
                            result.getString("firstname") + " " +
                            result.getString("middlename"));
                }
                System.out.println();
                result.close();
                statement.close();
            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}