package entity;

public class CompletionCarOption {
    private String idCompletion;
    private String idOption;

    public CompletionCarOption() {
    }

    public CompletionCarOption(String idCompletion, String idOption) {
        this.idCompletion = idCompletion;
        this.idOption = idOption;
    }

    public String getIdCompletion() {
        return idCompletion;
    }

    public void setIdCompletion(String idCompletion) {
        this.idCompletion = idCompletion;
    }

    public String getIdOption() {
        return idOption;
    }

    public void setIdOption(String idOption) {
        this.idOption = idOption;
    }

    @Override
    public String toString() {
        return "CompletionCarOption{" +
                "idCompletion='" + idCompletion + '\'' +
                ", idOption='" + idOption + '\'' +
                '}';
    }
}
