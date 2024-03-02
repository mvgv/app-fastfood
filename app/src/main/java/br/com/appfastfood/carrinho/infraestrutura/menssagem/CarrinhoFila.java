package br.com.appfastfood.carrinho.infraestrutura.menssagem;

import br.com.appfastfood.carrinho.dominio.modelos.Carrinho;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;

import java.util.List;

public interface CarrinhoFila {

    void criar(Carrinho carrinho);

    void remover(Long id);

    void buscarPorId(Long id);

    List<CarrinhoOUT>  listar();
    CarrinhoOUT atualizar(Long id, Carrinho carrinho);
    void fecharCarrinho(Long id);
}
