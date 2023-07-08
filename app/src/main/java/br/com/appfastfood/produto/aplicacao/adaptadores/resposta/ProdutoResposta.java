package br.com.appfastfood.produto.aplicacao.adaptadores.resposta;

import lombok.Builder;
import lombok.Getter;
@Builder()
@Getter
public class ProdutoResposta {
    private String nome;
    private Double preco;
    private String uriImagem;
    private String categoria;
    private String descricao;
}
