package ru.plastinin.petproject.stafftesting.exception;

public class JdbcSQLDataException extends RuntimeException {
    public JdbcSQLDataException(String message) {
        super(message);
    }
}
