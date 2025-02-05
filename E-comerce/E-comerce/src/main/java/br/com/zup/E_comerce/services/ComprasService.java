package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.repository.ClientesRepository;
import br.com.zup.E_comerce.repository.ProdutosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ComprasService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private ProdutosRepository produtosRepository;

    public String realizarCompra(String cpf, List<String> nomesProdutos) {
        // Verificar se o cliente existe
        var cliente = clientesRepository.findById(cpf);
        if (cliente.isEmpty()) {
            return "Cliente com CPF " + cpf + " não encontrado.";
        }

        // Lista para armazenar os produtos em falta
        List<String> produtosEmFalta = new ArrayList<>();

        // Verificar se os produtos existem e têm quantidade suficiente
        for (String nomeProduto : nomesProdutos) {
            var produto = produtosRepository.findById(nomeProduto);
            if (produto.isEmpty()) {
                return "Produto " + nomeProduto + " não encontrado.";
            }
            if (produto.get().getQuantidade() < 1) {
                produtosEmFalta.add(nomeProduto);
            }
        }

        // Se houver produtos em falta, retorna erro com a lista de produtos
        if (!produtosEmFalta.isEmpty()) {
            return "Produto em falta: " + String.join(", ", produtosEmFalta);
        }

        // Atualizar a quantidade dos produtos no repositório
        for (String nomeProduto : nomesProdutos) {
            var produto = produtosRepository.findById(nomeProduto).get();
            produto.setQuantidade(produto.getQuantidade() - 1);
            produtosRepository.save(produto);
        }

        return "Compra realizada com sucesso!";
    }
}