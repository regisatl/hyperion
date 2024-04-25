// Définition du package
package atl.example.hyperion.models;

// Importations nécessaires pour les annotations de validation et de persistance
import jakarta.persistence.Table;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import java.util.List;

// Annotation pour indiquer que cette classe est une entité
@Entity
@Table(name = "users")
public class User {

      // Annotations pour l'ID auto-généré
      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;

      // Annotations pour la validation du nom d'utilisateur
      @NotBlank(message = "Le nom d'utilisateur ne peut pas être vide")
      @Size(min = 3, max = 50, message = "Le nom d'utilisateur doit comporter entre 3 et 50 caractères")
      private String username;

      // Annotation pour la validation du mot de passe
      @NotBlank(message = "Le mot de passe ne peut pas être vide")
      private String password;

      // Annotation pour l'énumération du rôle de l'utilisateur
      @Enumerated(EnumType.STRING)
      private UserRole role;

      // Annotations pour la validation du prénom
      @NotBlank(message = "Le prénom ne peut pas être vide")
      private String name;

      // Annotations pour la validation du nom de famille
      @NotBlank(message = "Le nom de famille ne peut pas être vide")
      private String lastName;

      // Annotation pour la validation de l'email
      @Email(message = "L'email doit être valide")
      private String mail;

      // Annotation pour la validation du numéro de téléphone
      @Pattern(regexp = "^(\\+\\d{1,3}[- ]?)?\\d{10}$", message = "Le numéro de téléphone doit être valide")
      private String phoneNumber;

      // Relations : un utilisateur peut gérer plusieurs agences
      @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL, orphanRemoval = true)
      private List<Agency> managedAgencies;

      // Constructeur par défaut
      public User() {
      }

      // Getters
      public Long getId() {
            return id;
      }

      public String getUsername() {
            return username;
      }

      public String getPassword() {
            return password;
      }

      public UserRole getRole() {
            return role;
      }

      public String getName() {
            return name;
      }

      public String getLastName() {
            return lastName;
      }

      public String getMail() {
            return mail;
      }

      public String getPhoneNumber() {
            return phoneNumber;
      }

      public List<Agency> getManagedAgencies() {
            return managedAgencies;
      }

      // Setters
      public void setId(Long id) {
            this.id = id;
      }

      public void setUsername(String username) {
            this.username = username;
      }

      public void setPassword(String password) {
            this.password = password;
      }

      public void setRole(UserRole role) {
            this.role = role;
      }

      public void setName(String name) {
            this.name = name;
      }

      public void setLastName(String lastName) {
            this.lastName = lastName;
      }

      public void setMail(String mail) {
            this.mail = mail;
      }

      public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
      }

      public void setManagedAgencies(List<Agency> managedAgencies) {
            this.managedAgencies = managedAgencies;
      }

}
