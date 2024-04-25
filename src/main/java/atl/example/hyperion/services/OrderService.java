// Définition du package
package atl.example.hyperion.services;

import atl.example.hyperion.models.Intervention;
import atl.example.hyperion.models.InterventionStatus;
// Importations nécessaires
import atl.example.hyperion.models.Order;
import atl.example.hyperion.models.OrderStatus;
import atl.example.hyperion.models.User;
import atl.example.hyperion.models.UserRole;
import atl.example.hyperion.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

      // Injection du OrderRepository
      @Autowired
      private OrderRepository orderRepository;
      @Autowired
      private InterventionService interventionService;
      @Autowired
      private UserService userService;

      // Méthode pour obtenir toutes les commandes
      public List<Order> getAllOrders() {
            return orderRepository.findAll();
      }

      // Méthode pour obtenir une commande par son ID
      public Order getOrderById(Long id) {
            return orderRepository.findById(id).orElse(null);
      }

      // Méthode pour créer une nouvelle commande
      public Order createOrder(Order order) {
            return orderRepository.save(order);
      }

      // Méthode pour mettre à jour une commande
      public Order updateOrder(Long id, Order order) {
            Order existingOrder = getOrderById(id);
            if (existingOrder != null) {
                  existingOrder.setName(order.getName());
                  existingOrder.setStatus(order.getStatus());
                  existingOrder.setCreated(order.getCreated());
                  existingOrder.setDeadline(order.getDeadline());
                  existingOrder.setAgency(order.getAgency());
                  existingOrder.setIntervention(order.getIntervention());
                  return orderRepository.save(existingOrder);
            } else {
                  return null;
            }
      }

      // Méthode pour supprimer une commande
      public void deleteOrder(Long id) {
            orderRepository.deleteById(id);
      }

      // Méthode pour valider une commande par un agent
      public Order validateOrder(Long orderId, Long expertId) {
            Order order = getOrderById(orderId);
            if (order != null && order.getStatus() == OrderStatus.RECEIVED) {
                  User expert = userService.getUserById(expertId); // Supposition qu'il existe un UserService pour récupérer un User
                  if (expert != null && expert.getRole() == UserRole.EXPERT) {
                        order.setExpert(expert);
                        order.setStatus(OrderStatus.IN_PROGRESS);
                        orderRepository.save(order);

                        // Création de l'intervention devrait être une méthode distincte appelée à la suite de cette méthode
                        Intervention intervention = new Intervention();
                        intervention.setStatus(InterventionStatus.CREATED);
                        intervention.setOrder(order);
                        intervention.setExpert(expert);
                        interventionService.createIntervention(intervention);

                        return order;
                  }
            }
            return null; // Ou lancer une exception personnalisée si l'ordre n'existe pas ou si l'expert n'est pas trouvé.
      }

}
