package br.com.appfastfood.pedido.infraestrutura.menssagem.clientes;

import br.com.appfastfood.pedido.infraestrutura.menssagem.PedidoFilaIN;
import br.com.appfastfood.pedido.infraestrutura.menssagem.adaptadores.entrada.*;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.vo.enums.CategoriaEnum;
import com.amazonaws.services.sns.AmazonSNS;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Service
public class PedidoFilaImplIN implements PedidoFilaIN {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AmazonSNS amazonSNS;
    @Autowired
    private Gson gson;


    @Autowired
    public PedidoFilaImplIN(AmazonSNS amazonSNS){
        this.amazonSNS = amazonSNS;
    }


}
