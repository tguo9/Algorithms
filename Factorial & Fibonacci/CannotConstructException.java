package edu.usfca.cs.cs245;

public class CannotConstructException extends Exception {

	private static final long serialVersionUID = 24501L;

	public CannotConstructException() {
		// NOP
	}

	public CannotConstructException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public CannotConstructException(Throwable cause) {
		super(cause);
	}

	public CannotConstructException(String message, Throwable cause) {
		super(message, cause);
	}

	public CannotConstructException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
