public class User {
    private int id;
    private String name;
    private UserType type;
    private Department department;

    public User(int id, String name, UserType type, Department department) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }
}