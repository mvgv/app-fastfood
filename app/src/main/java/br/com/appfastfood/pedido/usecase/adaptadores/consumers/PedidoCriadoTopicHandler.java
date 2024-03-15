package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoCriadoTopicHandler implements TopicHandler {
    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pedido criado: " + message.toString());
        //pagamentoService.efetuaPagamento(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn:aws:sns:us-east-1:101478099523:PedidoCriado";
    }
}
