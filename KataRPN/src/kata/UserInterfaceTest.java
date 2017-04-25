package kata;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.*;

public class UserInterfaceTest {

	private UserInterface _userInterface;
	private RPNCalculator _rpnCalculator;
	private ByteArrayOutputStream _outContent;
	
	@Before
	public void setUp()
	{
		_rpnCalculator = new RPNCalculator();
		_outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(_outContent));
		_userInterface = new UserInterface(System.in, System.out);
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
	public void should_return_4()
	{
		_userInterface.parse("20 5 /");
		Assert.assertEquals("4.0\n", _outContent.toString());
	}
	
	@Test
	public void should_return_3()
	{
		_userInterface.parse("4 2 + 3 -");
		Assert.assertEquals("3.0\n", _outContent.toString());
	}
	
	@Test
	public void should_return_141()
	{
		_userInterface.parse("3 5 8 * 7 + *");
		Assert.assertEquals("141.0\n", _outContent.toString());
	}
	
	@Test
	public void should_return_3_for_divide()
	{
		_userInterface.parse("12 3 - 3 /");
		Assert.assertEquals("3.0\n", _outContent.toString());
	}
	
	@Test
	public void should_return_negative_18()
	{
		_userInterface.parse("-2 3 11 + 5 - *");
		Assert.assertEquals("-18.0\n", _outContent.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_expection_for_syntax_error()
	{
		_userInterface.parse("aaa");
	}


}
