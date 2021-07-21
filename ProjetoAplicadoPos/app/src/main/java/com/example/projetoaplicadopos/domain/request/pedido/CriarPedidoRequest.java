package com.example.projetoaplicadopos.domain.request.pedido;

public class CriarPedidoRequest {
    private String cpf;
    private Integer quantidade;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(final String cpf) {
        this.cpf = cpf;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(final Integer quantidade) {
        this.quantidade = quantidade;
    }

}
