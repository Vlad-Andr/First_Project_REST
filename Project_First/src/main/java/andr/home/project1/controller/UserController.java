package andr.home.project1.controller;

import andr.home.project1.model.User;
import andr.home.project1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/add")
    public void addUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping("/user/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/user/getAll/{age}")
    public ResponseEntity<List<User>> getAllByAge(@PathVariable int age){
        List<User> allUsers = userService.allUsersByAge(age);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allUsers);
    }

    @GetMapping("/admin/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = userService.allUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }

    @PutMapping("/user/update/{id}")
    public void updateEmployee(@PathVariable Long id, @RequestBody User newUser){
        userService.updateUser(id, newUser);
    }

    @GetMapping("/user/get/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
