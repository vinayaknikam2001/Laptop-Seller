package com.laptop.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import javax.validation.UnexpectedTypeException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class AllExceptionHandler {

	

	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleInvalidArgument(MethodArgumentNotValidException ex) {
        Map<String, String> errorMap = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
	

	
    @ExceptionHandler(LaptopNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException(LaptopNotFoundException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", ex.getMessage());
        return new ResponseEntity<>(errorMap,HttpStatus.NOT_FOUND);
    }
	
    

    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException1(NumberFormatException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Invalid Input");
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    
//    @ExceptionHandler(HttpMessageNotReadableException.class)
//    public Map<String, String> handleBusinessException2(HttpMessageNotReadableException ex) {
//        Map<String, String> errorMap = new HashMap<>();
//        errorMap.put("errorMessage", "Price should be NUMBER");
//        return errorMap;
//    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Map<String, String>>  handleBusinessException2(HttpMessageNotReadableException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Price should be NUMBER");
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
	
    
    @ExceptionHandler(EmptyResultDataAccessException.class)
    public ResponseEntity<Map<String, String>> handleBusinessException1(EmptyResultDataAccessException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", " Laptop not present");
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    
    
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, String>>  handleBusinessException2(NoSuchElementException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Laptop not present");
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(UnexpectedTypeException.class)
    public ResponseEntity<Map<String, String>>  handleBusinessException3(UnexpectedTypeException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Webcam name should be unique");
        return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
    }
    

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Map<String, String> handleBusinessException2(HttpRequestMethodNotSupportedException ex) {
        Map<String, String> errorMap = new HashMap<>();
        errorMap.put("errorMessage", "Enter the id");
        return errorMap;
    }
}
