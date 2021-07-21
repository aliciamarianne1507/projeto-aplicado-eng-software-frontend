package com.example.projetoaplicadopos.domain.request.categoria;

public class AtualizarCategoriaRequest {
    private String name_categoria;
    private String codigo_categoria;

    public String getName_categoria() {
        return name_categoria;
    }

    public void setName_categoria(final String name_categoria) {
        this.name_categoria = name_categoria;
    }

    public String getCodigo_categoria() {
        return codigo_categoria;
    }

    public void setCodigo_categoria(final String codigo_categoria) {
        this.codigo_categoria = codigo_categoria;
    }

}
