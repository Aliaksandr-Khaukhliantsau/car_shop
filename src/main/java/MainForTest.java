import entity.Customer;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class MainForTest {
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY secondname ASC;";
    private static final String SQL_SHOW_CUSTOMERS_BY_FIRST_NAME = "SELECT * FROM customers WHERE firstname = ? ORDER BY secondname ASC;";
    private static final String SQL_SHOW_CUSTOMERS_BY_SECOND_NAME = "SELECT * FROM customers WHERE secondname = ? ORDER BY secondname ASC;";
    private static final String SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middlename = ? ORDER BY secondname ASC;";
    private static final String SQL_ADD_A_NEW_CUSTOMER = "INSERT INTO customers (secondname, firstname, middlename) VALUES (?, ?, ?) RETURNING *;";

    public MainForTest() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        CustomerService customerService = new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);

        // Основное меню
        while (true) {
            System.out.println("1 - Show all customers");
            System.out.println("2 - Show customers by the sample");
            System.out.println("3 - Add a new customer");
            System.out.println("4 - Change a customer");
            System.out.println("5 - Delete a customer");
            System.out.println("0 - Exit");

            int userCommand = scanner.nextInt();

            if (userCommand == 0) {
                // Выход из программы и освобождение ресурсов
                System.out.println("Exit from program.");
                scanner.close();
                System.exit(0);

            } else if (userCommand == 1) {
                // Показать всех клинтов
                List<Customer> customerList = customerService.getAllCustomers();

                for (Customer customer : customerList) {
                    System.out.println(customer);
                }
                System.out.println();

            } else if (userCommand == 2) {
                // Показать клиентов по выборке
                // Меню выборки
                while (true) {
                    System.out.println("Select a sample");
                    System.out.println("1 - id");
                    System.out.println("2 - First name");
                    System.out.println("3 - Last name");
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
                        String id = scanner.next();

                        List<Customer> customerList = customerService.getById(id);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                    } else if (userCommand == 2) {
                        // Выборка по имени
                        System.out.println("Insert the first name:");
                        String firstName = scanner.next();

                        List<Customer> customerList = customerService.getByFirstName(firstName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                    } else if (userCommand == 3) {
                        // Выборка по фамилии
                        System.out.println("Insert the last name:");
                        String secondName = scanner.next();

                        List<Customer> customerList = customerService.getBySecondName(secondName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                    } else if (userCommand == 4) {
                        // Выборка по отчеству
                        System.out.println("Insert the middle name:");
                        String middleName = scanner.next();

                        List<Customer> customerList = customerService.getByMiddleName(middleName);

                        for (Customer customer : customerList) {
                            System.out.println(customer);
                        }
                        System.out.println();

                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }

            } else if (userCommand == 3) {
                // Добавить нового клиента
//                PreparedStatement preparedStatement = connection.prepareStatement(SQL_ADD_A_NEW_CUSTOMER);
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
//                    preparedStatement.setString(i, dataAboutTheNewCustomer);
                }
//                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println("New customer's record has been added:");

//                while (resultSet.next()) {
//                    System.out.println(resultSet.getString("id") + " " +
//                            resultSet.getString("secondname") + " " +
//                            resultSet.getString("firstname") + " " +
//                            resultSet.getString("middlename"));
//                }
//                System.out.println();
//                resultSet.close();
//                preparedStatement.close();

            } else if (userCommand == 4) {
                // Изменить клиента
                System.out.println("Insert the customer's id:");
                String id = scanner.next();
                System.out.println("Enter the last name of the new customer:");
                String lastName = scanner.next();
                System.out.println("Enter the first name of the new customer:");
                String firstName = scanner.next();
                System.out.println("Enter the middle name of the new customer:");
                String middleName = scanner.next();

                List<Customer> customerList = customerService.update(id, firstName, lastName, middleName);

                System.out.println("The customer's record has been changed:");
                for (Customer customer : customerList) {
                    System.out.println(customer);
                }
                System.out.println();

            } else if (userCommand == 5) {
                // Удалить клиента
                System.out.println("Insert the customer's id:");
                String idCustomer = scanner.next();
                String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE id = '" + idCustomer + "' RETURNING *;";
//                Statement statement = connection.createStatement();
                // объект, который содержит результат SQL запроса
//                ResultSet result = statement.executeQuery(SQL_DELETE_A_CUSTOMER);
                System.out.println("The customer's record has been deleted:");

//                while (result.next()) {
//                    System.out.println(result.getString("id") + " " +
//                            result.getString("secondname") + " " +
//                            result.getString("firstname") + " " +
//                            result.getString("middlename"));
//                }
//                System.out.println();
//                result.close();
//                statement.close();
            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}