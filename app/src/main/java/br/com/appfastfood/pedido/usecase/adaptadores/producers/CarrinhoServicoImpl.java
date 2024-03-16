package br.com.appfastfood.pedido.usecase.adaptadores.producers;

import br.com.appfastfood.pedido.aplicacao.adaptadores.requisicao.PedidoRequisicao;
import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.portas.CarrinhoServico;

public class CarrinhoServicoImpl implements CarrinhoServico {

    private final TopicHandler snsTopic;

    public CarrinhoServicoImpl(TopicHandler snsTopicHandler) {
        this.snsTopic = snsTopicHandler;
    }
    @Override
    public void fechaCarrinho(String message) {
        snsTopic.publish(message, "arn:aws:sns:us-east-1:000000000000:fecha-carrinho");
    }
}
