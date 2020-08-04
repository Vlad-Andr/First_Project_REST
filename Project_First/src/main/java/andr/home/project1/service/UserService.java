package andr.home.project1.service;

import andr.home.project1.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> getAllUsersByAge(int age);
    User addNewUser(User user);
    Iterable<User> allUsers();
    void deleteUser(Long id);
    User updateUser(Long id, User user);
    Optional<User> findById(Long id);
}
