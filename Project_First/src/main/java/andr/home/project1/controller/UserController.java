package andr.home.project1.controller;

import andr.home.project1.model.User;
import andr.home.project1.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user){
        userService.addNewUser(user);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }

    @GetMapping("/getAll/{age}")
    public ResponseEntity<List<User>> getAllByAge(@PathVariable int age){
        List<User> allUsers = userService.getAllUsersByAge(age);
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
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,
                                                 @RequestBody User newUser){
        User user = userService.updateUser(id, newUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User : " + user.toString() + " was updated succesfully");
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable Long id){
        Optional<User> optionalUser = userService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(optionalUser);
    }
}
