package com.desafio.imobiliaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Entity
@Data

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long clienteId;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(unique = true)
    private String cnpj;

    @Column(nullable = false)
    private String telefone;

    @Column(nullable = false)
    @Email
    private String email;

    @Column(nullable = false)
    private String cidade;

    public Cliente(){}

    public Cliente(
        String nome,
        String cpf,
        String cnpj,
        String telefone,
        String email,
        String cidade
    ){
        this.nome = nome;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
    }

    public String getNome(){return nome;}
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf(){return cpf;}
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj(){return cnpj;}
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone(){return telefone;}
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail(){return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade(){return cidade;}
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
