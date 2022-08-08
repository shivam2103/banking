package com.shivam.banking.exception;

import com.shivam.banking.dto.error.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * ExceptionAdvice for handling custome and other exceptions to return generic error
 */
@ControllerAdvice
public class ExceptionAdvice {

    /**
     * Handling BaseException which are derived as customer exceptions.
     * @param ex
     * @return
     */
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponse> handleBaseException(BaseException ex) {
        return new ResponseEntity<>(ErrorResponse.builder()
                .code(ex.getCode())
                .message(ex.getMessage())
                .status(ex.getStatus())
                .build(),
                ex.getStatus());
    }
}
