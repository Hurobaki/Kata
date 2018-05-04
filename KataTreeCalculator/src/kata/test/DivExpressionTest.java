package kata.test;

import kata.expression.ConstantExpression;
import kata.expression.DivExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DivExpressionTest {
	ConstantExpression _constantLeftExpression;
	ConstantExpression _constantRightExpression;
	DivExpression _divExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_constantLeftExpression = new ConstantExpression(6.0);
		_constantRightExpression = new ConstantExpression(2.0);
		_divExpression = new DivExpression(_constantLeftExpression, _constantRightExpression);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_divExpression);
	}
	
	@Test
	public void should_evaluate_return_6() {
		Assert.assertEquals((Double)3.0, _divExpression.evaluate());
	}
	
	@Test(expected=ArithmeticException.class)
	public void should_evaluate_throw_arithmetic_exception() {
		DivExpression divExpression = new DivExpression(_constantLeftExpression, new ConstantExpression(0.0));
		divExpression.evaluate();
	}
}
