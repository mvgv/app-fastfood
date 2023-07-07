package br.com.appfastfood.pedido.dominio.modelos.VO;

public class Produto {
    private String idProduto;
    private String quantidadeProduto;

    public Produto(String idProduto, String quantidadeProduto) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }
}
