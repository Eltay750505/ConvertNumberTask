package ru.mail.gasimov20177.exception;

public class ConvertNumberException extends Exception {
    public ConvertNumberException() {
    }

    public ConvertNumberException(String message) {
        super(message);
    }

    public ConvertNumberException(String message, Throwable cause) {
        super(message, cause);
    }

    public ConvertNumberException(Throwable cause) {
        super(cause);
    }
}
