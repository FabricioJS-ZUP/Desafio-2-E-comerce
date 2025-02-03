package br.com.zup.E_comerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.zup.E_comerce.models.Clientes;

public interface ClientesRepository extends JpaRepository<Clientes, String> {
}