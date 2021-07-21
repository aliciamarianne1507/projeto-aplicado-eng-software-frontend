package com.example.projetoaplicadopos.domain.request;

import java.io.Serializable;

public class CategoriaRequest implements Serializable {
    private String name_categoria;

    public String getName_categoria() {
        return name_categoria;
    }

    public void setName_categoria(final String name_categoria) {
        this.name_categoria = name_categoria;
    }
}
