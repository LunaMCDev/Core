package me.lunamcdev.core.exception;

public final class ReflectionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReflectionException(final String message) {
		super(message);
	}

	public ReflectionException(final Throwable ex, final String message) {
		super(message, ex);
	}
}