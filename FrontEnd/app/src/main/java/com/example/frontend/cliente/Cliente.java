package com.example.frontend.cliente;

public class Cliente {
    private String name,cpf,email,telefone,endereco,estado,municipio,created_at, updated_at;

    public Cliente(String name, String cpf, String email, String telefone, String endereco, String estado, String municipio,String created_at, String updated_at) {
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.estado = estado;
        this.municipio = municipio;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getEstado() {
        return estado;
    }

    public String getMunicipio() {
        return municipio;
    }
    public String getCreated_at() {
        return created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }
}
