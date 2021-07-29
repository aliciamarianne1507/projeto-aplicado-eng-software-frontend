package com.example.frontend.produto;

public class Produto {

    private String nome_produto;
    private int quantidade_produto;
    private float price_produto;

    public Produto(String nome_produto, int quantidade_produto, float price_produto) {
        this.nome_produto = nome_produto;
        this.quantidade_produto = quantidade_produto;
        this.price_produto = price_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public float getPrice_produto() {
        return price_produto;
    }
}
