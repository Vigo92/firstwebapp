package com.restful.webapp.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restful.webapp.model.response.ErrorMessage;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request){
		
		String errorMessage = ex.getLocalizedMessage();
		if(errorMessage == null)
			errorMessage = ex.toString();
		ErrorMessage errorMessages = new ErrorMessage(new Date(), errorMessage);
		
		return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
@ExceptionHandler(value= {NullPointerException.class})	
public ResponseEntity<Object> handleNullPointerException(NullPointerException ne, WebRequest request){
		
		String errorMessage = ne.getLocalizedMessage();
		if(errorMessage == null)
			errorMessage = ne.toString();
		ErrorMessage errorMessages = new ErrorMessage(new Date(), errorMessage);
return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
		
		
	}

@ExceptionHandler(value= {UserServiceException.class})
 public ResponseEntity<Object> handleUserServiceException(UserServiceException ex, WebRequest web)
 {
	 
	String errorMessage = ex.getLocalizedMessage();
	if(errorMessage == null)
		errorMessage = ex.toString();
	ErrorMessage errorMessages  = new ErrorMessage(new Date(),errorMessage);
	return new ResponseEntity<>(errorMessages, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
 }
}
