package com.mindedmind.brainfuck.io;

import java.io.IOException;

public class SystemInput implements Input
{

	@Override public char readChar()
	{
		try
		{
			return (char) System.in.read();
		}
		catch (IOException e)
		{
			throw new InputException(e);
		}
	}

	@Override public byte readByte()
	{
		return (byte) readChar();
	}

}
