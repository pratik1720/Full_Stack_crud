package com.fullstack_demo.controller;

import com.fullstack_demo.exception.UseNotFoundException;
import com.fullstack_demo.model.User;
import com.fullstack_demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    private UserRepository userrepository;
    @PostMapping("/user")
    User newuser(@RequestBody  User newuser){
        return userrepository.save(newuser);
    }
    @GetMapping("/users")
    List<User> getAlluser(){
        return userrepository.findAll();
    }
    @GetMapping("user/{id}")
    User getUserById(@PathVariable Long id){
         return userrepository.findById(id).orElseThrow(()->new UseNotFoundException(id));
    }
    @PutMapping("user/{id}")
    User updateUserById(@RequestBody User newUser,@PathVariable Long id){
        return userrepository.findById(id).map(user -> {
            user.setName(newUser.getName());
            user.setUsername(newUser.getUsername());
            user.setEmail(newUser.getEmail());
           return  userrepository.save(user);
        }).orElseThrow(()->new UseNotFoundException(id));
    }
    @DeleteMapping("user/{id}")
     String deleteUserById(@PathVariable Long id){
        if(!userrepository.existsById(id)){
             throw new UseNotFoundException(id);
        }
        userrepository.deleteById(id);
        return "User with id  "+id+" has been successfully deleted ";
    }
}
