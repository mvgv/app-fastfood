package br.com.appfastfood.pedido.usecase.adaptadores.producers;


import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.portas.PagamentoServico;


public class PagamentoServicoImpl implements PagamentoServico {

    private TopicHandler snsTopic;

    public PagamentoServicoImpl(TopicHandler snsTopicHandler) {

        this.snsTopic = snsTopicHandler;
    }

    public PagamentoServicoImpl() {
    }
    public void efetuaPagamento(String message) {
        snsTopic.publish(message, "arn:aws:sns:us-east-1:000000000000:efetua-pagamento");
    }
}
