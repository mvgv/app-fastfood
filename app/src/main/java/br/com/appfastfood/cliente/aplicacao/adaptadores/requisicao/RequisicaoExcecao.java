package br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class RequisicaoExcecao {


    private String mensagem;
    private int codigo;
    public RequisicaoExcecao(String mensagem, int status){
        this.mensagem = mensagem;
        this.codigo = status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public int getCodigo() {
        return codigo;
    }
}
