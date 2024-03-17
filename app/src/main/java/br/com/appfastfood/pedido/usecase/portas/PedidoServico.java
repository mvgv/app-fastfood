package br.com.appfastfood.pedido.usecase.portas;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import com.fasterxml.jackson.core.JsonProcessingException;


public interface PedidoServico {

    String criar(PedidoRequisicao pedido) throws JsonProcessingException;
    void preparaPedido(String id);
    void finalizaPedido(String id);

    void cancelaPedido(String id);

}
