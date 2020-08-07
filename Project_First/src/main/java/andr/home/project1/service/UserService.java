package andr.home.project1.service;

import andr.home.project1.model.User;

import java.util.List;


public interface UserService {

    void addNewUser(User user);
    List<User> allUsers();
    void deleteUser(Long id);
    void updateUser(Long id, User user);
    List<User> allUsersByAge(int age);
    List<User> getUserById(Long id);
}
