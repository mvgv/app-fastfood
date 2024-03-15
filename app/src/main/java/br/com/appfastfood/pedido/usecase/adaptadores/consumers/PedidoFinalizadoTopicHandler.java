package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PedidoFinalizadoTopicHandler implements TopicHandler {
    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pedido finalizado: " + message.toString());
        //clienteService.getCliente(message.getMessage());
        //pedidoService.notificaCliente(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
