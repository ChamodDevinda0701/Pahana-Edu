package com.pahanaedu.exception;

/**
 * Custom exception thrown when a customer is not found in the system.
 */
public class CustomerNotFoundException extends Exception {

    /**
     * Default constructor with a standard message.
     */
    public CustomerNotFoundException() {
        super("Customer not found.");
    }

    /**
     * Constructor with a custom error message.
     *
     * @param message The custom error message.
     */
    public CustomerNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom error message and cause.
     *
     * @param message The custom error message.
     * @param cause   The cause of the exception.
     */
    public CustomerNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause The cause of the exception.
     */
    public CustomerNotFoundException(Throwable cause) {
        super(cause);
    }
}
