package com.DAT250.exp2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
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
    public Collection<User> getUsers(String name) {
        return pollManager.getUsers().values();
    }

    @DeleteMapping("/{username}")
    public void deleteUser(@PathVariable String username) {
        pollManager.deleteUser(username);
    }

    @PutMapping("/{username}")
    public void updateUser(@PathVariable String username, @RequestBody User updatedUser) {
        User newUser = pollManager.getUsers().get(username);
        pollManager.deleteUser(username);
        newUser.setUsername(updatedUser.getUsername());
        newUser.setEmail(updatedUser.getEmail());
        pollManager.addUser(newUser);
    }
}


