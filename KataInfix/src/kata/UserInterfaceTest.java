package kata;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserInterfaceTest {
	private ByteArrayOutputStream _outContent;
	private UserInterface _userInterface;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(_outContent));
		_userInterface = new UserInterface(System.in, System.out);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_user_interface_not_be_null() {
		Assert.assertNotNull(_userInterface);
	}
	
	@Test
	public void should_user_interface_input_left_12_sub_3_right_div_3_return_3() {
		_userInterface.parse("(12 - 3) / 3");
		Assert.assertEquals("3.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_500_div_5_return_4() {
		_userInterface.parse("500 / 5");
		Assert.assertEquals("100.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_2_mul_left_4_mul_2_right_mul_3_return_4() {
		_userInterface.parse("2 * (4 + 2) * 3");
		Assert.assertEquals("36.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_left_input_5_mul_8_add_7_right_mul_3_return_141() {
		_userInterface.parse("(5 * 8 + 7) * 3");
		Assert.assertEquals("141.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_help_5_mul_1_add_neg1_add_left_3_add_11_sub_5_right_mul_neg2_return_help_14() {
		_userInterface.parse(" help 5 * 1 + -1 + (3 + 11 - 5) * -2");
		Assert.assertEquals("Help !\n-14.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_help_2_add_2_return_help_4() {
		_userInterface.parse("help 2 + 2");
		Assert.assertEquals("Help !\n4.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_2_add_neg2_return_help_0() {
		_userInterface.parse("2+-2");
		Assert.assertEquals("0.0\n", _outContent.toString());
	}
	
	@Test
	public void should_user_interface_input_2_add_2_return_help_0() {
		_userInterface.parse("2+2");
		Assert.assertEquals("4.0\n", _outContent.toString());
	}
	
	@Test(expected=EmptyStackException.class)
	public void should_user_interface_throw_illegal_argument_2_exception() {
		_userInterface.parse("2 + 2 + 2 +");
	}
}
