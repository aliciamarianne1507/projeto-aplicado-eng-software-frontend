package com.example.frontend.categoria;


public class Categoria {

    private String name_categoria,codigo_categoria,created_at, updated_at;
    private int id;

    public Categoria(int id, String name_categoria, String codigo_categoria, String created_at, String updated_at) {
        this.name_categoria = name_categoria;
        this.codigo_categoria = codigo_categoria;
        this.id = id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getName_categoria() {
        return name_categoria;
    }

    public String getCodigo_categoria() {
        return codigo_categoria;
    }

    public Integer getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}


