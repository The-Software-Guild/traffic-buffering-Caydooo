package com.trackfic.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SeverityNotFoundException extends RuntimeException {

	public SeverityNotFoundException(String message) {

		super(message);
	}
}
