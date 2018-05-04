package kata.userInterface;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import kata.analyser.Parser;

public class UserInterface {
	
	private Scanner _scanner;
	private Parser _parser;
	private boolean _running;
	private InputStream _inputStream;
	private PrintStream _printStream;

	public UserInterface(InputStream input, PrintStream output) {
		// TODO Auto-generated constructor stub
		_running = true;
		_inputStream = input;
		_printStream = output;
	}
	
	public void run()
	{
		_scanner = new Scanner(_inputStream);
		
		do
		{
			_printStream.println("Calulator >");
			String userRequest = _scanner.nextLine();
			try
			{
				parse(userRequest.trim());
			}
			catch(IllegalArgumentException | ArithmeticException e){
				_printStream.println("*** Syntax Error ***");
			}
		}
		while(_running);
		
	}
	
	public void parse(String request)
	{
		_parser = new Parser(request);
		_parser.parse();
	}

}
