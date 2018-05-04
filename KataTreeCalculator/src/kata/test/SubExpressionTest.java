package kata.test;

import kata.expression.ConstantExpression;
import kata.expression.SubExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SubExpressionTest {
	ConstantExpression _constantLeftExpression;
	ConstantExpression _constantRightExpression;
	SubExpression _subExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_constantLeftExpression = new ConstantExpression(0.0);
		_constantRightExpression = new ConstantExpression(0.0);
		_subExpression = new SubExpression(_constantLeftExpression, _constantRightExpression);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_subExpression);
	}
}
