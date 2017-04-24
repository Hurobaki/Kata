package kata;


import org.junit.*;

public class InfixCalculatorTest {

	private InfixCalculator _infixCalculator;
	
	@Before
	public void setUp()
	{
		_infixCalculator = new InfixCalculator();
	}
	
	@Test
	public void should_infix_calculator_not_null()
	{
		Assert.assertNotNull(_infixCalculator);
	}
	
	@Test
	public void should_return_3_for_token_parenthesis()
	{
		Assert.assertEquals(1, _infixCalculator.priority(")"));
	}
	
	@Test
	public void should_return_2_for_token_multiply()
	{
		Assert.assertEquals(3, _infixCalculator.priority("*"));
	}
	
	@Test
	public void should_return_1_for_token_add()
	{
		Assert.assertEquals(2, _infixCalculator.priority("+"));
	}
	
	@Test
	public void should_20_div_4_return_5()
	{
		_infixCalculator.leftParenthesis();
		_infixCalculator.operand(20.0);
		_infixCalculator.operator("/");
		_infixCalculator.operand(4.0);
		_infixCalculator.rigthParenthesis();
		
		Assert.assertEquals(Double.valueOf(5), _infixCalculator.pop());
	}
	
	@Test
	public void should_4_add_4_return_8()
	{
		_infixCalculator.leftParenthesis();
		_infixCalculator.operand(4.0);
		_infixCalculator.operator("+");
		_infixCalculator.operand(4.0);
		_infixCalculator.rigthParenthesis();
		
		Assert.assertEquals(Double.valueOf(8), _infixCalculator.pop());
	}
	
	@Test
	public void should_10_sub_4_return_6()
	{
		_infixCalculator.leftParenthesis();
		_infixCalculator.operand(10.0);
		_infixCalculator.operator("-");
		_infixCalculator.operand(4.0);
		_infixCalculator.rigthParenthesis();
		
		Assert.assertEquals(Double.valueOf(6), _infixCalculator.pop());
	}
	
	@Test
	public void should_10_multiply_4_return_40()
	{
		_infixCalculator.leftParenthesis();
		_infixCalculator.operand(10.0);
		_infixCalculator.operator("*");
		_infixCalculator.operand(4.0);
		_infixCalculator.rigthParenthesis();
		
		Assert.assertEquals(Double.valueOf(40), _infixCalculator.pop());
	}
		
}
