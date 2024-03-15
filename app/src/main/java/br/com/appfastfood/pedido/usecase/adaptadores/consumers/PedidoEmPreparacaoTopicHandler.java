package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoEmPreparacaoTopicHandler implements TopicHandler {

    @Override
    public void publish(String message, String topicAddress) {

    }
}
