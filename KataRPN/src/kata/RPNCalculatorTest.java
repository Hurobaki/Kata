package kata;

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
}
