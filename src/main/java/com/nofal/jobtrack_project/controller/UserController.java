package com.nofal.jobtrack_project.controller;

import com.nofal.jobtrack_project.entity.User;
import com.nofal.jobtrack_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")


public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }
    @PostMapping("/")
    public User save(@RequestBody User user){
        return userService.save(user);
    }
    @GetMapping("/")
    public List<User> findAll(){
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @PutMapping("{/id}")
    public User update(@PathVariable Integer id, @RequestBody User user){
        User existingUser = userService.findById(id);

        existingUser.setUserName(user.getUserName());
        existingUser.setUserLastName(user.getUserLastName());
        existingUser.setJobTitle(user.getJobTitle());

        return userService.save(existingUser);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        userService.deleteById(id);
    }





}
