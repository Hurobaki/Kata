package kata.test;

import kata.expression.AddExpression;
import kata.expression.ConstantExpression;
import kata.expression.MulExpression;
import kata.expression.ParenthesisExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExpressionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_return_6() {
		//(23+3) * (5+25)
		ConstantExpression constant_10 = new ConstantExpression(25.0);
		ConstantExpression constant_5 = new ConstantExpression(5.0);
		ConstantExpression constant_3 = new ConstantExpression(3.0);
		ConstantExpression constant_23 = new ConstantExpression(23.0);
		
		AddExpression leftExpression = new AddExpression(constant_23, constant_3);
		AddExpression rightExpression = new AddExpression(constant_5, constant_10);
		
		ParenthesisExpression leftParenthesis = new ParenthesisExpression(leftExpression);
		ParenthesisExpression rightParenthesis = new ParenthesisExpression(rightExpression);
		
		MulExpression mulExpression = new MulExpression(leftParenthesis, rightParenthesis);
		
		Assert.assertEquals((Double)780.0, mulExpression.evaluate());
	}

}
