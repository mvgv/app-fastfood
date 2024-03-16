package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.portas.CarrinhoServico;
import com.amazonaws.services.sns.message.SnsMessage;

public class exiPagamentoEfetuadoTopicHandler implements TopicHandler {

    //private final CarrinhoServico carrinhoService;



    @Override
    public void publish(String message, String topicAddress) {

    }
}
