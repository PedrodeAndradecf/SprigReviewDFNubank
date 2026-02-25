package reviewNubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import reviewNubank.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
