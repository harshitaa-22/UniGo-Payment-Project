package com.bennett.unigo.wallet.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bennett.unigo.wallet.entity.User;
import com.bennett.unigo.wallet.model.CPrequest;
import com.bennett.unigo.wallet.model.LoginRequest;
import com.bennett.unigo.wallet.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;
    
    
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    
    @PostMapping("/login")
    public Boolean login(@RequestBody LoginRequest user) {
        return userService.login(user.getUserName(),user.getPassword());
    }
    
    @PostMapping("/changePassword")
    public Boolean changePassword(@RequestBody CPrequest request) {
        return userService.updateUserPassword(request.getUserName(), request.getOldPassword(), request.getNewPassword());
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
