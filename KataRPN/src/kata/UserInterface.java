package kata;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Scanner;

public class UserInterface {
	
	private RPNCalculator _rpnCalculator;
	private Scanner _scanner;
	private InputStream _inputStream;
	private PrintStream _printStream;

		public UserInterface(InputStream input, PrintStream output)
		{
			_rpnCalculator = new RPNCalculator();
			_inputStream = input;
			_printStream = output;
		}
		
		public void run()
		{
			_scanner = new Scanner(_inputStream);
			String userRequest = "";
		
			do
			{
				_printStream.println("RPN Calculator >");
				userRequest = _scanner.nextLine();
				
				switch (userRequest.toLowerCase()) {
					case "quit":
						_printStream.println(printMessage(userRequest));
						userRequest = "quit";
						_scanner.close();
						break;
					case "help":
						_printStream.println(printMessage(userRequest));
						break;
					case "clear":
						_printStream.println(printMessage(userRequest));
						break;
					default:
						try
						{
							_printStream.println(userInput(userRequest));
						}catch(IllegalArgumentException | EmptyStackException e)
						{
							_printStream.println("Wrong String Format");
						}
						
						break;
					}
				
			}
			while(userRequest.toLowerCase() != "quit");
		}
		
		public String printMessage(String message)
		{
			if(message.toLowerCase().equals("help"))
			{
				return "You asked for online documentation";
			}
			
			if(message.toLowerCase().equals("quit"))
			{
				return "Bye !";
			}
			
			if(message.toLowerCase().equals("clear"))
			{
				_rpnCalculator.clear();
				return "Cleared !";
			}
			
			return "";
		}
		
		public String userInput(String userRequest)
		{
			String input = "";
			int userInput = userRequest.length();
			
			for(int currentCaracter = 0; currentCaracter < userInput; currentCaracter++)
			{
				char currentChar = userRequest.charAt(currentCaracter);
				
				if(currentChar != '\n' && currentChar != ' ')
				{
					input += currentChar;
				}
				
				if(currentChar == ' ' || currentCaracter == userInput - 1)
				{
					switch (input) {
						case "+":
							_rpnCalculator.add();
							break;
						case "-":
							_rpnCalculator.substract();
							break;
						case "/":
							_rpnCalculator.divide();
							break;
						case "*":
							_rpnCalculator.multiply();
							break;
						default:
							_rpnCalculator.push(Double.parseDouble(input));
							break;
						}
					input = "";
				}
				
			}
					
			return String.valueOf(_rpnCalculator.pop());
		}	
}
