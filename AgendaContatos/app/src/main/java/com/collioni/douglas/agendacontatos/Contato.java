package com.collioni.douglas.agendacontatos;

import java.io.Serializable;

/**
 * Created by Unisinos on 21/03/2015.
 */
public class Contato implements Serializable {

    private String nome;
    private String email;
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Contato(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return nome;
    }
}
