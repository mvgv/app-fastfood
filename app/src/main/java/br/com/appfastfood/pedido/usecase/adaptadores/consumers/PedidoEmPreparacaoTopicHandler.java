package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoEmPreparacaoTopicHandler implements TopicHandler {
    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pedido em preparação: " + message.toString());
        //pedidoService.finalizaPedido(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
