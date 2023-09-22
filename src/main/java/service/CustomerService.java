package service;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {
    List<Customer> getAllCustomers() throws SQLException;

    List<Customer> getById(String id) throws SQLException;

    List<Customer> getByFirstName(String firstName) throws SQLException;

    List<Customer> getBySecondName(String lastName) throws SQLException;

    List<Customer> getByMiddleName(String middleName) throws SQLException;

    List<Customer> create(String firstName, String lastName, String middleName) throws SQLException;

    List<Customer> update(String id, String firstName, String lastName, String middleName) throws SQLException;

    List<Customer> delete(String id) throws SQLException;
}
