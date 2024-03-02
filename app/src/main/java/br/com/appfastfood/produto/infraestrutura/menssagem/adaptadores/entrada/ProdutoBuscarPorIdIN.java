package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.entrada;

public class ProdutoBuscarPorIdIN {
    private Long id;

    public ProdutoBuscarPorIdIN(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
