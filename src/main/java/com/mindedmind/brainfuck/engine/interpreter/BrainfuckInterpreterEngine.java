package com.mindedmind.brainfuck.engine.interpreter;

import com.mindedmind.brainfuck.analysis.LoopsInfo;
import com.mindedmind.brainfuck.engine.AbstractBrainfuckEngine;
import com.mindedmind.brainfuck.engine.Program;
import com.mindedmind.brainfuck.io.Input;
import com.mindedmind.brainfuck.io.Output;
import com.mindedmind.brainfuck.memory.Memory;

public class BrainfuckInterpreterEngine extends AbstractBrainfuckEngine
{	
	private final Memory memory;

	private final Input input;
	
	private final Output output;
	
	private final LoopsInfo loops;	

	public BrainfuckInterpreterEngine(Program program, 
									  Memory memory, 
									  Input input,
									  Output output,
									  LoopsInfo loops)
	{
		super(program);
		this.memory = memory;
		this.input = input;
		this.output = output;
		this.loops = loops;
		
	}
	
	@Override protected void moveLeft()
	{
		memory.backward();
	}

	@Override protected void moveRight()
	{
		memory.forward();
	}

	@Override protected void increase()
	{
		memory.write(memory.read() + 1);
	}

	@Override protected void decrease()
	{
		memory.write(memory.read() - 1);
	}

	@Override protected void readInput()
	{
		memory.write(input.readChar());
	}

	@Override protected void writeOutput()
	{
		output.writeChar((char) memory.read());
	}

	@Override protected void loopBegin()
	{		
		if (memory.read() == 0)
		{
			program.moveTo(loops.getLoopTail(program.getInsnIndex()));
		}
	}

	@Override protected void loopEnd()
	{
		program.moveTo(loops.getLoopHead(program.getInsnIndex()) - 1);
	}
}
