package com.example.projetoaplicadopos.domain;

public class Categoria {
    private String id;
    private String name_categoria;
    private String codigo_categoria;
    private String updated_at;
    private String created_at;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

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
