package br.com.appfastfood.carrinho.infraestrutura.menssagem.clientes;

import br.com.appfastfood.carrinho.dominio.modelos.Carrinho;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.CarrinhoFila;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;
import com.amazonaws.services.sns.AmazonSNS;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    public CarrinhoFilaImpl(AmazonSNS amazonSNS){
        this.amazonSNS = amazonSNS;
    }


    @Override
    public void criar(Carrinho carrinho) {

    }

    @Override
    public void remover(Long id) {

    }

    @Override
    public void buscarPorId(Long id) {

    }

    @Override
    public List<CarrinhoOUT> listar() {
        List<CarrinhoOUT> outs = new ArrayList<>();
        outs.add(new CarrinhoOUT());
        return outs;
    }

    @Override
    public CarrinhoOUT atualizar(Long id, Carrinho carrinho) {
        return new CarrinhoOUT();
    }

    @Override
    public void fecharCarrinho(Long id) {

    }
}
