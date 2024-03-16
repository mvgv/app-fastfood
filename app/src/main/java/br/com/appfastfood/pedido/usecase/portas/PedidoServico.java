package br.com.appfastfood.pedido.usecase.portas;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;

import java.util.List;


public interface PedidoServico {

    String criar(PedidoRequisicao pedido, String status, String tempo);
    void preparaPedido(Long id);
    void finalizaPedido(Long id);

    void cancelaPedido(Long id);
    List<Pedido> listarTodosPedidos();
}
