package davideabbadessa.U2_W2_D5_Development_Spring.repositories;

import davideabbadessa.U2_W2_D5_Development_Spring.entities.Dispositivi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DispositivoRepository extends JpaRepository<Dispositivi, UUID> {
}
