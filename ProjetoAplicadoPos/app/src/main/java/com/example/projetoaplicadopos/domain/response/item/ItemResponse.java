package com.example.projetoaplicadopos.domain.response.item;

public class ItemResponse {
    private String id;
    private String codigo_pedido;
    private String codigo_produto;
    private Integer quantidade;
    private String updated_at;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(final String codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(final String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(final String updated_at) {
        this.updated_at = updated_at;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(final String created_at) {
        this.created_at = created_at;
    }

}
