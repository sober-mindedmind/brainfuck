package com.mindedmind.brainfuck.io;

public class StringBasedOutput implements Output
{
	private StringBuilder sb = new StringBuilder();
	
	@Override public void writeChar(char c)
	{
		sb.append(c);
	}

	@Override public void writeByte(byte b)
	{
		sb.append(b);
	}
	
	public String getOutput()
	{
		return sb.toString();
	}
}
