package br.com.zup.E_comerce.services;

import br.com.zup.E_comerce.dto.ClientesDTO;
import br.com.zup.E_comerce.models.Clientes;
import br.com.zup.E_comerce.repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class ClientesServices {
    private final ClientesRepository clientesRepository;

    public ClientesServices(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    //cadastrar cliente
    public ClientesDTO cadastrarcliente(ClientesDTO clientesDTO) {
        if (!validandoCpf(clientesDTO.getCpf())) {
            throw new IllegalArgumentException("O CPF deve ter  11 digitos numericos.");
        }
        if (!validandoEmail(clientesDTO.getEmail())) {
            throw new IllegalArgumentException("O email deve terminar com '@gmail.com', '@Outlook.com' ou @zup.com.br");
        }

        // Convertendo o DTO para a entidade Produtos
        Clientes cadastroCliente = new Clientes();
        cadastroCliente.setNomeUsuario(clientesDTO.getNomeUsuario());
        cadastroCliente.setCpf(clientesDTO.getCpf());
        cadastroCliente.setEmail(clientesDTO.getEmail());
        // Salvando no banco de dados
        Clientes clientesSalvo = clientesRepository.save(cadastroCliente);
        if (clientesDTO.getCpf().length() != 11) {
            throw new IllegalArgumentException("O cpf tem que conter 11 digitos" + "atualmente o seu contem: " + clientesDTO.getCpf() + " digitos");
        }
        return new ClientesDTO(clientesSalvo.getCpf(), clientesSalvo.getEmail(), clientesSalvo.getNomeUsuario());

    }

    //Buscar cliente
    public ClientesDTO buscarClientePorCpf(String cpf) {
        Optional<Clientes> clienteOptional = clientesRepository.findById(cpf);

        if (clienteOptional.isEmpty()) {
            throw new IllegalArgumentException("Cliente com o CPF " + cpf + " não encontrado.");
        }

        Clientes cliente = clienteOptional.get();
        return new ClientesDTO(cliente.getCpf(), cliente.getEmail(), cliente.getNomeUsuario());
    }

    // Atualizar cliente
    public ClientesDTO atualizarcliente(String CPF, ClientesDTO clientesDTO) {
        // Busca o cliente no banco de dados pelo CPF
        Optional<Clientes> clientesOptional = clientesRepository.findById(CPF);
        if (!validandoCpf(clientesDTO.getCpf())) {
            throw new IllegalArgumentException("O CPF deve conter 11 dígitos numéricos.");
        }
        if (!validandoEmail(clientesDTO.getEmail())) {
            throw new IllegalArgumentException("O e-mail deve terminar com '@gmail.com', '@Outlook.com' ou '@zup.com.br'.");
        }
        if (clientesOptional.isPresent()) {
            Clientes clienteAtualizado = clientesOptional.get();
            clienteAtualizado.setNomeUsuario(clientesDTO.getNomeUsuario());
            clienteAtualizado.setCpf(clientesDTO.getCpf());
            clienteAtualizado.setEmail(clientesDTO.getEmail());
            Clientes clienteSalvo = clientesRepository.save(clienteAtualizado);
            return new ClientesDTO(clienteSalvo.getCpf(), clienteSalvo.getEmail(), clienteSalvo.getNomeUsuario());
        } else {
            // Lança exceção se o cliente não for encontrado
            throw new RuntimeException("Cliente não encontrado!");
        }
    }

    // Validadores
    private boolean validandoCpf(String cpf) {
        //    return cpf != null && cpf.matches("\\d{11}");
        return cpf.matches("\\d{11}");
    }

    private boolean validandoEmail(String email) {
        // Verifica se o email corresponde a um dos três padrões permitidos
        return Pattern.matches("^[\\w._%+-]+@gmail\\.com$", email) || Pattern.matches("^[\\w._%+-]+@Outlook\\.com$", email) || Pattern.matches("^[\\w._%+-]+@zup\\.com\\.br$", email);
    }
}