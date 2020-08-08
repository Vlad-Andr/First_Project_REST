package andr.home.project1.service;

import andr.home.project1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void addNewUser(User user);
    List<User> allUsers();
    void deleteUser(Long id);
    void updateUser(Long id, User user);
    List<User> allUsersByAge(int age);
    Optional<User> getUserById(Long id);
}
