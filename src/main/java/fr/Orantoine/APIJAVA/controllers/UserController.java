package fr.Orantoine.APIJAVA.controllers;


import fr.Orantoine.APIJAVA.models.User;
import fr.Orantoine.APIJAVA.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/")
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @PostMapping(path = "/")
    public User saveUser(@RequestBody User newUser){
        System.out.println(newUser.toString());
        userRepository.save(newUser);
        return newUser;
    }

    @GetMapping(path = "/{id}")
    public User findById(@PathVariable String id){
        return userRepository.findById(id).orElse(null);
    }

    @PutMapping(path = "/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User updateUser){
        Optional<User> user = userRepository.findById(id);
        updateUser.setId(id);
        return userRepository.save(updateUser);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteUser(@PathVariable String id){
        System.out.println("Suppresion en cours");
        userRepository.deleteById(id);
    }

}
