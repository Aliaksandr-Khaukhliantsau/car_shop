package entity;

public class Order {
    private String id;
    private int number;
    private String idUser;
    private String idCar;

    public Order() {
    }

    public Order(String id, int number, String idUser, String idCar) {
        this.id = id;
        this.number = number;
        this.idUser = idUser;
        this.idCar = idCar;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
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
                ", number=" + number +
                ", idUser='" + idUser + '\'' +
                ", idCar='" + idCar + '\'' +
                '}';
    }
}
