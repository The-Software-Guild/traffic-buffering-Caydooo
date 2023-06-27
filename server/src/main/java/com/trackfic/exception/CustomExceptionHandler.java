package com.trackfic.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(), "An Exception Occured");

		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(IntegrityConstraintUnsatisfiedException.class)
	public final ResponseEntity<Object> handleIntegrityConstraintUnsatisfiedException(
			IntegrityConstraintUnsatisfiedException ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"A data integrity exception has occured");

		return new ResponseEntity(response, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(WitnessNotFoundException.class)
	public final ResponseEntity<Object> handleWitnessNotFoundException(WitnessNotFoundException ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"Witness with specified email not found");
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(LocationNotFoundException.class)
	public final ResponseEntity<Object> handleLocationNotFoundException(LocationNotFoundException ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"Location with specified ID not found");
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccidentTypeNotFoundException.class)
	public final ResponseEntity<Object> handleAccidentTypeNotFoundException(AccidentTypeNotFoundException ex,
			WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"AccidentType with specified ID not found");
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AccidentNotFoundException.class)
	public final ResponseEntity<Object> handleAccidentNotFoundException(AccidentNotFoundException ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"Accident with specified ID not found");
		return new ResponseEntity(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ForeignKeyDeletionException.class)
	public final ResponseEntity<Object> handleForeignKeyDeletionException(ForeignKeyDeletionException ex,
			WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"User is attempting to delete an entry that is referenced by foreign keys");
		return new ResponseEntity(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(DataMismatchException.class)
	public final ResponseEntity<Object> handleForeignKeyDeletionException(DataMismatchException ex, WebRequest req) {
		ExceptionResponse response = new ExceptionResponse(new Date(), ex.getMessage(),
				"User is attmepting to update data with inconsistencies");
		return new ResponseEntity(response, HttpStatus.CONFLICT);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

//		ExceptionResponse response = new ExceptionResponse(new Date(),"Validation Failed",ex.getBindingResult().toString());
		ExceptionResponse response = new ExceptionResponse(new Date(), "Validation Failed",
				ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());

//		List<ObjectError> errors = ex.getBindingResult().getAllErrors();
//		
//		for(ObjectError e: errors)
//		{
//			System.out.println(e.getDefaultMessage());
//		}

		return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
	}

}
