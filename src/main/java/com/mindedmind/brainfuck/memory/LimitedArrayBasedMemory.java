package com.mindedmind.brainfuck.memory;

public class LimitedArrayBasedMemory extends AbstractMemory
{
	private int[] memory;
	
	public LimitedArrayBasedMemory(int size)
	{
		memory = new int[size];
	}

	@Override public int read(int pointer)
	{
		return memory[pointer];
	}

	@Override public void write(int pointer, int data)
	{
		memory[pointer] = prepareData(data);
	}
}
