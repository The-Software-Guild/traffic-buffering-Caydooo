package com.trackfic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ForeignKeyDeletionException extends RuntimeException {

	public ForeignKeyDeletionException(String message) {
		super(message);
	}
}
