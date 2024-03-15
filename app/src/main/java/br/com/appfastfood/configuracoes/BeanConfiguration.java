package br.com.appfastfood.configuracoes;

import br.com.appfastfood.AppFastfoodApplication;
import br.com.appfastfood.configuracoes.logs.Log;
import br.com.appfastfood.configuracoes.logs.Log4jLog;
import br.com.appfastfood.pedido.usecase.adaptadores.producers.PedidoServicoImpl;
import br.com.appfastfood.pedido.usecase.portas.PedidoServico;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = AppFastfoodApplication.class)
public class BeanConfiguration {



    @Bean
    public AmazonSNS amazonSNS() {
        // Configuração básica de um cliente AmazonSNS usando as credenciais padrão do SDK
        return AmazonSNSClientBuilder.standard()
                .withRegion(Regions.US_EAST_1) // Substitua US_EAST_1 pela região desejada
                .build();
    }

    @Bean
    PedidoServico pedidoServico(){
        return new PedidoServicoImpl();
    }


    @Bean
    Log log(){
        return new Log4jLog(BeanConfiguration.class);
    }
}
