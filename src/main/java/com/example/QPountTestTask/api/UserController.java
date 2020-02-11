package com.example.QPountTestTask.api;

import com.example.QPountTestTask.dto.UserDto;
import com.example.QPountTestTask.model.Order;
import com.example.QPountTestTask.model.User;
import com.example.QPountTestTask.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("user")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }
    @GetMapping
    public List<UserDto> getAllUsers() {

        return userService.getAllUsers();
    }
    @GetMapping(path ="{id")
    public UserDto getUserById(@PathVariable("id") Long userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping
    public void deleteUserById(@PathVariable("id") Long userId) {
        userService.deleteUserById(userId);
    }

    @PostMapping(path="{id}/order")
    public Order addOrder(@PathVariable("id") Long userId, @RequestBody Order order) {
        return userService.addOrder(userId, order);
    }
}
