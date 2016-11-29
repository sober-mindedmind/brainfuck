package com.mindedmind.brainfuck.memory;

import java.util.HashMap;
import java.util.Map;

public class UnlimitedMapBasedMemory extends AbstractMemory
{
	private final Map<Integer, Integer> memory = new HashMap<>();
	
	public UnlimitedMapBasedMemory()
	{}
	
	public UnlimitedMapBasedMemory(int pointer, int cellBound)
	{
		super(pointer, cellBound);
	}	
	
	@Override public int read(int pointer)
	{
		return memory.getOrDefault(pointer , 0);
	}

	@Override public void write(int pointer, int data)
	{		
		memory.put(pointer, prepareData(data));
	}	
}
