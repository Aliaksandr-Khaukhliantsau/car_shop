package service;

import entity.Order;

import java.sql.SQLException;
import java.util.List;

public interface OrderService {

    List<Order> getById(String id) throws SQLException;

    List<Order> getByNumber(int number) throws SQLException;

    List<Order> getByCustomer(String idUser) throws SQLException;

    List<Order> getByIdCar(String idCar) throws SQLException;

    List<Order> getAllOrders() throws SQLException;

    List<Order> create(String idUser, String idCar) throws SQLException;

    List<Order> update(String id, String idUser, String idCar) throws SQLException;

    List<Order> delete(String id) throws SQLException;
}
