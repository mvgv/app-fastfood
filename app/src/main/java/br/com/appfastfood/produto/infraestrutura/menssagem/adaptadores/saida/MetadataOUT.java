package br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida;

public class MetadataOUT<T> {
    public T data;

    public MetadataOUT(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
