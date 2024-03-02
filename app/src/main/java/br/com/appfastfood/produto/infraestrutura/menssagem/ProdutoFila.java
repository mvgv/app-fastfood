package br.com.appfastfood.produto.infraestrutura.menssagem;

import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida.ProdutoOUT;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida.ProdutoPorIdOUT;

import java.util.List;

public interface ProdutoFila {
    ProdutoPorIdOUT buscarProdutoPorId(Long id);
    List<Produto> buscarPorCategoria(String categoria);
    Produto atualizar(Long id, Produto produto);
    void remover(Long id);

    void criar(Produto produto);
}
