package br.com.appfastfood.pedido.usecase.adaptadores.consumers;

import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.portas.CarrinhoServico;
import com.amazonaws.services.sns.message.SnsMessage;

public class PagamentoEfetuadoTopicHandler implements TopicHandler {

    //private final CarrinhoServico carrinhoService;

    @Override
    public void handle(SnsMessage message) {
        System.out.println("Pagamento efetuado: " + message.toString());
       // carrinhoService.fechaCarrinho("a");

    }

    @Override
    public String getTopicId() {
        return "arn";
    }
}
