package br.com.appfastfood.carrinho.usecase.adaptadores;

import br.com.appfastfood.carrinho.aplicacao.adaptadores.requisicao.CarrinhoRequisicao;
import br.com.appfastfood.carrinho.aplicacao.adaptadores.requisicao.ProdutosReq;
import br.com.appfastfood.carrinho.dominio.modelos.Carrinho;
import br.com.appfastfood.carrinho.dominio.modelos.Cliente;
import br.com.appfastfood.carrinho.dominio.modelos.enums.StatusCarrinhoEnum;
import br.com.appfastfood.carrinho.exceptions.ExceptionsMessages;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.CarrinhoFila;
import br.com.appfastfood.carrinho.infraestrutura.menssagem.adaptadores.saida.CarrinhoOUT;
import br.com.appfastfood.carrinho.usecase.portas.CarrinhoServico;
import br.com.appfastfood.configuracoes.execption.BadRequestException;
import br.com.appfastfood.pedido.dominio.modelos.VO.ProdutoVO;
import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.usecase.portas.ProdutoServico;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoServicoImpl implements CarrinhoServico {

    private final ProdutoServico produtoServico;
    private CarrinhoFila carrinhoFila;

    public CarrinhoServicoImpl(ProdutoServico produtoServico, CarrinhoFila carrinhoFila) {
        this.produtoServico = produtoServico;
        this.carrinhoFila = carrinhoFila;
    }

    @Override
    public void cadastrar(CarrinhoRequisicao carrinhoRequisicao) {
        Produto produtoBuscaId = null;
        Double valorTotal = 0.0;
        List<ProdutoVO> produtosVO = new ArrayList<>();

        if(carrinhoRequisicao.getProdutos().isEmpty()) {
            throw new BadRequestException(ExceptionsMessages.CAMPO_PRODUTO_OBRIGATORIO.getValue());
        }

        for(ProdutosReq produtoReq : carrinhoRequisicao.getProdutos()){
            ProdutoVO produtoVO = new ProdutoVO(produtoReq.getIdProduto(), produtoReq.getQuantidadeProduto());
            produtoBuscaId = produtoServico.buscaProdutoPorId(Long.valueOf(produtoReq.getIdProduto()));
            valorTotal += produtoBuscaId.getPreco().getPreco() * Double.parseDouble(produtoReq.getQuantidadeProduto());
            produtosVO.add(produtoVO);
        }

        Carrinho carrinho = new Carrinho(produtosVO, new Cliente(carrinhoRequisicao.getIdCliente()), valorTotal, StatusCarrinhoEnum.ABERTO);

        this.carrinhoFila.criar(carrinho);
    }

    @Override
    public void remover(Long id) {
        this.carrinhoFila.buscarPorId(id);
        this.carrinhoFila.remover(id);
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
        Produto produtoBuscaId = null;
        Double valorTotal = 0.0;

        List<ProdutoVO> produtosVO = new ArrayList();

        if(carrinhoRequisicao.getProdutos().isEmpty()) {
            throw new BadRequestException(ExceptionsMessages.CAMPO_PRODUTO_OBRIGATORIO.getValue());
        }

        for(ProdutosReq produtoReq : carrinhoRequisicao.getProdutos()){
            ProdutoVO produtoVO = new ProdutoVO(produtoReq.getIdProduto(), produtoReq.getQuantidadeProduto());
            produtoBuscaId = produtoServico.buscaProdutoPorId(Long.valueOf(produtoReq.getIdProduto()));
            Double quantidade = Double.parseDouble(produtoReq.getQuantidadeProduto());
            valorTotal += produtoBuscaId.getPreco().getPreco() * quantidade;
            produtosVO.add(produtoVO);
        }

        Carrinho carrinho = new Carrinho(produtosVO, new Cliente(carrinhoRequisicao.getIdCliente()), valorTotal);

        CarrinhoOUT carrinhoAlterado = this.carrinhoFila.atualizar(id, carrinho);

        List<ProdutoVO> produtoVOS = carrinhoAlterado.getProdutos().stream().map(produtoOUT -> new ProdutoVO(produtoOUT.getIdProduto(), produtoOUT.getQuantidadeProduto(), produtoOUT.getNome(), produtoOUT.getPreco(), produtoOUT.getCategoria(), produtoOUT.getUriImagem())).toList();
        Carrinho carrinhoModelo = new Carrinho(produtoVOS,carrinhoAlterado.getCliente(),carrinhoAlterado.getValorTotal(), carrinhoAlterado.getStatus());

        return carrinhoModelo;
    }

    @Override
    public void fecharCarrinho(Long id) {
        this.carrinhoFila.fecharCarrinho(id);
    }

}
