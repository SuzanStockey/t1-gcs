
//RAFAEL
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        AcquisitionSystem system = new AcquisitionSystem();

        Department finance = new Department("Finance", 1000);
        Department rh = new Department("RH", 800);
        Department engineering = new Department("Engineering", 1500);
        Department maintenance = new Department("Manutenção", 1200);
        Department diretoria = new Department("Diretoria", 900);

        system.addDepartment(finance);
        system.addDepartment(rh);
        system.addDepartment(engineering);
        system.addDepartment(maintenance);
        system.addDepartment(diretoria);

        User admin = new User(1, "Mariana Pereira", UserType.ADMINISTRATOR, diretoria);

        User employee1 = new User(2, "Ana Silva", UserType.EMPLOYEE, finance);
        User employee2 = new User(3, "Carlos Santos", UserType.EMPLOYEE, finance);
        User employee3 = new User(4, "Maria Oliveira", UserType.EMPLOYEE, finance);
        User employee4 = new User(5, "João Souza", UserType.EMPLOYEE, rh);
        User employee5 = new User(6, "Fernanda Lima", UserType.EMPLOYEE, rh);
        User employee6 = new User(7, "Pedro Alves", UserType.EMPLOYEE, rh);
        User employee7 = new User(8, "Juliana Pereira", UserType.EMPLOYEE, engineering);
        User employee8 = new User(9, "Rafael Mendes", UserType.EMPLOYEE, engineering);
        User employee9 = new User(10, "Larissa Costa", UserType.EMPLOYEE, engineering);
        User employee10 = new User(11, "Lucas Gomes", UserType.EMPLOYEE, maintenance);
        User employee11 = new User(12, "Camila Santos", UserType.EMPLOYEE, maintenance);
        User employee12 = new User(13, "Bruno Oliveira", UserType.EMPLOYEE, maintenance);
        User employee13 = new User(14, "Aline Lima", UserType.EMPLOYEE, diretoria);
        User employee14 = new User(15, "Gustavo Alves", UserType.EMPLOYEE, diretoria);

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

        system.setCurrentUser(employee1);


        List<RequestItem> requestItems1 = new ArrayList<>();
        requestItems1.add(new RequestItem("Item 1", 100, 2));
        requestItems1.add(new RequestItem("Item 2", 50, 3));

        system.createRequest(employee1, finance, requestItems1);
        system.evaluateRequest(admin, system.requests.get(0), RequestStatus.APPROVED);

        List<RequestItem> requestItems2 = new ArrayList<>();

        requestItems2.add(new RequestItem("Item 3", 40, 5));
        requestItems2.add(new RequestItem("Item 4", 90, 6));

        system.createRequest(employee1, finance, requestItems2);
        system.evaluateRequest(admin, system.requests.get(1), RequestStatus.REJECTED);
        List<RequestItem> requestItems3 = new ArrayList<>();

        requestItems3.add(new RequestItem("Item 1", 66.6, 1));
        requestItems3.add(new RequestItem("Item 2", 44.8, 9));

        system.createRequest(employee1, finance, requestItems3);

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