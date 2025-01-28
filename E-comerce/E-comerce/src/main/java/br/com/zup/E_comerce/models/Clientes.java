package br.com.zup.E_comerce.models;

import jakarta.persistence.*;

import jakarta.persistence.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cadastro")
public class Clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Id
    @Column(unique = true)
    private String CPF;

    private String email;

    @Column
    private String nomeusuario;

    public Clientes() {
    }

    public Clientes(String CPF, String email, long id, String nomeusuario) {
        this.CPF = CPF;
        this.email = email;
        this.id = id;
        this.nomeusuario = nomeusuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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