package com.example.frontend.itempedidos;

public class ItemPedido {
    private String codigo_pedido,codigo_produto,created_at, updated_at;
    private int quantidade;

    public ItemPedido(String codigo_pedido, String codigo_produto, String created_at, String updated_at, int quantidade) {
        this.codigo_pedido = codigo_pedido;
        this.codigo_produto = codigo_produto;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.quantidade = quantidade;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
