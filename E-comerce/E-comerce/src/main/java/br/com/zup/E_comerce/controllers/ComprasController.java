package br.com.zup.E_comerce.controllers;

import br.com.zup.E_comerce.dto.CompraRequest;
import br.com.zup.E_comerce.services.ComprasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/compras")
public class ComprasController {

    @Autowired
    private ComprasService comprasService;

    @PostMapping
    public ResponseEntity<String> realizarCompra(@RequestBody CompraRequest compraRequest) {
        String resultado = comprasService.realizarCompra(compraRequest.getCpf(),
                compraRequest.getProdutosNomes());
        if (resultado.equals("Compra realizada com sucesso!")) {
            return ResponseEntity.ok(resultado);
        } else {
            return ResponseEntity.badRequest().body(resultado);
        }
    }
}