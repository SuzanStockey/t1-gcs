import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AcquisitionRequest {
    int id;
    User solicitante;
    Department departamento_solicitante;
    Date data_pedido;
    Date data_termino;
    RequestStatus status;
    List<RequestItem> itens = new ArrayList<>();

    public AcquisitionRequest(int id, User solicitante) {
        this.id = id;
        this.solicitante = solicitante;
        departamento = solicitante.getDepartment();
        data_pedido = new Date();
        status = RequestStatus.OPEN;
    }
}
