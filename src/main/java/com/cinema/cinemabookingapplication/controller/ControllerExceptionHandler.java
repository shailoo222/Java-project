package com.cinema.cinemabookingapplication.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.cinema.cinemabookingapplication.entity.ErrorMessage;
import com.cinema.cinemabookingapplication.exception.BookingNotFoundException;
import com.cinema.cinemabookingapplication.exception.CustomerNotFoundException;
import com.cinema.cinemabookingapplication.exception.MovieNotFoundException;
import com.cinema.cinemabookingapplication.exception.ShowNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {
	@ExceptionHandler(BookingNotFoundException.class)
	  public ResponseEntity<ErrorMessage> BookingNotFoundException(BookingNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	@ExceptionHandler(MovieNotFoundException.class)
	  public ResponseEntity<ErrorMessage> MovieNotFoundException(MovieNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	@ExceptionHandler(CustomerNotFoundException.class)
	  public ResponseEntity<ErrorMessage> CustomerNotFoundException(CustomerNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	
	@ExceptionHandler(ShowNotFoundException.class)
	  public ResponseEntity<ErrorMessage> ShowNotFoundException(ShowNotFoundException ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.NOT_FOUND.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.NOT_FOUND);
	  }
	  @ExceptionHandler(Exception.class)
	  public ResponseEntity<ErrorMessage> globalExceptionHandler(Exception ex, WebRequest request) {
	    ErrorMessage message = new ErrorMessage(
	        HttpStatus.INTERNAL_SERVER_ERROR.value(),
	        new Date(),
	        ex.getMessage(),
	        request.getDescription(false));
	    
	    return new ResponseEntity<ErrorMessage>(message, HttpStatus.INTERNAL_SERVER_ERROR);
	  }
}
