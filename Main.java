
//RAFAEL
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AcquisitionSystem system = new AcquisitionSystem();
        // ACABA RAFAEL

        // Carol
        Department finance = new Department("Finance", 1000);
        Department rh = new Department("RH", 800);
        Department engineering = new Department("Engineering", 1500);
        Department maintenance = new Department("Manutenção", 1200);
        Department diretoria = new Department("Diretoria", 900);
        // Acaba Carol

        // RAFAEL
        system.addDepartment(finance);
        system.addDepartment(rh);
        system.addDepartment(engineering);
        system.addDepartment(maintenance);
        system.addDepartment(diretoria);

        system.addUser(admin);
        system.addUser(employee1);
        system.addUser(employee2);
        system.addUser(employee3);
        system.addUser(employee4);
        system.addUser(employee5);
        system.addUser(employee6);
        system.addUser(employee7);
        system.addUser(employee8);
        system.addUser(employee9);
        system.addUser(employee10);
        system.addUser(employee11);
        system.addUser(employee12);
        system.addUser(employee13);
        system.addUser(employee14);
        // ACABA RAFAEL

        List<RequestItem> requestItems = new ArrayList<>();
        requestItems.add(new RequestItem("Item 1", 100, 2));
        requestItems.add(new RequestItem("Item 2", 50, 3));

        system.createRequest(employee1, finance, requestItems);
        system.evaluateRequest(admin, system.requests.get(0), RequestStatus.APPROVED);

        system.displayGeneralStatistics();
        system.displayLast30DaysStatistics();
        system.displayGeneralStatistics();

        AcquisitionRequest largestOpenRequest = system.findLargestOpenRequest();
        if (largestOpenRequest != null) {
            System.out.println("Largest Open Request:");
            system.viewRequestDetails(largestOpenRequest);
        } else {
            System.out.println("No open requests found.");
        }
    }
}