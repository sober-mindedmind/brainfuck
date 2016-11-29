package com.mindedmind.brainfuck.analysis;

public interface LoopsInfo
{
	int getLoopTail(int loopHead);
	
	int getLoopHead(int loopTail);
}
