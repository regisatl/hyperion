// Définition du package
package atl.example.hyperion.services;

// Définition des importations
import atl.example.hyperion.models.Intervention;
import atl.example.hyperion.repositories.InterventionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
// Classe InterventionService
public class InterventionService {

      @Autowired
      private InterventionRepository interventionRepository;

      // Récupérer toutes les interventions
      public List<Intervention> getAllInterventions() {
            return interventionRepository.findAll();
      }

      // Créer une nouvelle intervention
      public Intervention createIntervention(Intervention intervention) {
            return interventionRepository.save(intervention);
      }

      // Mettre à jour une intervention existante
      public Optional<Intervention> updateIntervention(Long id, Intervention interventionDetails) {
            return interventionRepository.findById(id)
                        .map(intervention -> {
                              intervention.setName(interventionDetails.getName());
                              intervention.setStatus(interventionDetails.getStatus());
                              intervention.setOrder(interventionDetails.getOrder());
                              intervention.setTotal(interventionDetails.getTotal());
                              intervention.setExpert(interventionDetails.getExpert());
                              intervention.setCreated(interventionDetails.getCreated());
                              return interventionRepository.save(intervention);
                        });
      }

      // Supprimer une intervention
      public void deleteIntervention(Long id) {
            if (interventionRepository.existsById(id)) {
                  interventionRepository.deleteById(id);
            }
      }
}
