package com.mindedmind.brainfuck.io;

public class StringBasedInput implements Input
{
	private final String input;

	private int pointer;
	
	public StringBasedInput(String input)
	{
		this.input = input;
	}

	@Override public char readChar()
	{
		if (pointer >= input.length())
		{
			throw new InputException("Can't read next portion of data from input, there is no data in input");
		}
		return input.charAt(pointer++);
	}

	@Override public byte readByte()
	{
		return (byte) readChar();
	}	
}
