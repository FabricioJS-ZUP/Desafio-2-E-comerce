package br.com.zup.E_comerce.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.annotation.Nullable;

public class ProdutosDTO {
    @Nullable
    private String nomeProduto; //(não pode ser repetido).
    @Nullable
    private double precoProduto;
    private int quantidade;
    public ProdutosDTO() {
    }

    public ProdutosDTO(String nomeProduto, double precoProduto, int quantidade) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidade = quantidade;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
