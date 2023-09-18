import java.sql.*;
import java.util.Scanner;

public class Main {
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/postgres";

    public static void main(String[] args) throws SQLException {

        Connection connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Show all customers");
            System.out.println("2 - Show customers by the sample");
            System.out.println("3 - Change a customer");
            System.out.println("3 - Add a customer");
            System.out.println("0 - Exit");

            int userCommand = sc.nextInt();

            if (userCommand == 0) {
                sc.close();
                connection.close();
                System.out.println("Exit from program.");
                System.exit(0);
            } else if (userCommand == 1) {
                Statement statement = connection.createStatement();
                String SQL_SHOW_CUSTOMERS = "SELECT * FROM customers ORDER BY secondname ASC";
                ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS);

                while (result.next()) {
                    System.out.println(result.getString("id") + " " +
                            result.getString("secondname") + " " +
                            result.getString("firstname") + " " +
                            result.getString("middlename"));
                }
                System.out.println();
            } else if (userCommand == 2) {
                while (true) {
                    System.out.println("Select a sample");
                    System.out.println("1 - id");
                    System.out.println("2 - Second name");
                    System.out.println("3 - First name");
                    System.out.println("4 - Middle name");
                    System.out.println("0 - Cancel");

                    userCommand = sc.nextInt();

                    if (userCommand == 0) {
                        System.out.println("Exit to the previous menu.\n");
                        break;
                    } else if (userCommand == 1) {
                        System.out.println("Insert the id:");
                        String idCustomer = sc.nextLine();
                        String SQL_SHOW_CUSTOMERS_BY_ID = "SELECT * FROM customers WHERE id = " + "'" + idCustomer + "'"; //????
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_ID);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                    } else if (userCommand == 2) {
                        System.out.println("Insert the secondname:");
                        String secondName = sc.next();
                        String SQL_SHOW_CUSTOMERS_BY_SECOND_NAME = "SELECT * FROM customers WHERE secondname = " + "'" + secondName + "'"; //????
                        Statement statement = connection.createStatement();
                        ResultSet result = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_SECOND_NAME);

                        while (result.next()) {
                            System.out.println(result.getString("id") + " " +
                                    result.getString("secondname") + " " +
                                    result.getString("firstname") + " " +
                                    result.getString("middlename"));
                        }
                        System.out.println();
                    } else if (userCommand == 3) {
                        // доделать
                        System.out.println("Нужно доделать!!!");
                    } else if (userCommand == 4) {
                        // доделать
                        System.out.println("Нужно доделать!!!");
                    } else {
                        System.err.println("Unknown Command!\n");
                    }
                }
            } else if (userCommand == 3) {
                System.out.println("Insert customer's id:");
                String idCustomer = sc.nextLine();
                String SQL_CHANGE_CUSTOMER = "";
                // доделать
            } else {
                System.err.println("Unknown Command!\n");
            }
        }
    }
}