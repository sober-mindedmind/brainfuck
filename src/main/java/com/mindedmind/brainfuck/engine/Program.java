package com.mindedmind.brainfuck.engine;

public interface Program
{
	boolean next();
	
	boolean previous();
	
	int getInsnIndex();
	
	void moveTo(int index);

	char getCommand();
}
