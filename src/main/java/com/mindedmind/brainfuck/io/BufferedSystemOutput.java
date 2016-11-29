package com.mindedmind.brainfuck.io;

import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.IOException;

public class BufferedSystemOutput implements Output, Closeable
{
	private BufferedOutputStream bos; 	

	public BufferedSystemOutput()
	{
		this(8192);
	}
	
	public BufferedSystemOutput(int buffSize)
	{
		bos = new BufferedOutputStream(System.out, buffSize);
	}
	
	@Override public void writeChar(char c)
	{
		try
		{
			bos.write(c);
		}
		catch (IOException e)
		{
			throw new OutputException(e);
		}
	}

	@Override public void writeByte(byte b)
	{
		try
		{
			bos.write(b);
		}
		catch (IOException e)
		{
			throw new OutputException(e);
		}
	}

	@Override public void close() throws IOException
	{
		bos.close();
	}

}
