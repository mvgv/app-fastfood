package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida;

public class ProdutoPorIdOUT {
    private String idProduto;
    private String quantidadeProduto;
    private String nome;
    private Double preco;
    private String categoria;
    private String uriImagem;
    private String descricao;

    public ProdutoPorIdOUT(String idProduto, String quantidadeProduto) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    public ProdutoPorIdOUT(String idProduto, String quantidadeProduto, String nome, Double preco, String categoria,
                           String uriImagem, String descricao) {
        this.idProduto = idProduto;
        this.quantidadeProduto = quantidadeProduto;
        this.nome = nome;
        this.preco = preco;
        this.categoria = categoria;
        this.uriImagem = uriImagem;
        this.descricao = descricao;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public void setQuantidadeProduto(String quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getUriImagem() {
        return uriImagem;
    }

    public void setUriImagem(String uriImagem) {
        this.uriImagem = uriImagem;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public String getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}