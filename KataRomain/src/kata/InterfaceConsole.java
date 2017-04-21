package kata;

import java.util.Scanner;

public class InterfaceConsole {
	
	private RomanNumeralConverter _romanNumeralConverter;
	
	public InterfaceConsole()
	{
		_romanNumeralConverter = new RomanNumeralConverter();
		allowUserToType();
	}
	
	private void allowUserToType()
	{
		Scanner sc = new Scanner(System.in);
		char exit = '0';
		do
		{
			System.out.println("Enter your number ('Q' to leave)");
			String userRequest = sc.nextLine();
			if(userRequest.toLowerCase().charAt(0) == 'q')
			{
				exit = 'q';
				sc.close();
				System.out.println("Bye !");
			}
			else if(userRequest.matches("[0-9]+"))
			{
				try
				{
					System.out.println(userRequest + " => " + _romanNumeralConverter.convertNumericToRoman(Integer.valueOf(userRequest)));
				}
				catch(IllegalArgumentException e)
				{
					System.out.println("Wrong number length / Number must be higher than 0");
				}
				
			}
			else if(userRequest.matches("^M*(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$"))
			{
				
				System.out.println(userRequest + " => " + _romanNumeralConverter.convertRomanToNumeric(userRequest));
			}
			else
			{
				System.out.println("Wrong Format");
			}
		}
		while(exit != 'q');
	}
}
