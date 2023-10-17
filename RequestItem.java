public class RequestItem {
    private String descricao;
    private double precoUnitario;
    private int quantidade;

    public RequestItem(String descricao, double precoUnitario, int quantidade) {
        this.descricao = descricao;
        this.precoUnitario = precoUnitario;
        this.quantidade = quantidade;
    }

    public double getTotal() {
        return precoUnitario * quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public int getQuantidade() {
        return quantidade;
    }
}