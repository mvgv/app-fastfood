package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.entrada;

public class ProdutoRemoverIN {
    private Long id;
    public ProdutoRemoverIN(Long id) {
        this.id = id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

}
