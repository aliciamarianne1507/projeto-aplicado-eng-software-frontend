package com.example.frontend.produto;

public class Produto {

    private String name_produto, codigo_produto,created_at,updated_at;
    private int quantidade_produto;
    private double price_produto;

    public Produto(String nome_produto,String codigo_produto, int quantidade_produto, double price_produto,String created_at, String updated_at) {
        this.name_produto = nome_produto;
        this.quantidade_produto = quantidade_produto;
        this.price_produto = price_produto;
        this.codigo_produto = codigo_produto;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getNome_produto() {
        return name_produto;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public double getPrice_produto() {
        return price_produto;
    }
    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
