package kata.test;

import kata.analyser.Lexer;
import kata.analyser.Lexer.Token;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LexerTest {
	
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
	public void b_should_parse_expression_1() {
		Lexer lexer = new Lexer("clear +5 + 5 + (-5)");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_CLEAR);
		Assert.assertEquals("clear", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("+5", lexer.getValue());
		
		lexer.accept(Token.TK_PLUS);
		Assert.assertEquals("+", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("5", lexer.getValue());
		
		lexer.accept(Token.TK_PLUS);
		Assert.assertEquals("+", lexer.getValue());
		
		lexer.accept(Token.TK_LEFT_PARENTHESIS);
		Assert.assertEquals("(", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("-5", lexer.getValue());
		
		lexer.accept(Token.TK_RIGHT_PARENTHESIS);
		Assert.assertEquals(")", lexer.getValue());
		
		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
	
	@Test
	public void b_should_parse_expression_2() {
		Lexer lexer = new Lexer("");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
	
	@Test
	public void b_should_parse_expression_3() {
		Lexer lexer = new Lexer("-5");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("-5", lexer.getValue());

		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
	
	@Test
	public void b_should_parse_expression_4() {
		Lexer lexer = new Lexer("1 / - -2");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("1", lexer.getValue());
		
		lexer.accept(Token.TK_DIVIDE);
		Assert.assertEquals("/", lexer.getValue());
		
		lexer.accept(Token.TK_MINUS);
		Assert.assertEquals("-", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("-2", lexer.getValue());
		
		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
	
	@Test
	public void b_should_parse_expression_5() {
		Lexer lexer = new Lexer("clear");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_CLEAR);
		Assert.assertEquals("clear", lexer.getValue());
		
		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
	
	@Test
	public void b_should_parse_expression_6() {
		Lexer lexer = new Lexer("1 - - + -2");
		
		lexer.accept(Token.TK_START);
		Assert.assertEquals("START", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("1", lexer.getValue());
		
		lexer.accept(Token.TK_MINUS);
		Assert.assertEquals("-", lexer.getValue());
		
		lexer.accept(Token.TK_MINUS);
		Assert.assertEquals("-", lexer.getValue());
		
		lexer.accept(Token.TK_PLUS);
		Assert.assertEquals("+", lexer.getValue());
		
		lexer.accept(Token.TK_NUMBER);
		Assert.assertEquals("-2", lexer.getValue());
		
		lexer.accept(Token.TK_END);
		Assert.assertEquals("END", lexer.getValue());
	}
}
