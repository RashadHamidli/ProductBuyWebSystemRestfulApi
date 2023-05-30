package com.company.exceptions;

public class NotFoundResourceException extends RuntimeException {

	private static final String ERROR = "Error: Resource not found";
	private static final long serialVersionUID = 1L;

	public NotFoundResourceException() {
		super(ERROR);
	}
}
