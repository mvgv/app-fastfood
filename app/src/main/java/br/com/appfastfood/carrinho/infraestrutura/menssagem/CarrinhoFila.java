package br.com.appfastfood.carrinho.infraestrutura.menssagem;

import br.com.appfastfood.carrinho.aplicacao.adaptadores.requisicao.CarrinhoRequisicao;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.List;

public interface CarrinhoFila {

    void criar(CarrinhoRequisicao requisicao) throws JsonProcessingException;

    void remover(Long id) throws JsonProcessingException;

    void buscarPorId(Long id) throws JsonProcessingException;

    List<CarrinhoOUT>  listar();
    CarrinhoOUT atualizar(Long id, CarrinhoRequisicao requisicao) throws JsonProcessingException;
    void fecharCarrinho(Long id) throws JsonProcessingException;
}
