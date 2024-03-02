package br.com.appfastfood.pedido.infraestrutura.menssagem.adaptadores.entrada;

public class SNSContrato {

    public String metodo;
    public String descricao;
    public Metadata metadata;

    public SNSContrato(String metodo, String descricao, Metadata metadata) {
        this.metodo = metodo;
        this.descricao = descricao;
        this.metadata = metadata;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }
}
