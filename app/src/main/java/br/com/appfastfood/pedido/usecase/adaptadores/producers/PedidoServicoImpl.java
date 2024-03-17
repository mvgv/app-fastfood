package br.com.appfastfood.pedido.usecase.adaptadores.producers;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.infraestrutura.menssagem.requisicao.PedidoEventoRequisicao;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PedidoServicoImpl implements PedidoServico {

    private final TopicHandler snsTopic;
    private final ObjectMapper objectMapper;

    public PedidoServicoImpl(TopicHandler snsTopicHandler, ObjectMapper object) {

        this.snsTopic = snsTopicHandler;
        this.objectMapper = object;
    }

    @Override
    public String criar(PedidoRequisicao pedido) throws JsonProcessingException {
        String pedidoJson = objectMapper.writeValueAsString(pedido);
        snsTopic.publish(pedidoJson, "arn:aws:sns:us-east-1:000000000000:cria-pedido");
        return pedido.getIdPedido();
    }

    @Override
    public void preparaPedido(String pedido)  {
        try {
            PedidoEventoRequisicao dto = objectMapper.readValue(pedido, PedidoEventoRequisicao.class);
            snsTopic.publish(pedido, "arn:aws:sns:us-east-1:000000000000:prepara-pedido");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void finalizaPedido(String pedido) {
        try {
            PedidoEventoRequisicao dto = objectMapper.readValue(pedido, PedidoEventoRequisicao.class);
            snsTopic.publish(pedido, "arn:aws:sns:us-east-1:000000000000:finaliza-pedido");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void cancelaPedido(String pedido) {
        try {
            PedidoEventoRequisicao dto = objectMapper.readValue(pedido, PedidoEventoRequisicao.class);
            snsTopic.publish(pedido, "arn:aws:sns:us-east-1:000000000000:cancela-pedido");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }



}
