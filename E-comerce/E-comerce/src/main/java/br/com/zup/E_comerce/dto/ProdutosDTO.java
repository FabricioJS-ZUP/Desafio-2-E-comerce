package br.com.zup.E_comerce.dto;

public class ProdutosDTO {
    private long id;
    private String nomeproduto; //(não pode ser repetido).
    private double precoproduto; //(deve ser maior que 0).
    private int quantidade; //(deve ser maior ou igual a 0).

    public ProdutosDTO(String nomeproduto, double precoproduto, int quantidade) {
    }

    public ProdutosDTO(long id, String nomeproduto, double precoproduto, int quantidade) {
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
