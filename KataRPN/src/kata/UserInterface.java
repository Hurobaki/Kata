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
	private boolean _running = true;

		public UserInterface(InputStream input, PrintStream output)
		{
			_rpnCalculator = new RPNCalculator();
			_inputStream = input;
			_printStream = output;
		}
		
		public void run()
		{
			_scanner = new Scanner(_inputStream);
			
			do
			{
				_printStream.println("RPN Calculator >");
				String userRequest = _scanner.nextLine();
				
				try
				{
					parse(userRequest);
				}
				catch(IllegalArgumentException | EmptyStackException e)
				{
					_printStream.println("*** Syntax error ***");
				}
				
			}
			while(_running);
		}
		

		public void parse(String userRequest)
		{
			int userInputLength = userRequest.length();
			char currentChar = ' ';
			
			for(int currentCaracter = 0; currentCaracter < userInputLength; currentCaracter++)
			{
				String token = "";
				currentChar = userRequest.charAt(currentCaracter);

				if(currentChar != 0) {
					while(currentChar == ' ' && currentChar == '\n') {
						currentCaracter++;
						if(currentCaracter < userInputLength) {
							currentChar = userRequest.charAt(currentCaracter);
						}
						else {
							currentChar = 0;
							break;
						}
					}					
				}

				if(currentChar != 0) {
					while(currentChar != ' ' && currentChar != '\n') {
						token += currentChar;
						currentCaracter++;
						if(currentCaracter < userInputLength) {
							currentChar = userRequest.charAt(currentCaracter);
						}
						else {
							currentChar = 0;
							break;
						}
					}
				}

				if(token.isEmpty() == false) {
					eval(token);
				}

				if(_running == false) {
					break;
				}
			}
			if(_rpnCalculator.empty() == false) {
				_printStream.println(String.valueOf(_rpnCalculator.pop()));						
			}
		}

		private void eval(String token) {
			switch (token) {
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
				case "clear":
					_rpnCalculator.clear();
					break;
				case "help":
					help();
					break;
				case "quit":
					quit();
					break;
				default:
					_rpnCalculator.push(Double.parseDouble(token));
					break;
				}
		}

		private void quit() {
			_printStream.println("Bye !");
			_running = false;
			_scanner.close();
		}

		private void help() {
			_printStream.println("Help !");
		}	
}
