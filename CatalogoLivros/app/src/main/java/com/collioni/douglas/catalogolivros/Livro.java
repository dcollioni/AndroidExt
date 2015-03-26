package com.collioni.douglas.catalogolivros;

import java.io.Serializable;

/**
 * Created by Douglas.Collioni on 26/03/2015.
 */
public class Livro implements Serializable {
    private String titulo;
    private String genereo;
    private int anoPublicacao;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenereo() {
        return genereo;
    }

    public void setGenereo(String genereo) {
        this.genereo = genereo;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public Livro(String titulo, String genereo, int anoPublicacao) {
        this.titulo = titulo;
        this.genereo = genereo;
        this.anoPublicacao = anoPublicacao;
    }

    @Override
    public String toString() {
        return titulo;
    }
}
