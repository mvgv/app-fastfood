package br.com.appfastfood.cliente.aplicacao.adaptadores.requisicao;

import lombok.Getter;

@Getter
public class RequisicaoCliente {
    private String nome;
    private String cpf;
    private String email;

    public RequisicaoCliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }
}
