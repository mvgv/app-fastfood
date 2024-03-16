package br.com.appfastfood.configuracoes;

import br.com.appfastfood.AppFastfoodApplication;
import br.com.appfastfood.configuracoes.logs.Log;
import br.com.appfastfood.configuracoes.logs.Log4jLog;
import br.com.appfastfood.pedido.infraestrutura.menssagem.adaptadores.SNSTopicHandlerImpl;
import br.com.appfastfood.pedido.infraestrutura.menssagem.portas.TopicHandler;
import br.com.appfastfood.pedido.usecase.adaptadores.producers.PagamentoServicoImpl;
import br.com.appfastfood.pedido.usecase.adaptadores.producers.PedidoServicoImpl;
import br.com.appfastfood.pedido.usecase.portas.CarrinhoServico;
import br.com.appfastfood.pedido.usecase.portas.PagamentoServico;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
@ComponentScan(basePackageClasses = AppFastfoodApplication.class)
public class BeanConfiguration {

    @Bean
    public AmazonSNS amazonSNS() {
        // Configuração básica de um cliente AmazonSNS usando as credenciais padrão do SDK
        return AmazonSNSClientBuilder.standard()
                .withEndpointConfiguration(new AmazonSNSClientBuilder.EndpointConfiguration("http://localhost.localstack.cloud:4566", "us-east-1"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("test", "test")))
                .build();
    }

    @Bean
    TopicHandler topicHandler(){
        return new SNSTopicHandlerImpl(amazonSNS());
    }

    @Bean
    PedidoServico pedidoServico(){
        return new PedidoServicoImpl();
    }

    @Bean
    PagamentoServico pagamentoServico(TopicHandler handler){
        return new PagamentoServicoImpl(handler);
    }

    @Bean
    CarrinhoServico carrinhoServico(TopicHandler handler){
        return new CarrinhoServico(handler);
    }

    @Bean
    PedidoServico pedidoServico(TopicHandler handler){
        return new PedidoServicoImpl(handler);
    }

    @Bean
    Log log(){
        return new Log4jLog(BeanConfiguration.class);
    }
}
