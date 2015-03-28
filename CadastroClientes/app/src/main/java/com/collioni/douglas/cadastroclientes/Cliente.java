package com.collioni.douglas.cadastroclientes;

/**
 * Created by Douglas.Collioni on 27/03/2015.
 */
public class Cliente implements Comparable {
    private String nome;
    private String email;
    private String telefone;
    private String cidade;

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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Cliente() {

    }

    public Cliente(String nome, String email, String telefone, String cidade) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public int compareTo(Object another) {

        Cliente outro = (Cliente) another;

        return nome.toLowerCase()
                    .compareTo(
                        outro.getNome().toLowerCase());
    }
}


















