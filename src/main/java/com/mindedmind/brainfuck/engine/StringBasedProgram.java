package com.mindedmind.brainfuck.engine;

public class StringBasedProgram implements Program
{
	private char[] program;
	
	private int insnIndex = 0;

	public StringBasedProgram(String program)
	{
		this.program = program.toCharArray();
	}
	
	@Override public boolean next()
	{
		return ++insnIndex >= program.length ? false : true ;
	}

	@Override public boolean previous()
	{
		return --insnIndex < 0 ? false : true;
	}

	@Override public int getInsnIndex()
	{
		return insnIndex;
	}

	@Override public void moveTo(int index)
	{
		this.insnIndex = index;
	}

	@Override public char getCommand()
	{
		return program[insnIndex];
	}	
}
