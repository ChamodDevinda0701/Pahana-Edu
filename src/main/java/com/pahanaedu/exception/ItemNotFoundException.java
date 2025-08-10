package com.pahanaedu.exception;

/**
 * Custom exception thrown when an item is not found in the system.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Default constructor with a standard message.
     */
    public ItemNotFoundException() {
        super("Item not found.");
    }

    /**
     * Constructor with a custom error message.
     *
     * @param message The custom error message.
     */
    public ItemNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom error message and cause.
     *
     * @param message The custom error message.
     * @param cause   The cause of the exception.
     */
    public ItemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause The cause of the exception.
     */
    public ItemNotFoundException(Throwable cause) {
        super(cause);
    }
}
