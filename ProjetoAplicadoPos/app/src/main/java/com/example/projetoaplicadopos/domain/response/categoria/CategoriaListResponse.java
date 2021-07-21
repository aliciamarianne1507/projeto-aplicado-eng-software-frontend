package com.example.projetoaplicadopos.domain.response.categoria;

import com.example.projetoaplicadopos.domain.response.Categoria;

import java.util.List;

public class CategoriaListResponse {
    private List<Categoria> categoriaList;

    public List<Categoria> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(final List<Categoria> categoriaList) {
        this.categoriaList = categoriaList;
    }

}
