package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida;

public class MetadataOUT<T> {
    public T t;

    public MetadataOUT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
