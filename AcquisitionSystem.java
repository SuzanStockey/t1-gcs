
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

        if (evaluator.getType() != UserType.ADMINISTRATOR) {
            System.out.println("Only administrators can evaluate requests.");
            return;
        }

        if (request.getStatus().equals(RequestStatus.OPEN)) {
            System.out.println("Request has already been evaluated.");
            return;
        }

        request.setStatus(status);

        if (status == RequestStatus.APPROVED) {
            System.out.println("Request approved.");
        } else if (status == RequestStatus.REJECTED) {
            System.out.println("Request rejected.");
        }
    }

    public void createRequest(User requester, Department department, List<RequestItem> items) {
        if (requester == null || department == null || items == null || items.isEmpty()) {
            System.out.println("Invalid request.");
            return;
        }

        if (requester.getDepartment() != department) {
            System.out.println("Employee's department must match the request department.");
            return;
        }

        double totalAmount = 0;
        for (RequestItem item : items) {
            totalAmount += item.getTotal();
        }

        if (totalAmount > department.getMaxRequestAmount()) {
            System.out.println("Request amount exceeds department limit.");
            return;
        }

        AcquisitionRequest request = new AcquisitionRequest(requests.size() + 1, requester);
        request.getItems().addAll(items);
        requests.add(request);

        System.out.println("Request created successfully.");
    }

    public List<AcquisitionRequest> getRequestsBetweenDates(Date startDate, Date endDate) {

        List<AcquisitionRequest> requestsBetweenDates = new ArrayList<>();

        for (AcquisitionRequest request : requests) {
            Date requestDate = request.getDataPedido();
            if (requestDate.after(startDate) && requestDate.before(endDate)) {
                requestsBetweenDates.add(request);
            }
        }

        return requestsBetweenDates;
    }

    public List<AcquisitionRequest> getRequestsByRequester(User requester) {
        List<AcquisitionRequest> requestsByRequester = new ArrayList<>();

        for (AcquisitionRequest request : requests) {
            if (request.getSolicitante().equals(requester)) {
                requestsByRequester.add(request);
            }
        }

        return requestsByRequester;
    }

    public List<AcquisitionRequest> getRequestsByItemDescription(String itemDescription) {
        List<AcquisitionRequest> requestsByItemDescription = new ArrayList<>();

        for (AcquisitionRequest request : requests) {
            for (RequestItem item : request.getItems()) {
                if (item.getDescricao().equalsIgnoreCase(itemDescription)) {
                    requestsByItemDescription.add(request);
                    break; // Para não adicionar o mesmo pedido várias vezes
                }
            }
        }

        return requestsByItemDescription;
    }

    public void viewRequestDetails(AcquisitionRequest request) {
        if (request != null) {
            System.out.println("Request ID: " + request.getId());
            System.out.println("Requester: " + request.getSolicitante().getName());
            System.out.println("Department: " + request.getDepartamento().getName());
            System.out.println("Request Date: " + request.getDataPedido());
            System.out.println("Total Amount: " + request.getTotalAmount());
            System.out.println("Status: " + request.getStatus());

            // Imprimir detalhes dos itens
            System.out.println("Items:");
            for (RequestItem item : request.getItems()) {
                System.out.println("  Description: " + item.getDescricao());
                System.out.println("  Unit Price: " + item.getPrecoUnitario());
                System.out.println("  Quantity: " + item.getQuantidade());
                System.out.println("  Total: " + item.getTotal());
                System.out.println();
            }
        } else {
            System.out.println("Invalid request.");
        }
    }

    public void deleteRequest(User user, AcquisitionRequest request) {
        if (request == null) {
            System.out.println("Invalid request.");
            return;
        }

        if (request.canBeDeleted(user)) {
            requests.remove(request);
            System.out.println("Request deleted successfully.");
        } else {
            System.out.println("You cannot delete this request.");
        }
    }

    public void displayGeneralStatistics() {
        int totalRequests = requests.size();
        int approvedRequests = 0;
        int rejectedRequests = 0;

        for (AcquisitionRequest request : requests) {
            if (request.getStatus() == RequestStatus.APPROVED) {
                approvedRequests++;
            } else if (request.getStatus() == RequestStatus.REJECTED) {
                rejectedRequests++;
            }
        }

        double approvalPercentage = (double) approvedRequests / totalRequests * 100;
        double rejectionPercentage = (double) rejectedRequests / totalRequests * 100;

        System.out.println("General Statistics:");
        System.out.println("Total Requests: " + totalRequests);
        System.out.println("Approved Requests: " + approvedRequests + " (" + approvalPercentage + "%)");
        System.out.println("Rejected Requests: " + rejectedRequests + " (" + rejectionPercentage + "%)");
    }

    public void displayLast30DaysStatistics() {
        Date currentDate = new Date();
        long thirtyDaysInMillis = 30 * 24 * 60 * 60 * 1000L; // 30 dias em milissegundos
        long thirtyDaysAgoInMillis = currentDate.getTime() - thirtyDaysInMillis;
        Date thirtyDaysAgo = new Date(thirtyDaysAgoInMillis);

        int requestsLast30Days = 0;
        double totalValueLast30Days = 0;

        for (AcquisitionRequest request : requests) {
            if (request.getDataPedido().after(thirtyDaysAgo)) {
                requestsLast30Days++;
                totalValueLast30Days += request.getTotalAmount();
            }
        }

        double averageValueLast30Days = totalValueLast30Days / requestsLast30Days;

        System.out.println("Statistics for the Last 30 Days:");
        System.out.println("Number of Requests: " + requestsLast30Days);
        System.out.println("Average Value: " + averageValueLast30Days);
    }

    public AcquisitionRequest findLargestOpenRequest() {
        AcquisitionRequest largestOpenRequest = null;
        double largestAmount = 0;

        for (AcquisitionRequest request : requests) {
            if (request.getStatus() == RequestStatus.OPEN) {
                double requestAmount = request.getTotalAmount();
                if (requestAmount > largestAmount) {
                    largestAmount = requestAmount;
                    largestOpenRequest = request;
                }
            }
        }

        return largestOpenRequest;
    }

}
