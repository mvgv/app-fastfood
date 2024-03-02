package br.com.appfastfood.pedido.infraestrutura.menssagem.adaptadores.entrada;

public class Metadata<T> {
    public T t;

    public Metadata(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
