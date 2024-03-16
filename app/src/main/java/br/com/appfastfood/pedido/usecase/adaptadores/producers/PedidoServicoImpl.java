package br.com.appfastfood.pedido.usecase.adaptadores.producers;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.dominio.modelos.Pedido;
import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;

import java.util.List;

public class PedidoServicoImpl implements PedidoServico {

    private TopicHandler snsTopic;

    public PedidoServicoImpl(TopicHandler snsTopicHandler) {
        this.snsTopic = snsTopicHandler;
    }

    @Override
    public String criar(PedidoRequisicao pedido, String status, String tempo) {
        snsTopic.publish(pedido.toString(), "arn:aws:sns:us-east-1:000000000000:cria-pedido");
        return pedido.toString();
    }

    @Override
    public void preparaPedido(Long id) {
        snsTopic.publish(id.toString(), "arn:aws:sns:us-east-1:000000000000:prepara-pedido");
    }

    @Override
    public void finalizaPedido(Long id) {
        snsTopic.publish(id.toString(), "arn:aws:sns:us-east-1:000000000000:finaliza-pedido";
    }

    @Override
    public void cancelaPedido(Long id) {
        snsTopic.publish(id.toString(), "arn:aws:sns:us-east-1:000000000000:cancela-pedido");
    }


    @Override
    public List<Pedido> listarTodosPedidos() {
        return null;
    }


}
