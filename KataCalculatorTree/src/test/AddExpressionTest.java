package test;

import kata.AddExpression;
import kata.ConstantExpression;

import org.junit.*;

public class AddExpressionTest {

	private AddExpression _addExp;
	private ConstantExpression _constantLeft;
	private ConstantExpression _constantRight;
	
	@Before
	public void setUp() throws Exception {
		_constantLeft = new ConstantExpression(4.0);
		_constantRight = new ConstantExpression(4.0);
		_addExp = new AddExpression(_constantLeft, _constantRight);
	}

	@Test
	public void should_add_expression_not_null()
	{
		Assert.assertNotNull(_addExp);
	}

}
