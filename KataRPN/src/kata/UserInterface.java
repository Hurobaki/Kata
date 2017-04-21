package kata;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
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
				
				if(userRequest.toLowerCase().equals("quit"))
				{
					_scanner.close();
					_printStream.println("Bye !");
				}
				
			}
			while(userRequest.toLowerCase() != "quit");
		}
		
		
		
}
