package kata;

import java.util.EmptyStackException;

import org.junit.*;

public class RPNCalculatorTest {

	private RPNCalculator _rpnCalculator;
	
	@Before
	public void setUp()
	{
		_rpnCalculator = new RPNCalculator();
	}
	
	@Test
	public void should_rpn_calculator_not_null()
	{
		Assert.assertNotNull(_rpnCalculator);
	}
	
	@Test
	public void should_rpn_calculator_return_4_for_add_2_and_2()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(2.0);
		_rpnCalculator.add();
		
		Assert.assertEquals(Double.valueOf(4), _rpnCalculator.pop());
	}
	
	@Test
	public void should_rpn_calculator_return_4_for_multiply_2_by_2()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(2.0);
		_rpnCalculator.multiply();
		
		Assert.assertEquals(Double.valueOf(4), _rpnCalculator.pop());
	}
	
	@Test
	public void should_rpn_calculator_return_0_for_substract_2_and_2()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(2.0);
		_rpnCalculator.substract();
		
		Assert.assertEquals(Double.valueOf(0), _rpnCalculator.pop());
	}
	
	@Test
	public void should_rpn_calculator_return_1_for_divide_2_by_2()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(2.0);
		_rpnCalculator.divide();
		
		Assert.assertEquals(Double.valueOf(1), _rpnCalculator.pop());
	}
	
	@Test
	public void should_rpn_calculator_return_0_for_multiply_2_by_0()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(0.0);
		_rpnCalculator.multiply();
		
		Assert.assertEquals(Double.valueOf(0), _rpnCalculator.pop());
	}
	
	
	@Test(expected = IllegalArgumentException.class)
	public void should_rpn_calculator_raise_exception_when_trying_to_divide_by_0()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.push(0.0);
		_rpnCalculator.divide();
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void should_raise_exception_when_doing_operation_on_empty_stack()
	{
		_rpnCalculator.add();
	}
	
	@Test
	public void should_stack_empty_after_cleared()
	{
		_rpnCalculator.push(2.0);
		_rpnCalculator.clear();
		Assert.assertTrue(_rpnCalculator.getStack().isEmpty());
	}
	
	@Test(expected = EmptyStackException.class)
	public void should_rpn_calculator_raise_exception_when_trying_to_pop_on_empty_stack()
	{
		_rpnCalculator.pop();
	}
}
