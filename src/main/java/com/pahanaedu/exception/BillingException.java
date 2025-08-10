package com.pahanaedu.exception;

/**
 * Custom exception thrown when a billing operation fails.
 */
public class BillingException extends Exception {

    /**
     * Default constructor with a standard message.
     */
    public BillingException() {
        super("An error occurred during the billing process.");
    }

    /**
     * Constructor with a custom error message.
     *
     * @param message The custom error message.
     */
    public BillingException(String message) {
        super(message);
    }

    /**
     * Constructor with a custom error message and cause.
     *
     * @param message The custom error message.
     * @param cause   The cause of the exception.
     */
    public BillingException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with a cause.
     *
     * @param cause The cause of the exception.
     */
    public BillingException(Throwable cause) {
        super(cause);
    }
}
