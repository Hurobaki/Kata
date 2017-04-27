package test;


import kata.ConstantExpression;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConstantExpressionTest {

	private ConstantExpression _constantExp;
	
	@Before
	public void setUp() throws Exception {
		_constantExp = new ConstantExpression(4.0);
	}

	@Test
	public void test() {
		Assert.assertNotNull(_constantExp);
	}

}
