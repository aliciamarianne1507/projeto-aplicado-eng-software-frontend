package com.example.projetoaplicadopos.domain.request.produto;

import java.math.BigDecimal;

public class CriarProdutoRequest {
    private String name_produto;
    private Integer quantidade_produto;
    private BigDecimal price_produto;

    public String getName_produto() {
        return name_produto;
    }

    public void setName_produto(final String name_produto) {
        this.name_produto = name_produto;
    }

    public Integer getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(final Integer quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public BigDecimal getPrice_produto() {
        return price_produto;
    }

    public void setPrice_produto(final BigDecimal price_produto) {
        this.price_produto = price_produto;
    }

}
