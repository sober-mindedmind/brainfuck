package com.mindedmind.brainfuck.io;

import java.util.ArrayList;
import java.util.List;

public class MultiOutput implements Output
{
	private List<Output> outputs = new ArrayList<>();
	
	public void addOutput(Output o)	
	{
		outputs.add(o);
	}

	@Override public void writeChar(char c)
	{
		outputs.forEach(o -> o.writeChar(c));
	}

	@Override public void writeByte(byte b)
	{
		outputs.forEach(o -> o.writeByte(b));
	}

}
