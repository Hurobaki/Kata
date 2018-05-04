package kata.test;

import kata.expression.ConstantExpression;
import kata.expression.ParenthesisExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParenthesisExpressionTest {
	ConstantExpression _constantExpression;
	ParenthesisExpression _parenthesisExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_constantExpression = new ConstantExpression(6.0);
		_parenthesisExpression = new ParenthesisExpression(_constantExpression);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_parenthesisExpression);
	}
	
	@Test
	public void should_return_6() {
		Assert.assertEquals((Double)6.0, _parenthesisExpression.evaluate());
	}
}
