package com.pahanaedu.mapper;

import com.pahanaedu.dto.UserDto;

public class UserMapper {


    /**
     * Converts CSV fields to a UserDto.
     * Expects fields in order: username, password, fullname, email
     *
     * @param fields CSV fields array
     * @return UserDto object or null if invalid input
     */
    public static UserDto toUserDto(String[] fields) {
        if (fields == null || fields.length < 4) {
            return null; // or throw IllegalArgumentException
        }
        String username = fields[0].trim();
        String password = fields[1].trim();
        String fullname = fields[2].trim();
        String email = fields[3].trim();

        return new UserDto(username, password, fullname, email);
    }

    /**
     * Converts a UserDto to a CSV line string.
     *
     * @param user UserDto object
     * @return CSV string line
     */
    public static String toCsvLine(UserDto user) {
        if (user == null) {
            return "";
        }
        return String.join(",",
                user.getUsername(),
                user.getPassword(),
                user.getFullname(),
                user.getEmail());
    }

}
