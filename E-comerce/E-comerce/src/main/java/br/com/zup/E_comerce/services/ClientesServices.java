package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.models.Clientes;
import br.com.zup.E_comerce.dto.ClientesDTO;
import br.com.zup.E_comerce.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

@Service
public class ClientesServices {
    private final ClientesRepository clientesRepository;

    public ClientesServices(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public ClientesDTO cadastrarcliente(ClientesDTO clientesDTO) {
        // Validação do nome do cliente
        if ((clientesDTO.getNomeusuarioDTO() == null)) {
            throw new IllegalArgumentException("Nome do usuário não pode estar vazio.");
        }
        /*  CPF
        if (clientesDTO.getCPFDTO() == unique) {

        } else if (clientesDTO.getCPFDTO() == valid) {

        }
         --------------------------------
         EMAIL
        if (clientesDTO.getEmailDTO() == unique){

        }
        else if (clientesDTO.getEmailDTO() == valid){

        }
         */
        // Convertendo o DTO para a entidade Produtos
        Clientes novocliente = new Clientes();
        novocliente.setNomeusuario(clientesDTO.getNomeusuarioDTO());
        novocliente.setCPF(clientesDTO.getCPFDTO());
        novocliente.setEmail(clientesDTO.getEmailDTO());
        // Salvando no banco de dados
        Clientes clientesSalvo = clientesRepository.save(new Clientes()); //ver pq está como new ao inves de nada

        // Retornando o produto salvo como DTO
        return new ClientesDTO(clientesSalvo.getNomeusuario(), clientesSalvo.getCPF(), clientesSalvo.getEmail());
    }

    // Listar produtos
    public List<ClientesDTO> listarClientes() {
        return clientesRepository.findAll().stream()
                .map(clientes -> new ClientesDTO(clientes.getNomeusuario(), clientes.getCPF(), clientes.getEmail()))
                .collect(Collectors.toList());
    }

    // Atualizar cliente
    public ClientesDTO atualizarcliente(String CPF, ClientesDTO clientesDTO) {
        Optional<Clientes> clientesOptional = clientesRepository.findBy(CPF);
        // Validação do nome do cliente
        if ((clientesDTO.getNomeusuarioDTO() == null)) {
            throw new IllegalArgumentException("Nome do usuário não pode estar vazio.");
        }
        /*  CPF
        if (clientesDTO.getCPFDTO() == unique) {

        } else if (clientesDTO.getCPFDTO() == valid) {

        }
         --------------------------------
         EMAIL
        if (clientesDTO.getEmailDTO() == unique){

        }
        else if (clientesDTO.getEmailDTO() == valid){

        }
         */
        if (clientesOptional.isPresent()) {
            Clientes clientesataulizados = clientesOptional.get();
            clientesataulizados.setNomeusuario(clientesDTO.getNomeusuarioDTO());
            clientesataulizados.setCPF(clientesDTO.getCPFDTO());
            clientesataulizados.setEmail(clientesDTO.getEmailDTO());

            Clientes clientesAtualizado = clientesRepository.save(clientesataulizados);
            return new  ClientesDTO(clientesAtualizado.getNomeusuario(), clientesAtualizado.getCPF(), clientesAtualizado.getEmail());
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }

    }

    // Deletar cliente
    public void deletarProduto(String CPF) {
        clientesRepository.deleteBy(CPF);
    }
}

}
