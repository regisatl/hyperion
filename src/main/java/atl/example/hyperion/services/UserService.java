// Définition du package
package atl.example.hyperion.services;

// Importations nécessaires
import atl.example.hyperion.models.User;
import atl.example.hyperion.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Injection du UserRepository
    @Autowired
    private UserRepository userRepository;

    // Méthode pour obtenir tous les utilisateurs
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Méthode pour obtenir un utilisateur par son ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // Méthode pour créer un nouvel utilisateur
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Méthode pour mettre à jour un utilisateur
    public User updateUser(Long id, User user) {
        User existingUser = getUserById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setPassword(user.getPassword());
            existingUser.setRole(user.getRole());
            existingUser.setName(user.getName());
            existingUser.setLastName(user.getLastName());
            existingUser.setMail(user.getMail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setManagedAgencies(user.getManagedAgencies());
            return userRepository.save(existingUser);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
