package br.com.zup.E_comerce.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.zup.E_comerce.models.Produtos;

public interface ProdutosRepository extends JpaRepository<Produtos, Long> {
}