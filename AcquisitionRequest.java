import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcquisitionRequest {
    
    int id;
    User solicitante;
    Department departamento;
    Date data_pedido;
    Date data_termino;
    RequestStatus status;
    List<RequestItem> items = new ArrayList<>();

    public AcquisitionRequest(int id, User solicitante) {
        this.id = id;
        this.solicitante = solicitante;
        departamento = solicitante.getDepartment();
        data_pedido = new Date();
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

}
