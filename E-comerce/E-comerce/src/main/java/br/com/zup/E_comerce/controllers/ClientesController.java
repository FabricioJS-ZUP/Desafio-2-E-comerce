package br.com.zup.E_comerce.controllers;
import  br.com.zup.E_comerce.dto.ClientesDTO;
import  br.com.zup.E_comerce.services.ClientesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClientesController {
private final ClientesServices clientesServices;

    public ClientesController() {
    }

    public ClientesController(ClientesServices clientesServices) {
        this.clientesServices = clientesServices;
    }
    // Criar clientes
    @PostMapping
    public ResponseEntity<ClientesDTO> cadastrarcliente(@RequestBody ClientesDTO clientesDTO) {
        return ResponseEntity.ok(clientesServices.cadastrarcliente(clientesDTO));
    }
    // Listar clientes
    @GetMapping
    public ResponseEntity<List<ClientesDTO>> listarClientes() {
        return ResponseEntity.ok(clientesServices.listarClientes());
    }
    // Atualizar clientes
    @PutMapping("/{CPF}")
    public ResponseEntity<ClientesDTO> atualizarProduto(@PathVariable String CPF, @RequestBody ClientesDTO clientesDTO) {
        return ResponseEntity.ok(clientesServices.atualizarcliente(CPF, clientesDTO));
    }
    // Endpoint para deletar clientes
    @DeleteMapping("/{CPF}")
    public ResponseEntity<String> deletarProduto(@PathVariable String CPF) {
        try {
            clientesServices.deletarProduto(CPF);
            return ResponseEntity.ok("Cliente com CPF:  " + CPF + " foi excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
