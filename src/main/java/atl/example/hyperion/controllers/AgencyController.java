// Définition du package
package atl.example.hyperion.controllers;

// Importations nécessaires
import atl.example.hyperion.models.Agency; // Importation du modèle Agency
import atl.example.hyperion.services.AgencyService; // Importation du service AgencyService
import org.springframework.beans.factory.annotation.Autowired; // Importation de l'annotation Autowired pour l'injection de dépendances
import org.springframework.web.bind.annotation.*; // Importation des annotations du contrôleur

import java.util.List; // Importation de la classe List pour gérer les listes d'agences

// Annotation pour indiquer que cette classe est un contrôleur REST
@RestController

// Annotation pour définir le chemin de base pour toutes les routes dans ce controller
@RequestMapping("/api/agencies")
public class AgencyController {

      // Annotation pour injecter automatiquement le service AgencyService
      @Autowired
      private AgencyService agencyService;

      // Méthode pour obtenir toutes les agences
      @GetMapping
      public List<Agency> getAllAgencies() {
            return agencyService.getAllAgencies();
      }

      // Méthode pour obtenir une agence par son ID
      @GetMapping("/{id}")
      public Agency getAgencyById(@PathVariable Long id) {
            return agencyService.getAgencyById(id);
      }

      // Méthode pour créer une nouvelle agence
      @PostMapping
      public Agency createAgency(@RequestBody Agency agency) {
            return agencyService.createAgency(agency);
      }

      // Méthode pour mettre à jour une agence
      @PutMapping("/{id}")
      public Agency updateAgency(@PathVariable Long id, @RequestBody Agency agencyDetails) {
            return agencyService.updateAgency(id, agencyDetails);
      }

      // Méthode pour supprimer une agence
      @DeleteMapping("/{id}")
      public void deleteAgency(@PathVariable Long id) {
            agencyService.deleteAgency(id);
      }
}
