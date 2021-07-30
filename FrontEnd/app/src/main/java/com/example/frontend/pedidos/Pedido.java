package com.example.frontend.pedidos;

public class Pedido {
    private String codigo_pedido, cpf,created_at, updated_at;
    private int quantidade;

    public Pedido(String codigo_pedido, String cpf, String created_at, String updated_at, int quantidade) {
        this.codigo_pedido = codigo_pedido;
        this.cpf = cpf;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.quantidade = quantidade;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public String getCpf() {
        return cpf;
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
