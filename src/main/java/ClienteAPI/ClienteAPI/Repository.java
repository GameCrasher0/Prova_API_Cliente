package ClienteAPI.ClienteAPI;

import ClienteAPI.ClienteAPI.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Cliente, Long> {
}
