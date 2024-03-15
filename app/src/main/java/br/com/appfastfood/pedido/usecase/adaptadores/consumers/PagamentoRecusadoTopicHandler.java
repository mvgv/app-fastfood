package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PagamentoRecusadoTopicHandler implements TopicHandler {

   // private final PedidoServico pedidoService;

   // private final CarrinhoServico carrinhoService;



    @Override
    public void publish(String message, String topicAddress) {

    }
}
