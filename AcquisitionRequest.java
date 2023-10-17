import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcquisitionRequest {
    
    private int id;
    private User solicitante;
    private Department departamento;
    private Date dataPedido;
    private Date dataTermino;
    private RequestStatus status;
    private List<RequestItem> items = new ArrayList<>();

    public AcquisitionRequest(int id, User solicitante) {
        this.id = id;
        this.solicitante = solicitante;
        departamento = solicitante.getDepartment();
        dataPedido = new Date();
        status = RequestStatus.OPEN;
    }

    public double getTotalAmount() {
        double total = 0;
        for (RequestItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    public void addItem(RequestItem item) {
        if (status == RequestStatus.OPEN) {
            items.add(item);
        } else {
            System.out.println(
                    "Não é possivel adicionar item.");
        }
    }

    public boolean canBeDeleted(User user) {
        return status == RequestStatus.OPEN && user == solicitante;
    }

    public int getId() {
        return id;
    }

    public User getSolicitante() {
        return solicitante;
    }

    public Department getDepartamento() {
        return departamento;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public Date getDataTermino() {
        return dataTermino;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }

    public List<RequestItem> getItems() {
        return items;
    }
}
