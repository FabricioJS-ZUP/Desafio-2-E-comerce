package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.models.Produtos;
import br.com.zup.E_comerce.repository.ProdutosRepository;
import br.com.zup.E_comerce.dto.ProdutosDTO;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutosService {
    ProdutosRepository produtosRepository;

    public ProdutosService(ProdutosRepository produtosRepository) {
        this.produtosRepository = produtosRepository;
    }

    public ProdutosDTO cadastrarprodutos(ProdutosDTO produtosDTO) {
        //Validações
        if (produtosDTO.getNomeproduto() == null){
            throw new IllegalArgumentException("Não é possivel cadastrar um produto sem nome");
        }
        if (produtosDTO.getQuantidade() == 0) {
            System.out.println("Aviso o produto" + produtosDTO.getQuantidade() + "está com 0 unidades em estoque");
        } else if (produtosDTO.getQuantidade() < 0) {
            throw new IllegalArgumentException("Não é possivelcadastrar o produto pois a quantidade do produto não pode ser menor que 0");

        }
        if (produtosDTO.getPrecoproduto() == 0.00) {
            throw new IllegalArgumentException("Não é possivel o preço do produto ser igual á: 0");
        }
        // Convertendo o DTO para a entidade Produtos
        Produtos novoproduto = new Produtos();
        novoproduto.setNomeproduto(produtosDTO.getNomeproduto());
        novoproduto.setPrecoproduto(produtosDTO.getPrecoproduto());
        novoproduto.setQuantidade(produtosDTO.getQuantidade());
        // Salvando no banco de dados
        Produtos produtosSalvo = produtosRepository.save(new Produtos());
        // Retornando o produto salvo como DTO
        return new ProdutosDTO(produtosSalvo.getId(),produtosSalvo.getNomeproduto(),produtosSalvo.getPrecoproduto(),produtosSalvo.getQuantidade());
    }

    // Listar produtos
    public List<ProdutosDTO> listarProdutos() {
        return produtosRepository.findAll().stream()
                .map(produtos -> new ProdutosDTO(produtos.getId(), produtos.getNomeproduto(), produtos.getQuantidade(), produtos.getPrecoproduto()))
                .collect(Collectors.toList());
    }
    // Atualizar produto
    public ProdutosDTO atualizarProduto(Long id, ProdutosDTO produtosDTO) {
        Optional<Produtos> produtoOptional = produtosRepository.findById(id);
        // Validação do nome do produto
        if (produtosDTO.getNomeproduto() == null){
            throw new IllegalArgumentException("Não é possivel cadastrar um produto sem nome");
        }
        if (produtosDTO.getQuantidade() == 0) {
            System.out.println("Aviso o produto" + produtosDTO.getQuantidade() + "está com 0 unidades em estoque");
        } else if (produtosDTO.getQuantidade() < 0) {
            throw new IllegalArgumentException("Não é possivel a quantidade do produto ser menor que 0");

        }
        if (produtosDTO.getPrecoproduto() == 0) {
            throw new IllegalArgumentException("Não é possivel o preço do produto ser igual á: 0");
        }
        if (produtoOptional.isPresent()){
            Produtos atualizandoproduto = produtoOptional.get();
            atualizandoproduto.setNomeproduto(produtosDTO.getNomeproduto());
            atualizandoproduto.setPrecoproduto(produtosDTO.getPrecoproduto());
            atualizandoproduto.setQuantidade(produtosDTO.getQuantidade());

            Produtos produtoAtualizado = produtosRepository.save(new Produtos());
            return new ProdutosDTO(produtoAtualizado.getId(),produtoAtualizado.getNomeproduto(),produtoAtualizado.getPrecoproduto(),produtoAtualizado.getQuantidade());
        }else {
            throw new RuntimeException("Produto não encontrado!");
        }
    }
    // Deletar produto
    public void deletarProduto(Long id) {
        produtosRepository.deleteById(id);
    }

}