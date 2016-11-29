package com.mindedmind.brainfuck.io;

public class InputException extends RuntimeException 
{
	public InputException(String message)
	{
		super(message);
	}

	public InputException(Throwable cause)
	{
		super(cause);
	}
	
}
