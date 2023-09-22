package service;

import entity.Customer;

import java.sql.SQLException;
import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers() throws SQLException;
}
