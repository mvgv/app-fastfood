package br.com.appfastfood.carrinho.infraestrutura.menssagem.clientes;

import br.com.appfastfood.carrinho.aplicacao.adaptadores.requisicao.CarrinhoRequisicao;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.CarrinhoFila;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.entrada.*;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.sns.AmazonSNS;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CarrinhoFilaImpl implements CarrinhoFila {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AmazonSNS amazonSNS;
    @Autowired
    private Gson gson;

    @Autowired
    private AmqpTemplate template;

    private final ObjectMapper objectMapper =  new ObjectMapper();


    @Autowired
    public CarrinhoFilaImpl(AmazonSNS amazonSNS){
        this.amazonSNS = amazonSNS;
    }


    @Override
    public void criar(CarrinhoRequisicao requisicao) throws JsonProcessingException {
        CarrinhoIN in = CarrinhoIN
                .builder()
                .produtos(requisicao.getProdutos())
                .idCliente(requisicao.getIdCliente())
                .build();

        SNSContrato contrato = new SNSContrato(HttpMethod.POST.name(), "carrinho_criar", new MetadataIN(in));

        template.convertAndSend("carrinho-request-exchange", "carrinho-request-route-key", objectMapper.writeValueAsString(contrato));
    }

    @Override
    public void remover(Long id) throws JsonProcessingException {

        CarrinhoRemoverIN in = CarrinhoRemoverIN.builder().id(id).build();
        SNSContrato contrato = new SNSContrato(HttpMethod.DELETE.name(), "carrinho_remover", new MetadataIN(in));

        template.convertAndSend("carrinho-request-exchange", "carrinho-request-route-key", objectMapper.writeValueAsString(contrato));
    }

    @Override
    public void buscarPorId(Long id) throws JsonProcessingException {
        CarrinhoBuscarPorIdIN in = CarrinhoBuscarPorIdIN.builder().id(id).build();
        SNSContrato contrato = new SNSContrato(HttpMethod.DELETE.name(), "carrinho_buscar_por_id", new MetadataIN(in));

        template.convertAndSend("carrinho-request-exchange", "carrinho-request-route-key", objectMapper.writeValueAsString(contrato));
    }

    @Override
    public List<CarrinhoOUT> listar() {
        List<CarrinhoOUT> outs = new ArrayList<>();
        outs.add(new CarrinhoOUT());
        return outs;
    }

    @Override
    public CarrinhoOUT atualizar(Long id, CarrinhoRequisicao requisicao) throws JsonProcessingException {
        CarrinhoAtualizarIN in = CarrinhoAtualizarIN
                .builder()
                .id(id)
                .carrinho(
                        CarrinhoIN
                                .builder()
                                .idCliente(requisicao.getIdCliente())
                                .produtos(requisicao.getProdutos())
                                .build()
                )
                .build();

        SNSContrato contrato = new SNSContrato(HttpMethod.PUT.name(), "carrinho_atualizar", new MetadataIN(in));
        template.convertAndSend("carrinho-request-exchange", "carrinho-request-route-key", objectMapper.writeValueAsString(contrato));

        return new CarrinhoOUT();
    }

    @Override
    public void fecharCarrinho(Long id) throws JsonProcessingException {
        CarrinhoFecharIN in = CarrinhoFecharIN.builder().id(id).build();
        SNSContrato contrato = new SNSContrato(HttpMethod.PUT.name(), "carrinho_fechar", new MetadataIN(in));

        template.convertAndSend("carrinho-request-exchange", "carrinho-request-route-key", objectMapper.writeValueAsString(contrato));
    }
}
