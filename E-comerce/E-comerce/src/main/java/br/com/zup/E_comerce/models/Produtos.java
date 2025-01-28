package br.com.zup.E_comerce.models;
import jakarta.persistence.*;

/*
Não será permitido cadastrar produtos com o mesmo nome.
 */
@Entity
public class Produtos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String nomeproduto;
    private double precoproduto;
    private int quantidade;

    public Produtos() {
    }

    public Produtos(long id, String nomeproduto, double precoproduto, int quantidade) {
        this.id = id;
        this.nomeproduto = nomeproduto;
        this.precoproduto = precoproduto;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public double getPrecoproduto() {
        return precoproduto;
    }

    public void setPrecoproduto(double precoproduto) {
        this.precoproduto = precoproduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}