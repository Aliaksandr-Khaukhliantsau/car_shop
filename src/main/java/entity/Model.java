package entity;

public class Model {
    private String id;
    private String modelName;
    private String idCompletion;

    public Model() {
    }

    public Model(String id, String modelName, String idCompletion) {
        this.id = id;
        this.modelName = modelName;
        this.idCompletion = idCompletion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getIdCompletion() {
        return idCompletion;
    }

    public void setIdCompletion(String idCompletion) {
        this.idCompletion = idCompletion;
    }

    @Override
    public String toString() {
        return "Model{" +
                "id='" + id + '\'' +
                ", modelName='" + modelName + '\'' +
                ", idCompletion='" + idCompletion + '\'' +
                '}';
    }
}
