package com.example.QPountTestTask.dao;

import com.example.QPountTestTask.dto.UserDto;
import com.example.QPountTestTask.model.Order;
import com.example.QPountTestTask.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("postgres")
public class UserDaoService implements UserDao {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<UserDto> userDtos = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for(User user : users ){
            List<Order> orders = orderRepository.findByUserId(user.getId());
            userDtos.add( new UserDto(user,orders));
        }
        return  userDtos;
    }

    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId).get();
        return new UserDto( user,orderRepository.findByUserId(userId));
    }

    @Override
    public void deleteUserById(Long userId) {
         userRepository.deleteById(userId);
    }


    @Override
    public Order addOrder(Long userId, Order order) {
        return orderRepository.save(order);
    }
}
