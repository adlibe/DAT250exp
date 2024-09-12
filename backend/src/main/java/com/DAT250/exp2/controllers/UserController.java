package com.DAT250.exp2.controllers;

import com.DAT250.exp2.PollManager;
import com.DAT250.exp2.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    private final PollManager pollManager;

    public UserController(@Autowired PollManager pollManager) {
        this.pollManager = pollManager;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        pollManager.addUser(user);
    }

    @GetMapping
    public Collection<User> getUsers() {
        return pollManager.getUsers().values();
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        pollManager.deleteUser(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        User existingUser = pollManager.getUsers().get(username);
        existingUser.setUsername(updatedUser.getUsername());
        existingUser.setEmail(updatedUser.getEmail());
        }
    }


