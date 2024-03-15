package br.com.appfastfood.pedido.infraestrutura.menssagem.portas;
import com.amazonaws.services.sns.message.SnsMessage;


public interface TopicHandler {

    void handle(SnsMessage message);
    String getTopicId();
}
