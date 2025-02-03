package br.com.zup.E_comerce.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "tb_cadastro")
public class Clientes {
    @Id
    @Column(unique = true)
    private String cpf;
    @Column(unique = true)
    private String email;
    @Column
    private String nomeUsuario;

    public Clientes() {
    }

    public Clientes(String cpf, String email, String nomeUsuario) {
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