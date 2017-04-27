package test;

import kata.ConstantExpression;
import kata.SubExpression;

import org.junit.*;

public class SubExpressionTest {

	private SubExpression _subExp;
	private ConstantExpression _constantLeft;
	private ConstantExpression _constantRight;
	
	@Before
	public void setUp() throws Exception {
		_constantLeft = new ConstantExpression(4.0);
		_constantRight = new ConstantExpression(4.0);
		_subExp = new SubExpression(_constantLeft, _constantRight);
	}
	
	@Test
	public void should_sub_expression_not_null()
	{
		Assert.assertNotNull(_subExp);
	}
}
