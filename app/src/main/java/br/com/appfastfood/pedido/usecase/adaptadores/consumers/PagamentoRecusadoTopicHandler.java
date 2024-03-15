package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import com.amazonaws.services.sns.message.SnsMessage;

public class PagamentoRecusadoTopicHandler implements TopicHandler {

   // private final PedidoServico pedidoService;

   // private final CarrinhoServico carrinhoService;

    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pagamento recusado: " + message.toString());
        //pedidoService.cancelaPedido(message.getMessage());
        //carrinhoService.abrirCarrinho(message.getMessage());
    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
