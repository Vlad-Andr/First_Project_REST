package andr.home.project1.service;

import andr.home.project1.model.User;
import andr.home.project1.repo.UserRepo;
import com.amazonaws.services.lambda.model.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Override
    public List<User> getAllUsersByAge(int age) {
        return userRepo.getUsersByAge(age);
    }

    @Override
    public User addNewUser(User user) {
       // user.setUserId(new Random().nextLong());
        userRepo.save(user);
        return user;
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
    public User updateUser(Long id, User newUser){
        User user = userRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());
        userRepo.save(user);
        return user;
        }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }
}
