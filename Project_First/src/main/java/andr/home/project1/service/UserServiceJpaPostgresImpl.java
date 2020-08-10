package andr.home.project1.service;

import andr.home.project1.model.User;
import andr.home.project1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceJpaPostgresImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public void addNewUser(User user) {
        userRepo.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User user) {
        userRepo.deleteById(id);
        userRepo.save(user);
    }

    @Override
    public List<User> allUsersByAge(int age) {
        return userRepo.getUsersByAge(age);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findUserByFirstName(username).get();
    }
}
