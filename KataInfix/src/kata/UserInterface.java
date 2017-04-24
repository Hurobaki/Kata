package kata;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class UserInterface {
	
	private Scanner _scanner;
	private InputStream _inputStream;
	private PrintStream _printStream;
	private InfixCalculator _infixCalculator;
	
	public UserInterface(InputStream input, PrintStream output)
	{
		_infixCalculator = new InfixCalculator();
		_inputStream = input;
		_printStream = output;
	}
	
	public void run()
	{
		_scanner = new Scanner(_inputStream);
		String userRequest = "";
		
		do
		{
			_printStream.println("Calculator >");
			userRequest = _scanner.nextLine();
			
			switch (userRequest.toLowerCase()) {
			case "quit":		
			case "exit":
				userRequest = "quit";
				_scanner.close();
				break;
			case "help":
			case "?":
				_printStream.println("You asked for online documentation");
				break;
			default:
				break;
			}
		}
		while(userRequest.toLowerCase() != "quit");
	}
	
	
}
