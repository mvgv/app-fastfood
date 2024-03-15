package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoFinalizadoTopicHandler implements TopicHandler {

    public String getTopicId() {
        return "arn";
    }

    @Override
    public void publish(String message, String topicAddress) {

    }
}
