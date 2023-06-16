package br.com.appfastfood.cliente.infraestrutura.entidades;
 

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class EntidadeCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID  id;
    private String nome;
    private String cpf;

    private String email;

    protected EntidadeCliente() {
        // Construtor vazio para uso do JPA
    }

    public EntidadeCliente(String nome, String cpf, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntidadeCliente entidadeCliente = (EntidadeCliente) o;
        return Objects.equals(cpf, entidadeCliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}
