package com.example.auth.test;

import org.junit.Assert;
import org.junit.Test;

import com.example.auth.model.User;
import com.example.auth.service.InMemoryUserService;
import com.example.auth.service.UserService;

public class UserServiceTest {

    private final UserService userService = new InMemoryUserService();

    @Test
    public void addUserTest() {
        User newUser = new User();
        newUser.setName("Иван");
        newUser.setEmail("ivan@example.com");
        newUser.setPhone("+79123456789");
        User addedUser = userService.addUser(newUser);
        Assert.assertTrue("User's id is not greater then 0", addedUser.getId() > 0);
        Assert.assertEquals("Name doesn't match", newUser.getName(), addedUser.getName());
        Assert.assertEquals("Email doesn't match", newUser.getEmail(), addedUser.getEmail());
        Assert.assertEquals("Phone doesn't match", newUser.getPhone(), addedUser.getPhone());
    }

}
