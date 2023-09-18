
//RAFAEL
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcquisitionSystem {
    List<Department> departments = new ArrayList<>();
    List<User> users = new ArrayList<>();
    List<AcquisitionRequest> requests = new ArrayList<>();
    User currentUser;

    public void addUser(User user) {
        users.add(user);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }
    // ACABA RAFAEL
}