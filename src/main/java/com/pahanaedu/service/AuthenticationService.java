package com.pahanaedu.service;

import com.pahanaedu.dto.UserDto;
import com.pahanaedu.dao.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService() {
        this.userDao = new UserDao();  // DAO responsible for reading users.txt
    }

    public UserDto authenticate(String username, String password) {
        // Use UserDao to load user by username
        UserDto user = userDao.getUserByUsername(username);

        if (user != null && user.getPassword() != null && user.getPassword().equals(password)) {
            return user;  // credentials match
        }
        return null; // login failed
    }
}
