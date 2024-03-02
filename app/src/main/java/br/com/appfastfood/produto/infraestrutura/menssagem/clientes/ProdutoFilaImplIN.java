package br.com.appfastfood.produto.infraestrutura.menssagem.clientes;

import br.com.appfastfood.produto.dominio.modelos.Produto;
import br.com.appfastfood.produto.dominio.vo.enums.CategoriaEnum;
import br.com.appfastfood.produto.infraestrutura.menssagem.ProdutoFila;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.entrada.*;
import br.com.appfastfood.produto.infraestrutura.menssagem.adaptadores.saida.ProdutoPorIdOUT;
import com.amazonaws.services.sns.AmazonSNS;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Service
public class ProdutoFilaImplIN implements ProdutoFila {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private final AmazonSNS amazonSNS;
    @Autowired
    private Gson gson;

    @Autowired
    public ProdutoFilaImplIN(AmazonSNS amazonSNS){
        this.amazonSNS = amazonSNS;
    }


    @Override
    public ProdutoPorIdOUT buscarProdutoPorId(Long id) {
        ProdutoBuscarPorIdIN in = new ProdutoBuscarPorIdIN(id);
        SNSContrato contrato = new SNSContrato(RequestMethod.GET.name(), "produto_buscar_por_id", new Metadata(in));
        String inStringJson = gson.toJson(contrato);
        return null;
    }

    @Override
    public List<Produto> buscarPorCategoria(String categoria) {
        ProdutoBuscarPorCategoriaIN in = new ProdutoBuscarPorCategoriaIN(CategoriaEnum.valueOf(categoria).name());
        SNSContrato contrato = new SNSContrato(RequestMethod.GET.name(), "produto_buscar_por_categoria", new Metadata(in));
        String inStringJson = gson.toJson(in);
        return null;
    }

    @Override
    public Produto atualizar(Long id, Produto produto) {
        ProdutoAtualizarIN in = new ProdutoAtualizarIN(
                id,
                produto.getNome().getNome(),
                produto.getPreco().getPreco(),
                produto.getUriImagem().getUriImagem(),
                produto.getCategoria().name(),
                produto.getDescricao().getDescricao()
        );

        SNSContrato contrato = new SNSContrato(RequestMethod.PUT.name(), "produto_atualizar", new Metadata(in));
        String inStringJson = gson.toJson(contrato);
        return null;
    }

    @Override
    public void remover(Long id) {
        ProdutoRemoverIN in = new ProdutoRemoverIN(id);
        SNSContrato contrato = new SNSContrato(RequestMethod.DELETE.name(), "produto_remover", new Metadata(in));
        String inStringJson = gson.toJson(contrato);
    }

    @Override
    public void criar(Produto produto) {
        ProdutoIN in = new ProdutoIN(produto.getId(), produto.getNome().getNome(),produto.getPreco().getPreco(), produto.getUriImagem().getUriImagem(), produto.getCategoria().name(), produto.getDescricao().getDescricao());
        SNSContrato contrato = new SNSContrato(RequestMethod.POST.name(), "produto_criar", new Metadata(in));
    }

}
