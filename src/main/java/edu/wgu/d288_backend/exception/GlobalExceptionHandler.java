package edu.wgu.d288_backend.exception;


import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import edu.wgu.d288_backend.entities.ApiResponse;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex)
    {
      String msg = ex.getMessage();
      ApiResponse response = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
      return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiResponse> constraintViolation(ConstraintViolationException exception)
    {
        ApiResponse response = ApiResponse.builder()
                .message(exception.getMessage())
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse> handleValidationError(MethodArgumentNotValidException exception)
    {
        String errors = exception.getBindingResult().getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining(", ", "[", "]"));
        ApiResponse response = ApiResponse.builder()
                .message(errors)
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .build();

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ApiResponse> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ApiResponse response = ApiResponse.builder()
                .message(Objects.requireNonNull(ex.getMessage()).contains("Enum class: [canceled, ordered, pending]") ? "Cart status should be canceled, ordered or pending" : ex.getMessage())
                .success(false)
                .status(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
