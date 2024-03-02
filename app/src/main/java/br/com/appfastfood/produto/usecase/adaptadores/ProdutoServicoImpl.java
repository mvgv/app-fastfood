package br.com.appfastfood.produto.usecase.adaptadores;

import br.com.appfastfood.carrinho.exceptions.ExceptionsMessages;
import br.com.appfastfood.configuracoes.execption.BadRequestException;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.vo.Descricao;
import br.com.appfastfood.produto.dominio.vo.Nome;
import br.com.appfastfood.produto.dominio.vo.Preco;
import br.com.appfastfood.produto.dominio.vo.UriImagem;
import br.com.appfastfood.produto.dominio.vo.enums.CategoriaEnum;
import br.com.appfastfood.produto.infraestrutura.menssagem.ProdutoFila;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida.ProdutoOUT;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida.ProdutoPorIdOUT;
import br.com.appfastfood.produto.usecase.portas.ProdutoServico;

import java.util.List;

public class ProdutoServicoImpl implements ProdutoServico {

    private ProdutoFila produtoFilaIN;

    public ProdutoServicoImpl(ProdutoFila produtoFilaIN) {
        this.produtoFilaIN = produtoFilaIN;
    }

    @Override
    public void cadastrar(Produto produto) {
        this.produtoFilaIN.criar(produto);
    }

    @Override
    public void remover(Long id) {
        Produto buscarProdutoId = buscaProdutoPorId(id);
        if (buscarProdutoId != null){
            this.produtoFilaIN.remover(id);
        }else{
            throw new BadRequestException(ExceptionsMessages.ID_NAO_ENCONTRADO.getValue());
        }
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        Produto produtoAlterado = this.produtoFilaIN.atualizar(id, produto);
        return produtoAlterado;
    }

    @Override
    public List<Produto> buscarPorCategoria(String categoria) {
        return this.produtoFilaIN.buscarPorCategoria(categoria);
    }

    @Override
    public Produto buscaProdutoPorId(Long id){
        ProdutoPorIdOUT produtoOUT = this.produtoFilaIN.buscarProdutoPorId(id);
        Produto produto = new Produto(Long.valueOf(produtoOUT.getIdProduto()), new Nome(produtoOUT.getNome()), new Preco(produtoOUT.getPreco()), new UriImagem(produtoOUT.getUriImagem()), CategoriaEnum.valueOf(produtoOUT.getCategoria()), new Descricao(produtoOUT.getDescricao()));
        return produto;
    }



}
