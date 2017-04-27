package test;

import kata.ConstantExpression;
import kata.ParenthesisExpression;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ParenthesisExpressionTest {
	
	private ParenthesisExpression _parenthesisExp;
	private ConstantExpression _constantExpression;

	@Before
	public void setUp() throws Exception {
		_constantExpression = new ConstantExpression(4.0);
		_parenthesisExp = new ParenthesisExpression(_constantExpression);
	}

	@Test
	public void test() {
		Assert.assertNotNull(_parenthesisExp);
	}

}
