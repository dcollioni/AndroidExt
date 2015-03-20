package com.collioni.douglas.listacompras;

/**
 * Created by Douglas.Collioni on 20/03/2015.
 */
public class ItemCompra {
    private String produto;
    private int quantidade;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public ItemCompra(String produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return produto + " (" + quantidade + ")";
    }
}
