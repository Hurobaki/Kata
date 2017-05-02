package kata.test;

import kata.expression.AddExpression;
import kata.expression.ConstantExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AddExpressionTest {
	ConstantExpression _constantLeftExpression;
	ConstantExpression _constantRightExpression;
	AddExpression _addExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_constantLeftExpression = new ConstantExpression(4.0);
		_constantRightExpression = new ConstantExpression(2.0);
		_addExpression = new AddExpression(_constantLeftExpression, _constantRightExpression);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_addExpression);
	}
	
	@Test
	public void should_evaluate_return_6() {
		Assert.assertEquals((Double)6.0, _addExpression.evaluate());
	}
}
