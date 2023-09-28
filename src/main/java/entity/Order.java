package entity;

public class Order {
    private String id;
    private int number;
    private String idCustomer;
    private String idCar;

    public Order() {
    }

    public Order(String id, int number, String idCustomer, String idCar) {
        this.id = id;
        this.number = number;
        this.idCustomer = idCustomer;
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

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
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
                ", idCustomer='" + idCustomer + '\'' +
                ", idCar='" + idCar + '\'' +
                '}';
    }
}
