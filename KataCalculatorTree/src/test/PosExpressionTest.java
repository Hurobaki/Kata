package test;

import kata.ConstantExpression;
import kata.PosExpression;

import org.junit.*;

public class PosExpressionTest {
	
	private PosExpression _posExp;
	private ConstantExpression _constantExpression;

	@Before
	public void setUp() throws Exception {
		_constantExpression = new ConstantExpression(4.0);
		_posExp = new PosExpression(_constantExpression);
	}

	@Test
	public void should_pos_expression_not_null()
	{
		Assert.assertNotNull(_posExp);
	}

}
