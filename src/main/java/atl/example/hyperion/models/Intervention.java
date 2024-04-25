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
@Table(name = "interventions")
public class Intervention {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de l'intervention
      private String name;

      // Statut de l'intervention
      @Enumerated(EnumType.STRING)
      private InterventionStatus status;

      // Relation avec l'entité Order : une intervention est associée à une commande
      @OneToOne
      @JoinColumn(name = "order_id")
      private Order order;

      // Total de l'intervention
      private Double total;

      // Relation avec l'entité User : un expert est associé à chaque intervention
      @ManyToOne
      @JoinColumn(name = "expert_id")
      private User expert;

      // Date de création de l'intervention
      @Temporal(TemporalType.TIMESTAMP)
      private Date created;

      // Constructeur par défaut
      public Intervention() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public InterventionStatus getStatus() {
            return status;
      }

      public Order getOrder() {
            return order;
      }

      public Double getTotal() {
            return total;
      }

      public User getExpert() {
            return expert;
      }

      public Date getCreated() {
            return created;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setStatus(InterventionStatus status) {
            this.status = status;
      }

      public void setOrder(Order order) {
            this.order = order;
      }

      public void setTotal(Double total) {
            this.total = total;
      }

      public void setExpert(User expert) {
            this.expert = expert;
      }

      public void setCreated(Date created) {
            this.created = created;
      }

}
