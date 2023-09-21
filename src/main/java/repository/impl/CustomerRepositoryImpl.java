package repository.impl;

import repository.CustomerRepository;

import java.sql.*;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final String POSTGRES_URL = "jdbc:postgresql://localhost:5432/car_shop";
    private static final String POSTGRES_USER = "postgres";
    private static final String POSTGRES_PASSWORD = "12345678";
    private static final String SQL_SHOW_ALL_CUSTOMERS = "SELECT * FROM customers ORDER BY secondname ASC;";

    private final Connection connection;

    public CustomerRepositoryImpl() throws SQLException {
        connection = DriverManager.getConnection(POSTGRES_URL, POSTGRES_USER, POSTGRES_PASSWORD);
    }

    // getById, getByName, update, create, delete, getAllCustomers
    @Override
    public ResultSet getById(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_ID = "SELECT * FROM customers WHERE id = " + "'" + id + "'" + " ORDER BY secondname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_ID);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByFirstName(String firstName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_FIRST_NAME = "SELECT * FROM customers WHERE firstname = " + "'" + firstName + "'" + " ORDER BY secondname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_FIRST_NAME);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getBySecondName(String secondName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_SECOND_NAME = "SELECT * FROM customers WHERE secondname = " + "'" + secondName + "'" + " ORDER BY secondname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_SECOND_NAME);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getByMiddleName(String middleName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME = "SELECT * FROM customers WHERE middlename = '" + middleName + "' ORDER BY secondname ASC;";
        ResultSet resultSet = statement.executeQuery(SQL_SHOW_CUSTOMERS_BY_MIDDLE_NAME);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet create(String firstName, String secondName, String middleName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_ADD_A_NEW_CUSTOMER = "INSERT INTO customers (secondname, firstname, middlename) VALUES (" + secondName + ", " + firstName + ", " + middleName + ");";
        ResultSet resultSet = statement.executeQuery(SQL_ADD_A_NEW_CUSTOMER);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet update(String id, String firstName, String secondName, String middleName) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_CHANGE_A_CUSTOMER = "UPDATE customers SET secondname = " + secondName + ", firstname = " + firstName + ", middlename = " + middleName + " WHERE id = '" + id + "';";
        ResultSet resultSet = statement.executeQuery(SQL_CHANGE_A_CUSTOMER);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet delete(String id) throws SQLException {
        Statement statement = connection.createStatement();
        String SQL_DELETE_A_CUSTOMER = "DELETE FROM customers WHERE id = '" + id + "' RETURNING *;";
        ResultSet resultSet = statement.executeQuery(SQL_DELETE_A_CUSTOMER);
        statement.close();
        return resultSet;
    }

    @Override
    public ResultSet getAllCustomers() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(SQL_SHOW_ALL_CUSTOMERS);
        statement.close();
        return result;
    }
}
