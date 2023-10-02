public class RequestItem {
    String descricao;
    double precoUnitario;
    int quantidade;

    public RequestItem(String descricao, double precoUnitario, int quantidade) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return precoUnitario * quantidade;
    }
}