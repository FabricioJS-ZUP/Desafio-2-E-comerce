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
    //DO: FAZER O atualizar POR CPF E NÃO ID
    // Atualizar produto
    @PutMapping("/{id}")
    public ResponseEntity<ClientesDTO> atualizarcliente(@PathVariable Long id, @RequestBody ClientesDTO clientesDTO) {
        return ResponseEntity.ok(clientesServices.atualizarcliente(id, clientesDTO));
    }

    // Endpoint para deletar clientes
    //DO: FAZER O DELETE POR CPF E NÃO ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCLIENTE(@PathVariable Long id) {
        try {
            clientesServices.deletarCLIENTE(id);
            return ResponseEntity.ok("Cliente com ID " + id + " foi excluído com sucesso.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}