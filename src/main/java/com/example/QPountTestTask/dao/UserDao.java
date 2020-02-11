package com.example.QPountTestTask.dao;

import com.example.QPountTestTask.dto.UserDto;
import com.example.QPountTestTask.model.Order;
import com.example.QPountTestTask.model.User;

import java.util.List;

public interface UserDao {

    void addUser( User user);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long userId);

    void deleteUserById(Long userId);

    Order addOrder(Long userId, Order order);


}

