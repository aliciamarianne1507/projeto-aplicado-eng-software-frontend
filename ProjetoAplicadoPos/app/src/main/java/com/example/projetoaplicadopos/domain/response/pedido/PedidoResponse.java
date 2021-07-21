package com.example.projetoaplicadopos.domain.response.pedido;

public class PedidoResponse {
    private String id;
    private String codido_pedido;
    private String cpf;
    private Integer quantidade;
    private String updated_at;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getCodido_pedido() {
        return codido_pedido;
    }

    public void setCodido_pedido(final String codido_pedido) {
        this.codido_pedido = codido_pedido;
    }

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
