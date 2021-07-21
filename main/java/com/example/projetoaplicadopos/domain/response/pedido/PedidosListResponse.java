package com.example.projetoaplicadopos.domain.response.pedido;

import com.example.projetoaplicadopos.domain.response.Pedido;

import java.util.List;

public class PedidosListResponse {
    private List<Pedido> pedidoList;

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(final List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

}
