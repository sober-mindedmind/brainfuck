package com.mindedmind.brainfuck.util;

import static java.util.stream.Collectors.joining;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;

public final class IOUtils
{
	public static String readAsString(File file)
	{
		try
		{
			return Files.readAllLines(file.toPath() , Charset.forName("UTF-8")).stream().collect(joining());
		}
		catch (IOException e)
		{
			throw new IllegalArgumentException(e);
		}
	}
}
