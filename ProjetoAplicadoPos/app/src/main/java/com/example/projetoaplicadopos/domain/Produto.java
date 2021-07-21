package com.example.projetoaplicadopos.domain;

import java.math.BigDecimal;

public class Produto {
    private String id;
    private String name_produto;
    private String codigo_produto;
    private BigDecimal price_produto;
    private Integer quantidade_produto;
    private String updated_at;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getName_produto() {
        return name_produto;
    }

    public void setName_produto(final String name_produto) {
        this.name_produto = name_produto;
    }

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(final String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public BigDecimal getPrice_produto() {
        return price_produto;
    }

    public void setPrice_produto(final BigDecimal price_produto) {
        this.price_produto = price_produto;
    }

    public Integer getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(final Integer quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
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
