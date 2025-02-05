package br.com.zup.E_comerce.dto;

import java.util.List;

public class CompraRequest {
    private String cpf;
    private List<ProdutoRequest> produtos;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<ProdutoRequest> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProdutoRequest> produtos) {
        this.produtos = produtos;
    }

    // Método para extrair os nomes dos produtos
    public List<String> getProdutosNomes() {
        return produtos.stream().map(ProdutoRequest::getNome).toList();
    }
}

class ProdutoRequest {
    private String nome;

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}