package com.mindedmind.brainfuck.io;

public class OutputException extends RuntimeException
{
	public OutputException(String message)
	{
		super(message);
	}

	public OutputException(Throwable cause)
	{
		super(cause);
	}
}
