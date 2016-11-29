package com.mindedmind.brainfuck.analysis;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import com.mindedmind.brainfuck.SyntaxException;
import com.mindedmind.brainfuck.engine.Program;

public class LinearLoopAnalyzer implements LoopAnalyzer
{
	private static class MapBasedLoopInfo implements LoopsInfo
	{
		private final Map<Integer, Integer> loops = new HashMap<>();
		
		@Override public int getLoopTail(int loopHead)
		{
			return loops.get(loopHead);
		}

		@Override public int getLoopHead(int loopTail)
		{
			return loops.get(loopTail);
		}
	}
	
	@Override public LoopsInfo analyzeLoops(Program program)
	{		
		MapBasedLoopInfo loopsInfo = new MapBasedLoopInfo();
		Deque<Integer> d = new ArrayDeque<Integer>();
		do
		{
			char command = program.getCommand();
			if (command == '[')
			{
				d.push(program.getInsnIndex());
			}
			else if (command == ']')
			{
				int begin = d.pop();
				loopsInfo.loops.put(begin , program.getInsnIndex());
				loopsInfo.loops.put(program.getInsnIndex() , begin);
			}
		} while(program.next());
		if (!d.isEmpty())
		{
			throw new SyntaxException("Some loops are improperly defined at " + d);
		}
		program.moveTo(0);
		return loopsInfo;
	}

}
