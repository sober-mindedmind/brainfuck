package com.mindedmind.brainfuck.memory;

public abstract class AbstractMemory implements Memory
{	
	public enum CellSize
	{
		EIGHT_BITS(255),
		SIXTEEN_BITS(65535),
		THIRTY_TWO_BITS(Integer.MAX_VALUE);
		
		private int size;
		
		private CellSize(int size)
		{
			this.size = size;
		}
		
		public int getSize()
		{
			return size;
		}		
	}
	
	private int cellBound = 255;
	
	private int pointer;
	
	protected AbstractMemory()
	{}
	
	protected AbstractMemory(int pointer, int cellBound)
	{
		this.pointer = pointer;
		this.cellBound = cellBound;
	}	
	
	protected AbstractMemory(int pointer, CellSize cellBound)
	{
		this(pointer, cellBound.getSize());
	}

	@Override public int forward()
	{		
		return pointer++;
	}

	@Override public int backward()
	{
		return pointer--;
	}

	@Override public int getPointer()
	{
		return pointer;
	}
	
	protected int prepareData(int data)
	{
		return data > cellBound ? 0 : data < 0 ? cellBound : data;
	}

	@Override public int read()
	{
		return read(pointer);
	}

	@Override public void write(int data)
	{
		write(pointer, data);
	}
}
