package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.models.Clientes;
import br.com.zup.E_comerce.dto.ClientesDTO;
import br.com.zup.E_comerce.repository.ClientesRepository;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientesServices {
    private final ClientesRepository clientesRepository;

    public ClientesServices(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    public ClientesDTO cadastrarcliente(ClientesDTO clientesDTO) {
        if ((clientesDTO.getNomeusuarioDTO() == null)) {
            throw new IllegalArgumentException("Nome do usuário não pode estar vazio.");
        }
        if (clientesDTO.getCPFDTO().length() != 11) {
            throw new IllegalArgumentException("O cpf tem que conter 11 digitos" + "atualmente o seu contem: " + clientesDTO.getCPFDTO() + " digitos");
        } else if (clientesDTO.getCPFDTO() == null) {
            throw new IllegalArgumentException("Voce não escreveu nada no campo de cpf");
        } //colocar um validador para ver se so contem apenas numeros no cpf
        //melhorar o validador de emails para pegar os tipos de emails mais usados
        if (clientesDTO.getEmailDTO().lastIndexOf("@gmail.com") != clientesDTO.getEmailDTO().lastIndexOf("@gmail.com")) { //ver se este .lastIndexOf pega os ultimos caracteres e deixa neste formato
            throw new IllegalArgumentException("Só aceitamos emails com o ginal : @gmail.com");
        }
        // Convertendo o DTO para a entidade Produtos
        Clientes clientes = new Clientes();
        clientes.setNomeusuario(clientesDTO.getNomeusuarioDTO());
        clientes.setCPF(clientesDTO.getCPFDTO());
        clientes.setEmail(clientesDTO.getEmailDTO());
        // Salvando no banco de dados
        Clientes clientesSalvo = clientesRepository.save(clientes);
        // Retornando o produto salvo como DTO
        return new ClientesDTO(clientesSalvo.getCPF(), clientesSalvo.getEmail(), clientesSalvo.getId(), clientesSalvo.getNomeusuario());
    }

    // Listar produtos
    public List<ClientesDTO> listarClientes() {
        return clientesRepository.findAll().stream()
                .map(clientes -> new ClientesDTO(clientes.getCPF(), clientes.getEmail(), clientes.getId(), clientes.getNomeusuario()))
                .collect(Collectors.toList());
    }

    // Atualizar cliente
    public ClientesDTO atualizarcliente(Long id, ClientesDTO clientesDTO) {
        Optional<Clientes> clientesOptional = clientesRepository.findById(id);
        if ((clientesDTO.getNomeusuarioDTO() == null)) {
            throw new IllegalArgumentException("Nome do usuário não pode estar vazio.");
        }
        if (clientesDTO.getCPFDTO().length() != 11) {
            throw new IllegalArgumentException("O cpf tem que conter 11 digitos" + "atualmente o seu contem: " + clientesDTO.getCPFDTO() + " digitos");
        } else if (clientesDTO.getCPFDTO() == null) {
            throw new IllegalArgumentException("Voce não escreveu nada no campo de cpf");
        } //colocar um validador para ver se so contem apenas numeros no cpf
        //melhorar o validador de emails para pegar os tipos de emails mais usados
        if (clientesDTO.getEmailDTO().lastIndexOf("@gmail.com") != clientesDTO.getEmailDTO().lastIndexOf("@gmail.com")) { //ver se este .lastIndexOf pega os ultimos caracteres e deixa neste formato
            throw new IllegalArgumentException("Só aceitamos emails com o ginal : @gmail.com");
        }
        if (clientesOptional.isPresent()) {
            Clientes clientesataulizados = clientesOptional.get();
            clientesataulizados.setNomeusuario(clientesDTO.getNomeusuarioDTO());
            clientesataulizados.setCPF(clientesDTO.getCPFDTO());
            clientesataulizados.setEmail(clientesDTO.getEmailDTO());

            Clientes clientesAtualizado = clientesRepository.save(clientesataulizados);
            return new ClientesDTO(clientesAtualizado.getCPF(), clientesAtualizado.getEmail(), clientesAtualizado.getId(), clientesAtualizado.getNomeusuario());
        } else {
            throw new RuntimeException("Cliente não encontrado!");
        }

    }

    // Deletar cliente
    public void deletarCLIENTE(Long id) {
        clientesRepository.deleteById(id);
    }
}
