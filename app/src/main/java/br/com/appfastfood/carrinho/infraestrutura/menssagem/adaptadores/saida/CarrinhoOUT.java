package br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida;

import br.com.appfastfood.carrinho.dominio.modelos.Cliente;
import br.com.appfastfood.carrinho.dominio.modelos.enums.StatusCarrinhoEnum;
import br.com.appfastfood.pedido.dominio.modelos.VO.ProdutoVO;

import java.util.List;

public class CarrinhoOUT {
    private Long id;
    private List<ProdutoOUT> produtos;
    private Cliente cliente;
    private Double valorTotal;
    private StatusCarrinhoEnum status;

    public CarrinhoOUT() {}

    public CarrinhoOUT(List<ProdutoOUT> produtos, Cliente cliente, Double valorTotal, StatusCarrinhoEnum status) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public CarrinhoOUT(List<ProdutoOUT> produtos, Cliente cliente, StatusCarrinhoEnum status) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.status = status;
    }

    public CarrinhoOUT(Long id, List<ProdutoOUT> produtos, Cliente cliente, Double valorTotal, StatusCarrinhoEnum status) {
        this.id = id;
        this.produtos = produtos;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public CarrinhoOUT(List<ProdutoOUT> produtos, Cliente cliente, Double valorTotal) {
        this.produtos = produtos;
        this.cliente = cliente;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ProdutoOUT> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoOUT> produtos) {
        this.produtos = produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusCarrinhoEnum getStatus() {
        return status;
    }

    public void setStatus(StatusCarrinhoEnum status) {
        this.status = status;
    }
}
