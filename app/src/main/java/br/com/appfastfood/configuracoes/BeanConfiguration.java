package br.com.appfastfood.configuracoes;

import br.com.appfastfood.AppFastfoodApplication;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.CarrinhoFila;
import br.com.appfastfood.carrinho.usecase.adaptadores.CarrinhoServicoImpl;
import br.com.appfastfood.carrinho.usecase.portas.CarrinhoServico;
import br.com.appfastfood.configuracoes.logs.Log;
import br.com.appfastfood.configuracoes.logs.Log4jLog;
import br.com.appfastfood.pedido.usecase.adaptadores.PedidoServicoImpl;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;
import br.com.appfastfood.produto.infraestrutura.menssagem.ProdutoFila;
import br.com.appfastfood.produto.usecase.adaptadores.ProdutoServicoImpl;
import br.com.appfastfood.produto.usecase.portas.ProdutoServico;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppFastfoodApplication.class)
public class BeanConfiguration {

    @Bean
    public AmazonSNS amazonSNS() {
        return AmazonSNSClientBuilder.standard().build();
    }

    @Bean
    PedidoServico pedidoServico(ProdutoServico produtoServicoImplInject ){
        return new PedidoServicoImpl(produtoServicoImplInject);
    }

    @Bean
    CarrinhoServico carrinhoServico(CarrinhoFila carrinhoFila){
        return new CarrinhoServicoImpl(carrinhoFila);
    }

    @Bean
    ProdutoServico produtoServico(ProdutoFila produtoFilaIN){
        return new ProdutoServicoImpl(produtoFilaIN);
    }

    @Bean
    Log log(){
        return new Log4jLog(BeanConfiguration.class);
    }
}
