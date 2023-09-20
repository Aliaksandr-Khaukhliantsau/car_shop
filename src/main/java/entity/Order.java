package entity;

public class Order {
    private String id;
    private int orderNumber;
    private String idUser;
    private String idCar;

    public Order() {
    }

    public Order(String id, int orderNumber, String idUser, String idCar) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.idUser = idUser;
        this.idCar = idCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderNumber=" + orderNumber +
                ", idUser='" + idUser + '\'' +
                ", idCar='" + idCar + '\'' +
                '}';
    }
}
