// Définition du package
package atl.example.hyperion.repositories;

// Définition des imports
import atl.example.hyperion.models.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// PrestationRepository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {
}
