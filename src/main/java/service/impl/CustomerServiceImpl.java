package service.impl;

import entity.Customer;
import repository.CustomerRepository;
import repository.impl.CustomerRepositoryImpl;
import service.CustomerService;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerServiceImpl implements CustomerService {

    public CustomerServiceImpl() throws SQLException {
    }

    CustomerRepository customerRepository = new CustomerRepositoryImpl();

    @Override
    public List<Customer> getAllCustomers() throws SQLException {
        ResultSet allCustomers = customerRepository.getAllCustomers();
        List<Customer> customerList = new ArrayList<>();

        while (allCustomers.next()) {
            Customer customer = new Customer();
            customer.setId(allCustomers.getString("id"));
            customer.setSecondName(allCustomers.getString("secondname"));
            customer.setFirstName(allCustomers.getString("firstname") );
            customer.setMiddleName(allCustomers.getString("middlename"));

            customerList.add(customer);

        }
        return customerList;
    }
}
