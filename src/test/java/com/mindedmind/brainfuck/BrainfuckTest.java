package com.mindedmind.brainfuck;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mindedmind.brainfuck.analysis.LinearLoopAnalyzer;
import com.mindedmind.brainfuck.engine.Program;
import com.mindedmind.brainfuck.engine.StringBasedProgram;
import com.mindedmind.brainfuck.engine.interpreter.BrainfuckInterpreterEngine;
import com.mindedmind.brainfuck.io.StringBasedInput;
import com.mindedmind.brainfuck.io.StringBasedOutput;
import com.mindedmind.brainfuck.memory.UnlimitedMapBasedMemory;

public class BrainfuckTest
{

	@Test 
	public void process_CortrectExecution_PrintsHandHelloWorld()
	{
		final char[] input = {8, 9};
		StringBasedOutput sb = new StringBasedOutput();
			
		Program program = new StringBasedProgram(",>,<[>[->+>+<<]>>[-<<+>>]<<<-]>>.");
		new BrainfuckInterpreterEngine(program,
				new UnlimitedMapBasedMemory(),
				new StringBasedInput(String.valueOf(input[0]) + String.valueOf(input[1])),
				sb,
				new LinearLoopAnalyzer().analyzeLoops(program)).process();
		
		assertEquals(sb.getOutput(), "H");
		
		sb = new StringBasedOutput();
		
		Program program1 = new StringBasedProgram(",[.[-],]"); 
		
		new BrainfuckInterpreterEngine(program1,
				new UnlimitedMapBasedMemory(),
				new StringBasedInput("Hello world" + ((char) 0)),
				sb,
				new LinearLoopAnalyzer().analyzeLoops(program1)).process();
		
		assertEquals(sb.getOutput(), "Hello world");
	}
	
	@Test 
	public void process_CorrectExecution_GeneratesAndPrintsHelloWorld()
	{
		Program program = new StringBasedProgram("++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.");
		StringBasedOutput sb = new StringBasedOutput();
		new BrainfuckInterpreterEngine(program,
				new UnlimitedMapBasedMemory(),
				new StringBasedInput(""),
				sb,
				new LinearLoopAnalyzer().analyzeLoops(program)).process();
						
		assertEquals(sb.getOutput().trim(), "Hello World!");		
	}
	
}
