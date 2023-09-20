package entity;

public class Completion {
    private String id;
    private String completionName;

    public Completion() {
    }

    public Completion(String id, String completionName) {
        this.id = id;
        this.completionName = completionName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompletionName() {
        return completionName;
    }

    public void setCompletionName(String completionName) {
        this.completionName = completionName;
    }

    @Override
    public String toString() {
        return "Completion{" +
                "id='" + id + '\'' +
                ", completionName='" + completionName + '\'' +
                '}';
    }
}
