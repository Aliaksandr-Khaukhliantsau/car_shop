package service.impl;

import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;

import java.sql.SQLException;

public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl() throws SQLException {
    }

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    // getCustomer
}
