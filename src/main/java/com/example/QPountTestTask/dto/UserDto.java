package com.example.QPountTestTask.dto;

import com.example.QPountTestTask.model.Order;
import com.example.QPountTestTask.model.User;

import java.util.List;

public class UserDto extends User {

    private final List<Order> orders;

    public List<Order> getOrders() {
        return orders;
    }

    public UserDto(User user,  List<Order> orders) {
        super(user.getId(), user.getFirstName(),user.getLastName());
        this.orders = orders;
    }
}