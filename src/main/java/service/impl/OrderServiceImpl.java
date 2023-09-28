package service.impl;

import entity.Order;
import repository.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.OrderService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    OrderRepository orderRepository = new OrderRepositoryImpl();

    public OrderServiceImpl() throws SQLException {
    }

    @Override
    public List<Order> getById(String id) throws SQLException {
        ResultSet resultSet = orderRepository.getById(id);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getByNumber(int number) throws SQLException {
        ResultSet resultSet = orderRepository.getByNumber(number);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getByCustomer(String idUser) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdUser(idUser);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getByIdCar(String idCar) throws SQLException {
        ResultSet resultSet = orderRepository.getByIdCar(idCar);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> getAllOrders() throws SQLException {
        ResultSet resultSet = orderRepository.getAllOrders();
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> create(String idUser, String idCar) throws SQLException {
        ResultSet resultSet = orderRepository.create(idUser, idCar);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> update(String id, String idUser, String idCar) throws SQLException {
        ResultSet resultSet = orderRepository.update(id, idUser, idCar);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }

    @Override
    public List<Order> delete(String id) throws SQLException {
        ResultSet resultSet = orderRepository.delete(id);
        List<Order> orderList = new ArrayList<>();

        while (resultSet.next()) {
            Order order = new Order();
            order.setId(resultSet.getString("id"));
            order.setNumber(resultSet.getInt("number"));
            order.setIdCustomer(resultSet.getString("idcustomer"));
            order.setIdCar(resultSet.getString("idcar"));

            orderList.add(order);
        }
        return orderList;
    }
}
