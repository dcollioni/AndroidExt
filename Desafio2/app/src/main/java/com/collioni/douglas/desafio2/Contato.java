package com.collioni.douglas.desafio2;

import java.io.Serializable;

/**
 * Created by Douglas.Collioni on 23/03/2015.
 */
public class Contato implements Serializable {
    private String nome;
    private String email;
    private String telefone;
    private int foto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public Contato(String nome, String email, String telefone, int foto) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.foto = foto;
    }
}
