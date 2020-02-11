package com.example.QPountTestTask.service;

import com.example.QPountTestTask.dao.UserDao;
import com.example.QPountTestTask.dto.UserDto;
import com.example.QPountTestTask.model.Order;
import com.example.QPountTestTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("postgres") UserDao userDao) {
        this.userDao = userDao;
    }

    public void addUser(User user) {
        userDao.addUser(user);
    }
    public List<UserDto> getAllUsers() {

        return userDao.getAllUsers();
    }

    public UserDto getUserById(Long userId) {
        return userDao.getUserById(userId);
    }

    public void deleteUserById(Long userId) {
        userDao.deleteUserById(userId);
    }

    public Order addOrder(Long userId, Order order) {
        return userDao.addOrder(userId, order);
    }
}
