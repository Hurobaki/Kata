package test;

import kata.ConstantExpression;
import kata.MulExpression;

import org.junit.*;

public class MulExpressionTest {

	private MulExpression _mulExp;
	private ConstantExpression _constantLeft;
	private ConstantExpression _constantRight;
	
	@Before
	public void setUp() throws Exception {
		_constantLeft = new ConstantExpression(4.0);
		_constantRight = new ConstantExpression(4.0);
		_mulExp = new MulExpression(_constantLeft, _constantRight);
	}

	@Test
	public void should_mul_expression_not_null()
	{
		Assert.assertNotNull(_mulExp);
	}

}
