package reviewNubank.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import reviewNubank.entities.Cliente;

import java.util.List;



public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Query("SELECT c FROM Cliente c LEFT JOIN FETCH c.contatos")
    List<Cliente> findAllComContatos();
}
