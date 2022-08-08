package com.shivam.banking.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * Base Exception class
 */
@Getter
public class BaseException extends RuntimeException{

    private String message;

    private String code;

    private HttpStatus status;

    /**
     * Constructor with all the 3 params
     * @param message
     * @param code
     * @param status
     */
    public BaseException(String message, String code, HttpStatus status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

}
