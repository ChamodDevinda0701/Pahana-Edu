package com.pahanaedu.filter;

import java.util.regex.Pattern;

/**
 * Utility class for validating user inputs such as usernames,
 * passwords, account numbers, and other text fields.
 */
public class InputValidator {

    // Patterns for validation
    private static final Pattern USERNAME_PATTERN = Pattern.compile("^[A-Za-z0-9_]{3,20}$");
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^.{6,50}$");
    private static final Pattern ACCOUNT_NUMBER_PATTERN = Pattern.compile("^[0-9]{6,12}$");
    private static final Pattern NAME_PATTERN = Pattern.compile("^[A-Za-z ]{2,50}$");

    /**
     * Validates a username.
     *
     * @param username the username to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidUsername(String username) {
        return username != null && USERNAME_PATTERN.matcher(username).matches();
    }

    /**
     * Validates a password.
     * Password can contain any characters but must be between 6 and 50 characters long.
     *
     * @param password the password to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidPassword(String password) {
        return password != null && PASSWORD_PATTERN.matcher(password).matches();
    }

    /**
     * Validates an account number.
     * Account number must be numeric and 6 to 12 digits long.
     *
     * @param accountNumber the account number to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidAccountNumber(String accountNumber) {
        return accountNumber != null && ACCOUNT_NUMBER_PATTERN.matcher(accountNumber).matches();
    }

    /**
     * Validates a name.
     * Name can only contain letters and spaces, and must be between 2 and 50 characters.
     *
     * @param name the name to validate
     * @return true if valid, false otherwise
     */
    public static boolean isValidName(String name) {
        return name != null && NAME_PATTERN.matcher(name).matches();
    }

    /**
     * Checks if a string is not null and not empty.
     *
     * @param value the string to check
     * @return true if not null and not empty, false otherwise
     */
    public static boolean isNotEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
