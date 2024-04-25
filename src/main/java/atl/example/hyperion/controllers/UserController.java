// Définition du package
package atl.example.hyperion.controllers;

// Importations nécessaires
import atl.example.hyperion.models.User;
import atl.example.hyperion.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

      // Injection du service UserService
      @Autowired
      private UserService userService;

      // Méthode pour obtenir tous les utilisateurs
      @GetMapping
      public List<User> getAllUsers() {
            return userService.getAllUsers();
      }

      // Méthode pour obtenir un utilisateur par son ID
      @GetMapping("/{id}")
      public User getUserById(@PathVariable Long id) {
            return userService.getUserById(id);
      }

      // Méthode pour créer un nouvel utilisateur
      @PostMapping
      public User createUser(@RequestBody User user) {
            return userService.createUser(user);
      }

      // Méthode pour mettre à jour un utilisateur
      @PutMapping("/{id}")
      public User updateUser(@PathVariable Long id, @RequestBody User user) {
            return userService.updateUser(id, user);
      }

      // Méthode pour supprimer un utilisateur
      @DeleteMapping("/{id}")
      public void deleteUser(@PathVariable Long id) {
            userService.deleteUser(id);
      }
}
