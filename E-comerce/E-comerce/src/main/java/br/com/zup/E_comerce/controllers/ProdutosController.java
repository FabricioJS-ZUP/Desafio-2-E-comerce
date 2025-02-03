package br.com.zup.E_comerce.controllers;

import br.com.zup.E_comerce.dto.ProdutosDTO;
import br.com.zup.E_comerce.services.ProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
    private final ProdutosService produtosServices;

    public ProdutosController(ProdutosService produtosServices) {
        this.produtosServices = produtosServices;
    }

    // Criar produto
    @PostMapping
    public ResponseEntity<ProdutosDTO> cadastrarProdutos(@RequestBody ProdutosDTO produtosDTO) {
        return ResponseEntity.ok(produtosServices.cadastrarProdutos(produtosDTO));
    }

    // Listar produtos
    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> listarProdutos() {
        return ResponseEntity.ok(produtosServices.listarProdutos());
    }

    // Endpoint para deletar produto
    @DeleteMapping("/{nomeProduto}")
    public ResponseEntity<String> deletarProduto(@PathVariable String nomeProduto) {
        try {
            produtosServices.deletarProduto(nomeProduto);
            return ResponseEntity.ok("Produto com nome: " + nomeProduto + " foi excluído com sucesso.");
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}