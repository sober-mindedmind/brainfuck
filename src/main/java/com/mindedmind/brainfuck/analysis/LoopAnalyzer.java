package com.mindedmind.brainfuck.analysis;

import com.mindedmind.brainfuck.engine.Program;

public interface LoopAnalyzer
{
	LoopsInfo analyzeLoops(Program program);
}
