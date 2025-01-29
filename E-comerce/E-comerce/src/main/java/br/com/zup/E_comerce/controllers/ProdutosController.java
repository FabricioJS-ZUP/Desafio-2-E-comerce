package br.com.zup.E_comerce.controllers;

import br.com.zup.E_comerce.dto.ProdutosDTO;
import br.com.zup.E_comerce.services.ProdutosService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutosController  {
    private final ProdutosService produtosServices;

    public ProdutosController(ProdutosService produtosServices) {
        this.produtosServices = produtosServices;
    }
    // Criar produto
    @PostMapping
    public ResponseEntity<ProdutosDTO> cadastrarprodutos(@RequestBody ProdutosDTO produtosDTO) {
        return ResponseEntity.ok(produtosServices.cadastrarprodutos(produtosDTO));
    }

    // Listar produtos
    @GetMapping
    public ResponseEntity<List<ProdutosDTO>> listarProdutos() {
        return ResponseEntity.ok(produtosServices.listarProdutos());
    }

    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<ProdutosDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutosDTO produtosDTO) {
        return ResponseEntity.ok(produtosServices.atualizarProduto(id, produtosDTO));
    }

    // Endpoint para deletar produto
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarProduto(@PathVariable Long id) {
        try {
            produtosServices.de
            produtosServices.deletarProduto(id);
            return ResponseEntity.ok("Produto com ID " + id + " foi excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}