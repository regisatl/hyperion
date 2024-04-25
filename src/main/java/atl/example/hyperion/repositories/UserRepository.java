// Définition du package
package atl.example.hyperion.repositories;

// Importations nécessaires
import atl.example.hyperion.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
