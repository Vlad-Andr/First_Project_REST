package andr.home.project1.service;

import andr.home.project1.model.User;
import andr.home.project1.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepo userRepo;

    @Override
    public void addNewUser(User user) {

    }

    @Override
    public List<User> allUsers() {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public void updateUser(Long id, User user) {

    }

    @Override
    public List<User> allUsersByAge(int age) {
        return null;
    }

    @Override
    public List<User> getUserById(Long id) {
        return null;
    }

   /* @Override
    public List<User> getAllUsersByAge(int age) {
        return userRepo.getUsersByAge(age);
    }

    @Override
    public void addNewUser(User user) {
        user.setUserId(new Random().nextLong());
        userRepo.save(user);
    }

    @Override
    public List<User> allUsers() {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void updateUser(Long id, User newUser){
        User user = userRepo.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setAge(newUser.getAge());
        userRepo.save(user);
        }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepo.findById(id);
        return user;
    }*/
}
