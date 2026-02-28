package org.example.ems_new.Exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorCode> handleEmployeeNotFound(EmployeeNotFoundException exception, HttpServletRequest request){
        ErrorCode error = new ErrorCode(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                exception.getMessage(),
                HttpStatus.NOT_FOUND.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<ErrorCode>(error, HttpStatus.NOT_FOUND);
    }


    // 🟡 Handle Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorCode> handleValidationException(
            MethodArgumentNotValidException ex,
            HttpServletRequest request) {

        String errorMessage = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError ->
                        fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ErrorCode error = new ErrorCode(
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                errorMessage,
                HttpStatus.BAD_REQUEST.value(),
                request.getRequestURI()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorCode> handleGenricError(Exception exception, HttpServletRequest request){
        return new ResponseEntity<ErrorCode>(new ErrorCode(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), request.getRequestURI() ), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
