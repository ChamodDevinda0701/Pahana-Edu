package com.pahanaedu.exception;

/**
 * Custom exception for authentication-related errors.
 * Thrown when login credentials are invalid or unauthorized access is attempted.
 */
public class AuthenticationException extends Exception {

    /**
     * Default constructor with no message.
     */
    public AuthenticationException() {
        super("Authentication failed. Please check your username and password.");
    }

    /**
     * Constructor with a custom error message.
     *
     * @param message The error message.
     */
    public AuthenticationException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom message and cause.
     *
     * @param message The error message.
     * @param cause   The cause of the exception.
     */
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause The cause of the exception.
     */
    public AuthenticationException(Throwable cause) {
        super(cause);
    }
}
