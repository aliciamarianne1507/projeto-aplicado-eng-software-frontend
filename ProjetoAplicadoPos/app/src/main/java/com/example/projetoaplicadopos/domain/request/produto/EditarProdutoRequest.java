package com.example.projetoaplicadopos.domain.request.produto;

import java.math.BigDecimal;

public class EditarProdutoRequest {
    private String codigo_produto;
    private String nome_produto;
    private Integer quantidade;
    private BigDecimal preco;

    public String getCodigo_produto() {
        return codigo_produto;
    }

    public void setCodigo_produto(final String codigo_produto) {
        this.codigo_produto = codigo_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(final String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(final BigDecimal preco) {
        this.preco = preco;
    }

}
