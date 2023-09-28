package repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface OrderRepository {

    ResultSet getById(String id) throws SQLException;

    ResultSet getByNumber(int number) throws SQLException;

    ResultSet getByIdUser(String idUser) throws SQLException;

    ResultSet getByIdCar(String idCar) throws SQLException;

    ResultSet getAllOrders() throws SQLException;

    ResultSet create(String idUser, String idCar) throws SQLException;

    ResultSet update(String id, String idUser, String idCar) throws SQLException;

    ResultSet delete(String id) throws SQLException;
}
