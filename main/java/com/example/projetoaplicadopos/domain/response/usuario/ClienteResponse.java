package com.example.projetoaplicadopos.domain.response.usuario;

import com.example.projetoaplicadopos.domain.Usuario;

public class ClienteResponse {
    private Usuario cliente;

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(final Usuario cliente) {
        this.cliente = cliente;
    }

}