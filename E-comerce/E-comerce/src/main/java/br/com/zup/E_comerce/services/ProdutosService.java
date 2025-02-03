package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.models.Clientes;
import br.com.zup.E_comerce.models.Produtos;
import br.com.zup.E_comerce.repository.ProdutosRepository;
import br.com.zup.E_comerce.dto.ProdutosDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutosService {
    ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public ProdutosDTO cadastrarProdutos(ProdutosDTO produtosDTO) {
        //Validações
        Produtos novoProduto = new Produtos();
        novoProduto.setNomeProduto(produtosDTO.getNomeProduto());
        novoProduto.setPrecoProduto(produtosDTO.getPrecoProduto());
        novoProduto.setQuantidade(produtosDTO.getQuantidade());
        Produtos produtosSalvo = produtosRepository.save(novoProduto);

        if (produtosDTO.getQuantidade() == 0) {
            throw new RuntimeException("Estamos sem estoque no produto:" + produtosDTO.getNomeProduto());
        } else if (produtosDTO.getQuantidade() < 0) {
            throw new IllegalArgumentException("Digite um numero maior que -1 para cadastrar o protuto:" + produtosDTO.getNomeProduto());
        }
        return new ProdutosDTO(produtosSalvo.getNomeProduto(), produtosSalvo.getPrecoProduto(), produtosSalvo.getQuantidade());
    }

    // Listar produtos
    public List<ProdutosDTO> listarProdutos() {
        return produtosRepository.findAll().stream()
                .map(produtos -> new ProdutosDTO(produtos.getNomeProduto(), produtos.getPrecoProduto(), produtos.getQuantidade()))
                .collect(Collectors.toList());
    }

    // Deletar produto
    public void deletarProduto(String nomeProduto) {
        produtosRepository.deleteById(nomeProduto);
    }
}