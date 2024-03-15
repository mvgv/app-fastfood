package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoCanceladoTopicHandler implements TopicHandler {
    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pedido cancelado: " + message.toString());
       // pedidoService.notificaCliente(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
