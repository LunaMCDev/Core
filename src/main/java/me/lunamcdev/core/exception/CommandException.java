package me.lunamcdev.core.exception;

import lombok.Getter;

public class CommandException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	@Getter
	private final String[] messages;
	
	public CommandException(String... messages) {
		super("");

		this.messages = messages;
	}
}