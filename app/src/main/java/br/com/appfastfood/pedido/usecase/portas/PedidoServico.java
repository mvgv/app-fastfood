package br.com.appfastfood.pedido.usecase.portas;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;


public interface PedidoServico {

    String criar(PedidoRequisicao pedido) throws JsonProcessingException;
    void preparaPedido(Long id);
    void finalizaPedido(Long id);

    void cancelaPedido(Long id);
    List<Pedido> listarTodosPedidos();
}
