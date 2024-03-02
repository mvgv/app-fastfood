package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.entrada;

public class ProdutoBuscarPorCategoriaIN {
    private String categoria;

    public ProdutoBuscarPorCategoriaIN(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
