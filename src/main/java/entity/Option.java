package entity;

public class Option {
    private String id;
    private String optionName;

    public Option() {
    }

    public Option(String id, String optionName) {
        this.id = id;
        this.optionName = optionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    @Override
    public String toString() {
        return "Option{" +
                "id='" + id + '\'' +
                ", optionName='" + optionName + '\'' +
                '}';
    }
}
