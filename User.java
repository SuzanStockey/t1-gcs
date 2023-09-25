public class User {
    int id;
    String name;
    UserType type;
    Department department;

    public User(int id, String name, UserType type, Department department) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.department = department;
    }
}