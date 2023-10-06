
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
    public void setCurrentUser(User user) {
        currentUser = user;
    }
    public void evaluateRequest(User evaluator, AcquisitionRequest request, RequestStatus status) {
        if (evaluator == null || request == null || status == null) {
            System.out.println("Invalid evaluation.");
            return;
        }

        if (evaluator.type != UserType.ADMINISTRATOR) {
            System.out.println("Only administrators can evaluate requests.");
            return;
        }

        if (request.status.equals(RequestStatus.OPEN)) {
            System.out.println("Request has already been evaluated.");
            return;
        }

        request.status = status;

        if (status == RequestStatus.APPROVED) {
            System.out.println("Request approved.");
        } else if (status == RequestStatus.REJECTED) {
            System.out.println("Request rejected.");
        }
    }

}
