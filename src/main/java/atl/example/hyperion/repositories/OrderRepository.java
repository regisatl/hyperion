// Définition du package
package atl.example.hyperion.repositories;

// Importations nécessaires
import atl.example.hyperion.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
