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


/**
 * The Class SendErrorApi.
 * @creator DucNH66
 */
@RestControllerAdvice
public class SendErrorApi {
	
	/**
	 * @function Handle validation exceptions.
	 *
	 * @param ex the ex
	 * @creator DucNH66
	 * @date 2023-05-26
	 * @return the response entity
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> handleValidationExceptions(MethodArgumentNotValidException ex) {
	    BindingResult bindingResult = ex.getBindingResult();
	    Map<String, String> errorMessages = new HashMap<>();

	    for (FieldError fieldError : bindingResult.getFieldErrors()) {
	        errorMessages.put(fieldError.getField(), fieldError.getDefaultMessage());
	    }

	    for (ObjectError objectError : bindingResult.getGlobalErrors()) {
	        errorMessages.put(objectError.getObjectName(), objectError.getDefaultMessage());
	    }
	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessages);
	}

}
