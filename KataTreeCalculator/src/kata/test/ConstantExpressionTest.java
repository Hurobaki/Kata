package kata.test;

import kata.expression.ConstantExpression;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConstantExpressionTest {
	ConstantExpression _constantExpression;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_constantExpression = new ConstantExpression(0.0);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_not_be_null() {
		Assert.assertNotNull(_constantExpression);
	}

}
