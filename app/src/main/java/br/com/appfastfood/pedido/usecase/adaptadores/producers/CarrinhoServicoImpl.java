package br.com.appfastfood.pedido.usecase.adaptadores.producers;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.infraestrutura.menssagem.requisicao.CarrinhoDTO;
import br.com.appfastfood.pedido.usecase.portas.CarrinhoServico;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CarrinhoServicoImpl implements CarrinhoServico {

    private final TopicHandler snsTopic;
    private ObjectMapper objectMapper = new ObjectMapper();

    public CarrinhoServicoImpl(TopicHandler snsTopicHandler) {
        this.snsTopic = snsTopicHandler;
    }
    @Override
    public void fechaCarrinho(String message) {
        try {
            CarrinhoDTO dto = objectMapper.readValue(message, CarrinhoDTO.class);
            snsTopic.publish(objectMapper.writeValueAsString(dto), "arn:aws:sns:us-east-1:000000000000:fecha-carrinho");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
