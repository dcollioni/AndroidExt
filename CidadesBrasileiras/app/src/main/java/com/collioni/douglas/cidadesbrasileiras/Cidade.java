package com.collioni.douglas.cidadesbrasileiras;

/**
 * Created by Douglas.Collioni on 19/03/2015.
 */
public class Cidade {
    private String nome;
    private int populacao;
    private int extensao;
    private int foto;

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getExtensao() {
        return extensao;
    }

    public void setExtensao(int extensao) {
        this.extensao = extensao;
    }

    public Cidade(String nome, int populacao, int extensao, int foto) {
        this.nome = nome;
        this.populacao = populacao;
        this.extensao = extensao;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return nome;
    }
}
