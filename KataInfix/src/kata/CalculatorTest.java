package kata;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
	private Calculator _calculator;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		_calculator = new Calculator();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void should_calcultor_not_be_null() {
		Assert.assertNotNull(_calculator);
	}
	
	@Test
	public void should_20_div_5_return_4() {
		_calculator.leftParenthesis();
		_calculator.operand(20.0);
		_calculator.operator("/");
		_calculator.operand(5.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)4.0, _calculator.pop());
	}
	
	@Test
	public void should_left_4_add_2_right_sub_3_return_141() {
		_calculator.leftParenthesis();
		_calculator.leftParenthesis();
		_calculator.operand(4.0);
		_calculator.operator("+");
		_calculator.operand(2.0);
		_calculator.rigthParenthesis();
		_calculator.operator("-");
		_calculator.operand(3.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)3.0, _calculator.pop());
	}
	
	@Test
	public void should_2_mul_left_4_add_2_right_mul_3_return_36() {
		_calculator.leftParenthesis();
		_calculator.operand(2.0);
		_calculator.operator("*");
		_calculator.leftParenthesis();
		_calculator.operand(4.0);
		_calculator.operator("+");
		_calculator.operand(2.0);
		_calculator.rigthParenthesis();
		_calculator.operator("*");
		_calculator.operand(3.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)36.0, _calculator.pop());
	}
	
	@Test
	public void should_left_left_5_mul_8_right_add_7_right_mul_3_return_141() {
		_calculator.leftParenthesis();
		_calculator.leftParenthesis();
		_calculator.leftParenthesis();
		_calculator.operand(5.0);
		_calculator.operator("*");
		_calculator.operand(8.0);
		_calculator.rigthParenthesis();
		_calculator.operator("+");
		_calculator.operand(7.0);
		_calculator.rigthParenthesis();
		_calculator.operator("*");
		_calculator.operand(3.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)141.0, _calculator.pop());
	}
	
	@Test
	public void should_left_12_sub_3_right_div_3_return_3() {
		_calculator.leftParenthesis();
		_calculator.leftParenthesis();
		_calculator.operand(4.0);
		_calculator.operator("+");
		_calculator.operand(2.0);
		_calculator.rigthParenthesis();
		_calculator.operator("-");
		_calculator.operand(3.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)3.0, _calculator.pop());
	}
	
	@Test
	public void should_left_left_3_add_11_sub_5_right_mul_neg_2_return_neg_18() {
		_calculator.leftParenthesis();
		_calculator.leftParenthesis();
		_calculator.operand(3.0);
		_calculator.operator("+");
		_calculator.operand(11.0);
		_calculator.operator("-");
		_calculator.operand(5.0);
		_calculator.rigthParenthesis();
		_calculator.operator("*");
		_calculator.operand(-2.0);
		_calculator.rigthParenthesis();
		
		Assert.assertEquals((Double)(-18.0), _calculator.pop());
	}
}
