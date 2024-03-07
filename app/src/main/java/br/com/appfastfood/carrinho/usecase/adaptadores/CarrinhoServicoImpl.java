package br.com.appfastfood.carrinho.usecase.adaptadores;

import br.com.appfastfood.carrinho.aplicacao.adaptadores.requisicao.CarrinhoRequisicao;
import br.com.appfastfood.carrinho.dominio.modelos.Carrinho;
import br.com.appfastfood.carrinho.dominio.modelos.Cliente;
import br.com.appfastfood.carrinho.dominio.modelos.enums.StatusCarrinhoEnum;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.CarrinhoFila;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;
import br.com.appfastfood.carrinho.usecase.portas.CarrinhoServico;
import br.com.appfastfood.pedido.dominio.modelos.VO.ProdutoVO;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoServicoImpl implements CarrinhoServico {

    private CarrinhoFila carrinhoFila;

    public CarrinhoServicoImpl(CarrinhoFila carrinhoFila) {
        this.carrinhoFila = carrinhoFila;
    }

    @Override
    public void cadastrar(CarrinhoRequisicao carrinhoRequisicao) {
        try {
            this.carrinhoFila.criar(carrinhoRequisicao);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remover(Long id) {
        try {
            this.carrinhoFila.buscarPorId(id);
            this.carrinhoFila.remover(id);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Carrinho> listar() {

        List<CarrinhoOUT> carrinhoOUTList = this.carrinhoFila.listar();

        List<Carrinho> carrinhoList = carrinhoOUTList.stream().map(carrinhoOUT -> {
            List<ProdutoVO> produtosVO = carrinhoOUT.getProdutos().stream().map(prodEnt -> new ProdutoVO(prodEnt.getIdProduto(), prodEnt.getQuantidadeProduto())).toList();
            return new Carrinho(carrinhoOUT.getId(), produtosVO, new Cliente(carrinhoOUT.getCliente().getCliente()), carrinhoOUT.getValorTotal(), StatusCarrinhoEnum.buscaEnumPorStatusString(carrinhoOUT.getStatus().getNome()));
        }).toList();

        return carrinhoList;
    }

    @Override
    public Carrinho atualizar(Long id, CarrinhoRequisicao carrinhoRequisicao) {

        CarrinhoOUT carrinhoAlterado = null;
        try {
            carrinhoAlterado = this.carrinhoFila.atualizar(id, carrinhoRequisicao);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        List<ProdutoVO> produtoVOS = carrinhoAlterado.getProdutos().stream().map(produtoOUT -> new ProdutoVO(produtoOUT.getIdProduto(), produtoOUT.getQuantidadeProduto(), produtoOUT.getNome(), produtoOUT.getPreco(), produtoOUT.getCategoria(), produtoOUT.getUriImagem())).toList();
        Carrinho carrinhoModelo = new Carrinho(produtoVOS,carrinhoAlterado.getCliente(),carrinhoAlterado.getValorTotal(), carrinhoAlterado.getStatus());

        return carrinhoModelo;
    }

    @Override
    public void fecharCarrinho(Long id) {
        try {
            this.carrinhoFila.fecharCarrinho(id);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
