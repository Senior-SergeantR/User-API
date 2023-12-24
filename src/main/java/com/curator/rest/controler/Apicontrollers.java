package com.curator.rest.controler;

import com.curator.rest.Repo.UserRepo;
import com.curator.rest.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Apicontrollers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping(value="/")
    public String getPage(){
        return "Welcome";
    }
    @GetMapping(value = "/users")
    public List<user> getUsers1(){
        return userRepo.findAll();
    }

    @PostMapping(value = "/save")
    public String saveUser(@RequestBody user user){
        userRepo.save(user);
        return "Saved...";
    }
    @PutMapping(value="/update/{id}")
    public String updateUser(@PathVariable long id, @RequestBody user user){
        user updatedUser = userRepo.findById(id).get();
        updatedUser.setFirstName(user.getFirstName());
        updatedUser.setLastName(user.getLastName());
        updatedUser.setAge(user.getAge());
        updatedUser.setOccupation(user.getOccupation());
        userRepo.save(updatedUser);

        return  "Updated...";

    }
    @DeleteMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable long id){
        user deleteUser = userRepo.findById(id).get();
        userRepo.delete(deleteUser);

        return "deleted Successfully... user id "+id;
    }
}
