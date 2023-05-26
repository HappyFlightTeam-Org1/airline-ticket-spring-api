package com.fsoft.happflight.error;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SendErrorApi {
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    BindingResult bindingResult = ex.getBindingResult();
	    Map<String, String> errorMessages = new HashMap<>();

	    // Process field errors
	    for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
	    }

	    // Process global errors
	    for (ObjectError objectError : bindingResult.getGlobalErrors()) {
	        errorMessages.put(objectError.getObjectName(), objectError.getDefaultMessage());
	    }

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
	}

}
