package com.pahanaedu.model;

import java.io.Serializable;

/**
 * Represents a User in the Pahana Edu System.
 * This model holds all user-related information.
 */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;                 // Unique user ID
    private String username;        // Login username
    private String password;        // Encrypted password
    private String fullName;        // Full name of the user
    private String email;           // Email address
    private String role;            // Role of the user (e.g., ADMIN, STAFF, CUSTOMER)
    private boolean active;         // Account status

    /**
     * Default constructor.
     */
    public User() {
    }

    /**
     * Parameterized constructor for easy creation.
     *
     * @param id       the user ID
     * @param username the username
     * @param password the password (should be hashed)
     * @param fullName the full name
     * @param email    the email
     * @param role     the role
     * @param active   the active status
     */
    public User(int id, String username, String password, String fullName, String email, String role, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.active = active;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Returns a string representation of the user without exposing the password.
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                '}';
    }
}
