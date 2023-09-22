package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface CustomerRepository {

    // getById, getByName, update, create, delete, getAllCustomers

    ResultSet getById(String id) throws SQLException;

    ResultSet getByFirstName(String firstName) throws SQLException;

    ResultSet getBySecondName(String lastName) throws SQLException;

    ResultSet getByMiddleName(String middleName) throws SQLException;

    ResultSet create(String firstName, String lastName, String middleName) throws SQLException;

    ResultSet update(String id, String firstName, String lastName, String middleName) throws SQLException;

    ResultSet delete(String id) throws SQLException;

    ResultSet getAllCustomers() throws SQLException;
}
