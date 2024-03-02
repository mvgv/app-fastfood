package br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.entrada;

public class MetadataIN<T> {
    public T t;

    public MetadataIN(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
