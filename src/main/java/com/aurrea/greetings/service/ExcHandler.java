package com.aurrea.greetings.service;


import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExcHandler {

	@ExceptionHandler(PSQLException.class)
	public ResponseEntity<ErrorDetails> psqlExc(PSQLException e, WebRequest req){
		ErrorDetails error = new ErrorDetails("Tipo de saludo ya existente", 900 );
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}