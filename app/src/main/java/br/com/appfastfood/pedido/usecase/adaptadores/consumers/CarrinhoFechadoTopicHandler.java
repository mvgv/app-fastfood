package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class CarrinhoFechadoTopicHandler implements TopicHandler {
    @Override
    public void handle(SnsMessage message) {
        System.out.println("Carrinho fechado: " + message.toString());
       // pedidoService.preparaPedido(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
