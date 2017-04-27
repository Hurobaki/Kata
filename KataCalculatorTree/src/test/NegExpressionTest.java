package test;

import kata.ConstantExpression;
import kata.NegExpression;

import org.junit.*;

public class NegExpressionTest {
	
	private NegExpression _negExp;
	private ConstantExpression _constantExpression;

	@Before
	public void setUp() throws Exception {
		_constantExpression = new ConstantExpression(4.0);
		_negExp = new NegExpression(_constantExpression);
	}

	@Test
	public void should_neg_expression_not_null()
	{
		Assert.assertNotNull(_negExp);
	}

}
