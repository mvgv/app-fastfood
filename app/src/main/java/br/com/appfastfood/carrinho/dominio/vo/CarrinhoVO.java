package br.com.appfastfood.carrinho.dominio.vo;

public class CarrinhoVO {
    private String idProduto;
    private String quantidadeProduto;

    public CarrinhoVO(String idProduto, String quantidadeProduto) {
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
