package kata.test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import kata.analyser.Parser;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ParserTest {

	private static Parser _parser;
	private static ByteArrayOutputStream _outContent;

	@Before
	public void setUpOutput() {
		_outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(_outContent));
	}

	@Test
	public void test_1_should_parser_exists() {
		Assert.assertNotNull(_parser);
	}

	@Test
	public void test_2_should_parser_return_4() {
		_parser = new Parser("2 + 2");
		_parser.parse();
		Assert.assertEquals("4.0\n", _outContent.toString());
	}

	@Test
	public void test_3_should_parser_return_16()

	{
		_parser = new Parser("4 * 4");
		_parser.parse();
		Assert.assertEquals("16.0\n", _outContent.toString());
	}

	@Test(expected = ArithmeticException.class)
	public void test_4_should_raise_exception_dividing_by_0() {
		_parser = new Parser("4/0");
		_parser.parse();
	}

	@Test
	public void test_5_should_return_empty() {
		_parser = new Parser("");
		_parser.parse();
		Assert.assertEquals("Empty\n", _outContent.toString());
	}

	@Test
	public void test_6_should_return_help_required() {
		_parser = new Parser("help");
		_parser.parse();
		Assert.assertEquals("Help required !\n", _outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_7_should_raise_illegal_argument_exception() {
		_parser = new Parser("help 1 + 3");
		_parser.parse();
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_8_should_raise_exception_bad_expression() {
		_parser = new Parser("2 +");
		_parser.parse();
	}

	@Test
	public void test_9_should_return_0_dot_5() {
		_parser = new Parser("1 / - -2");
		_parser.parse();
		Assert.assertEquals("0.5\n", _outContent.toString());
	}

	@Test
	public void test_10_should_return_1_for_cos_0() {
		_parser = new Parser("cos(0)");
		_parser.parse();
		Assert.assertEquals("1.0\n", _outContent.toString());
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_11_should_raison_illegal_argument_exception() {
		_parser = new Parser("1+3 help");
		_parser.parse();
	}

}
