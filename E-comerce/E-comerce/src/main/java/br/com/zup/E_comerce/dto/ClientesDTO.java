package br.com.zup.E_comerce.dto;


import jakarta.annotation.Nullable;

public class ClientesDTO {
    @Nullable
    private String cpf;
    @Nullable
    private String email;
    @Nullable
    private String nomeUsuario;

    public ClientesDTO() {
    }

    public ClientesDTO(String cpf, String email, String nomeUsuario) {
        this.cpf = cpf;
        this.email = email;
        this.nomeUsuario = nomeUsuario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}