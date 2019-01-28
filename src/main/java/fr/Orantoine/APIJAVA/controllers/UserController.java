package fr.Orantoine.APIJAVA.controllers;


import fr.Orantoine.APIJAVA.models.User;
import fr.Orantoine.APIJAVA.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
}
