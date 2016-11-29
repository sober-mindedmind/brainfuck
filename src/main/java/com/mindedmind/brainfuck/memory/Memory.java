package com.mindedmind.brainfuck.memory;

public interface Memory
{
	int read();
	
	void write(int data);
	
	int read(int pointer);
	
	void write(int pointer, int data);
	
	int forward();
	
	int backward();
	
	int getPointer();
	
}
