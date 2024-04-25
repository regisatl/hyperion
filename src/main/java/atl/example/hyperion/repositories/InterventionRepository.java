// Définition du package
package atl.example.hyperion.repositories;

// Définition des imports
import atl.example.hyperion.models.Intervention;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//
@Repository
// InterventionRepository
public interface InterventionRepository extends JpaRepository<Intervention, Long> {
}
