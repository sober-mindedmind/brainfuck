package com.mindedmind.brainfuck.io;

public class SystemOutput implements Output
{
	@Override public void writeChar(char c)
	{
		System.out.print(c);
	}

	@Override public void writeByte(byte b)
	{
		System.out.print(b);
	}
}
