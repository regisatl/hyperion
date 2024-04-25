// Définition du package
package atl.example.hyperion.models;

// Importations nécessaires pour les annotations de persistance
import jakarta.persistence.*;
import jakarta.persistence.Table;
import java.util.Date;

// Annotation pour indiquer que cette classe est une entité
@Entity
// Annotation pour spécifier le nom de la table correspondante dans la base de
// données
@Table(name = "orders")
public class Order {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de la commande
      private String name;

      // Statut de la commande
      @Enumerated(EnumType.STRING)
      private OrderStatus status;

      // Date de création de la commande
      @Temporal(TemporalType.TIMESTAMP)
      private Date created;

      // Date limite de la commande
      @Temporal(TemporalType.TIMESTAMP)
      private Date deadline;

      // Relation avec l'entité Agency : une agence peut avoir plusieurs commandes
      @ManyToOne
      @JoinColumn(name = "agency_id")
      private Agency agency;

      // Référence à l'entité Intervention : une commande est associée à une
      // intervention
      @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
      private Intervention intervention;

      @ManyToOne // Ceci suppose que plusieurs commandes peuvent être traitées par le même
                 // expert.
      @JoinColumn(name = "expert_id")
      private User expert; // Ajout d'un champ pour l'expert avec un User en tant qu'expert.

      // Constructeur par défaut
      public Order() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public OrderStatus getStatus() {
            return status;
      }

      public Date getCreated() {
            return created;
      }

      public Date getDeadline() {
            return deadline;
      }

      public Agency getAgency() {
            return agency;
      }

      public Intervention getIntervention() {
            return intervention;
      }

      public User getExpert() {
            return expert;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setStatus(OrderStatus status) {
            this.status = status;
      }

      public void setCreated(Date created) {
            this.created = created;
      }

      public void setDeadline(Date deadline) {
            this.deadline = deadline;
      }

      public void setAgency(Agency agency) {
            this.agency = agency;
      }

      public void setIntervention(Intervention intervention) {
            this.intervention = intervention;
      }

      public void setExpert(User expert) {
            this.expert = expert;
      }
}