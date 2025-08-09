package com.pahanaedu.dao;

import com.pahanaedu.dto.UserDto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * DAO class for accessing user data.
 * Reads from "users.txt" where each line is:
 * username,password,fullname,email
 */

public class UserDao {
    private static final String USER_FILE = "users.txt";

    /**
     * Retrieves a UserDto by username.
     * @param username The username to search.
     * @return UserDto if found, else null.
     */
    public UserDto getUserByUsername(String username) {
        try (BufferedReader br = new BufferedReader(new FileReader(USER_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    String fileUsername = parts[0].trim();
                    if (fileUsername.equals(username)) {
                        String password = parts[1].trim();
                        String fullname = parts[2].trim();
                        String email = parts[3].trim();
                        return new UserDto(fileUsername, password, fullname, email);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // User not found
    }
}
