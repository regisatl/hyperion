// Définition du package
package atl.example.hyperion.models;

// Importations nécessaires pour les annotations de persistance
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Annotation pour indiquer que cette classe est une entité
@Entity

// Annotation pour spécifier le nom de la table correspondante dans la base de
// données
@Table(name = "prestations")
public class Prestation {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Nom de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotBlank(message = "Le nom ne peut pas être vide")
      private String name;

      // Code de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotBlank(message = "Le code ne peut pas être vide")
      private String code;

      // Prix de la prestation avec une validation pour s'assurer qu'il n'est pas vide
      @NotNull(message = "Le prix ne peut pas être vide")
      private Double price;

      // Constructeur par défaut
      public Prestation() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getName() {
            return name;
      }

      public String getCode() {
            return code;
      }

      public Double getPrice() {
            return price;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setCode(String code) {
            this.code = code;
      }

      public void setPrice(Double price) {
            this.price = price;
      }

}
