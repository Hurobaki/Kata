package kata.test;

import kata.expression.ConstantExpression;
import kata.expression.MulExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MulExpressionTest {
	ConstantExpression _constantLeftExpression;
	ConstantExpression _constantRightExpression;
	MulExpression _mulExpression;

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
		_mulExpression = new MulExpression(_constantLeftExpression, _constantRightExpression);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_mulExpression);
	}
	
	@Test
	public void should_evaluate_return_12() {
		Assert.assertEquals((Double)12.0, _mulExpression.evaluate());
	}
}
