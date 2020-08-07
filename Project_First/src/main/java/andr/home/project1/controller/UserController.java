package andr.home.project1.controller;

import andr.home.project1.model.User;
import andr.home.project1.service.UserService;
import andr.home.project1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(@Qualifier("userServiceJDBCImpl") UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public void addUser(@RequestBody User user){
        userService.addNewUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/getAll/{age}")
    public ResponseEntity<List<User>> getAllByAge(@PathVariable int age){
        List<User> allUsers = userService.allUsersByAge(age);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(allUsers);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<User>> getAll(){
        List<User> all = userService.allUsers();
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(all);
    }

    @PutMapping("/update/{id}")
    public void updateEmployee(@PathVariable Long id,
                                               @RequestBody User newUser){
        userService.updateUser(id, newUser);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<User>> getById(@PathVariable Long id){
        List<User> user = userService.getUserById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
