package br.com.zup.E_comerce.models;

import jakarta.persistence.Entity;

/*
Não será permitido cadastrar clientes com o mesmo CPF ou Email.
O sistema deve realizar validações de dados e responder de forma padronizada os erros de
validação.
 */
@Entity
public class Clientes {
    private String nomeusuario;
    private String CPF; //(único e válido).
    private String email; //(único e válido).

    public Clientes() {
    }

    public Clientes(String CPF, String email, String nomeusuario) {
        this.CPF = CPF;
        this.email = email;
        this.nomeusuario = nomeusuario;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomeusuario() {
        return nomeusuario;
    }

    public void setNomeusuario(String nomeusuario) {
        this.nomeusuario = nomeusuario;
    }
}
