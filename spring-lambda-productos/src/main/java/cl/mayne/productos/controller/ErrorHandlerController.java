package cl.mayne.productos.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import cl.mayne.productos.exception.ExceptionResponse;

@RestControllerAdvice
public class ErrorHandlerController {

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ExceptionResponse> runtimeExceptionHandler(RuntimeException e){
		ExceptionResponse exception = ExceptionResponse
				.builder()
				.timestamp(new Date())
				.mensaje(e.getMessage())
				.detalles(e.getClass().getCanonicalName())
				.httpCodeMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
				.build();
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> generalExceptionHandler(Exception e) {
		ExceptionResponse exception = ExceptionResponse
				.builder()
				.timestamp(new Date())
				.mensaje(e.getMessage())
				.detalles(e.getClass().getCanonicalName())
				.httpCodeMessage(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
				.build();
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
