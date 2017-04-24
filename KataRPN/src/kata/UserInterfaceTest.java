package kata;


import java.util.EmptyStackException;

import org.junit.*;

public class UserInterfaceTest {

	private UserInterface _userInterface;
	private RPNCalculator _rpnCalculator;
	
	@Before
	public void setUp()
	{
		_userInterface = new UserInterface(System.in, System.out);
		_rpnCalculator = new RPNCalculator();
	}
	
	@Test
	public void should_user_interface_not_null()
	{
		Assert.assertNotNull(_userInterface);
	}
	
	@Test
	public void should_rpn_calculator_not_null()
	{
		Assert.assertNotNull(_rpnCalculator);
	}
	
	@Test
	public void should_user_interface_read_quit()
	{
		Assert.assertNotNull(_userInterface);
	}
	
	@Test
	public void should_display_help_documentation_when_typing_help()
	{
		Assert.assertEquals("You asked for online documentation", _userInterface.printMessage("help"));
	}
	
	@Test
	public void should_display_quit_message_when_typing_quit()
	{
		Assert.assertEquals("Bye !", _userInterface.printMessage("quit"));
	}
	
	@Test
	public void should_return_4()
	{
		Assert.assertEquals(String.valueOf(Double.valueOf(4)), _userInterface.userInput("20 5 /"));
	}
	
	@Test
	public void should_return_3()
	{
		Assert.assertEquals(String.valueOf(Double.valueOf(3)), _userInterface.userInput("4 2 + 3 -"));
	}
	
	@Test
	public void should_return_141()
	{
		Assert.assertEquals(String.valueOf(Double.valueOf(141)), _userInterface.userInput("3 5 8 * 7 + *"));
	}

	@Test
	public void should_return_3_with_divide()
	{
		Assert.assertEquals(String.valueOf(Double.valueOf(3)), _userInterface.userInput("12 3 - 3 /"));
	}
	
	@Test
	public void should_return_negativ_18()
	{
		Assert.assertEquals(String.valueOf(Double.valueOf(-18)), _userInterface.userInput("-2 3 11 + 5 - *"));
	}
	
	@Test(expected = EmptyStackException.class)
	public void should_raise_exception_for_empty_user_input()
	{
		_userInterface.userInput("");
	}

}
