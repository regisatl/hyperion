// Définition du package
package atl.example.hyperion.models;

// Importations nécessaires pour les annotations de persistance
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

// Annotation pour indiquer que cette classe est une entité
@Entity
// Annotation pour spécifier le nom de la table correspondante dans la base de données
@Table(name = "agencies")
public class Agency {

    // Annotations pour l'ID auto-généré
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nom de l'agence
    private String name;

    // Relation avec l'entité User : un utilisateur peut gérer plusieurs agences
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private User manager;

    // Liste des commandes associées à cette agence
    @OneToMany(mappedBy = "agency", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    // Constructeur par défaut
    public Agency() {}

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public User getManager() {
        return manager;
    }

    public List<Order> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setManager(User manager) {
        this.manager = manager;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}

