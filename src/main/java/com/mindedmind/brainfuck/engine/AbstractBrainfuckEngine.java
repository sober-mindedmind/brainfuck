package com.mindedmind.brainfuck.engine;

public abstract class AbstractBrainfuckEngine
{
	protected Program program;
	
	public AbstractBrainfuckEngine(Program program)
	{
		this.program = program;
	}
	
	public void process()
	{
		do
		{
			switch(program.getCommand())
			{
			case '<':
				moveLeft();				
				break;
			case '>':
				moveRight();
				break;
			case '+':
				increase();
				break;
			case '-':
				decrease();
				break;
			case '.':
				writeOutput();
				break;
			case ',':				
				readInput();
				break;
			case '[':				
				loopBegin();
				break;
			case ']':
				loopEnd();
				break;
			}			
		} while(program.next());
	}
	
	protected abstract void moveLeft();
	
	protected abstract void moveRight();
	
	protected abstract void increase();
	
	protected abstract void decrease();
	
	protected abstract void readInput();
	
	protected abstract void writeOutput();
	
	protected abstract void loopBegin();
	
	protected abstract void loopEnd();
}
