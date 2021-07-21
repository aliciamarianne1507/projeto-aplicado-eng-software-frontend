package com.example.projetoaplicadopos.domain.request.item;

public class ItemRequest {
    private String codigo_pedido;
    private String codigo_produto;
    private Integer quantidade;

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

}
