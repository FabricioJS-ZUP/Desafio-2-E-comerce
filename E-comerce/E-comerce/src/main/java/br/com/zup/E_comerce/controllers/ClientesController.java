package br.com.zup.E_comerce.controllers;

import br.com.zup.E_comerce.dto.ClientesDTO;
import br.com.zup.E_comerce.services.ClientesServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//import java.util.List;
@RestController
@RequestMapping("/clientes")
public class ClientesController {
    private final ClientesServices clientesServices;

    public ClientesController(ClientesServices clientesServices) {
        this.clientesServices = clientesServices;
    }

    // Cria clientes
    @PostMapping
    public ResponseEntity<ClientesDTO> cadastrarcliente(@RequestBody ClientesDTO clientesDTO) {
        return ResponseEntity.ok(clientesServices.cadastrarcliente(clientesDTO));
    }

    // Listar clientes
    @GetMapping("/{cpf}")
    public ResponseEntity<ClientesDTO> buscarClientePorCpf(@PathVariable String cpf) {
        try {
            // Chama o método do Service para buscar o cliente
            ClientesDTO cliente = clientesServices.buscarClientePorCpf(cpf);
            return ResponseEntity.ok(cliente); // Retorna o cliente encontrado com status 200 (OK)
        } catch (IllegalArgumentException e) {
            // Retorna uma mensagem de erro com status 404 (Not Found)
            return ResponseEntity.status(404).body(null);
        }
    }

    // Atualizar clientes
    @PutMapping("/{CPF}")
    public ResponseEntity<ClientesDTO> atualizarProduto(@PathVariable String CPF, @RequestBody ClientesDTO
            clientesDTO) {
        return ResponseEntity.ok(clientesServices.atualizarcliente(CPF, clientesDTO));
    }

}
