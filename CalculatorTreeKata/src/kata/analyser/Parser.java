package kata.analyser;

import kata.expression.ConstantExpression;
import kata.expression.CosExpression;
import kata.expression.Expression;
import kata.expression.AddExpression;
import kata.expression.SinExpression;
import kata.expression.SubExpression;
import kata.expression.MulExpression;
import kata.expression.DivExpression;
import kata.expression.ParenthesisExpression;
import kata.expression.PosExpression;
import kata.expression.NegExpression;

import kata.analyser.Lexer.Token;
import kata.command.ClearCommand;
import kata.command.Command;
import kata.command.HelpCommand;
import kata.command.QuitCommand;

public class Parser {
	private Lexer _lexer;

	public Parser(String statement) {
		_lexer = new Lexer(statement);
	}

	public void parse() {
		statement();
	}

	public void statement() {
		if (_lexer.expect(Token.TK_START)) {
			emptyStatement();
			commandStatement();
			expressionStatement();
		}
	}

	public void emptyStatement() {
		if (_lexer.accept(Token.TK_END)) {
			System.out.println("Empty");
		}
	}

	public void commandStatement() {
		Command command = command();

		if (command != null) {
			command.execute();
		}
	}

	public void expressionStatement() throws IllegalArgumentException {
		Expression expression = expression();

		if (expression != null) {
			if (_lexer.expect(Token.TK_END)) {
				System.out.println(expression.evaluate());
			} else {
				throw new IllegalArgumentException();
			}
		}
	}

	public Command command() throws IllegalArgumentException {
		if (_lexer.accept(Token.TK_CLEAR)) {
			if (_lexer.expect(Token.TK_END)) {
				return new ClearCommand();
			}
			throw new IllegalArgumentException();
		} else if (_lexer.accept(Token.TK_HELP)) {
			if (_lexer.expect(Token.TK_END)) {
				return new HelpCommand();
			}
			throw new IllegalArgumentException();
		} else if (_lexer.accept(Token.TK_QUIT)) {
			if (_lexer.expect(Token.TK_END)) {
				return new QuitCommand();
			}
			throw new IllegalArgumentException();
		}

		return null;
	}

	public Expression expression() {
		
		Expression expression = addExpression();

		if (expression != null) {
			return expression;
		}
		return null;
	}

	public Expression addExpression() {

		Expression mulExpression = mulExpression();

		if (mulExpression != null) {

			if (_lexer.accept(Token.TK_PLUS)) {
				Expression addExpression = addExpression();

				if (addExpression != null) {
					return new AddExpression(addExpression, mulExpression);
				}
			} else if (_lexer.accept(Token.TK_MINUS)) {
				Expression addExpression = addExpression();

				if (addExpression != null) {
					return new SubExpression(addExpression, mulExpression);
				}
			}

			return mulExpression;
		}
		return null;
	}

	public Expression mulExpression() {
		Expression unaryExpression = unaryExpression();

		if (unaryExpression != null) {

			if (_lexer.accept(Token.TK_MULTIPLY)) {
				Expression mulExpression = mulExpression();

				if (mulExpression != null) {
					return new MulExpression(unaryExpression, mulExpression);
				}
			} else if (_lexer.accept(Token.TK_DIVIDE)) {
				Expression mulExpression = mulExpression();

				if (mulExpression != null) {
					return new DivExpression(unaryExpression, mulExpression);
				}
			}
			return unaryExpression;
		}
		return null;
	}

	public Expression unaryExpression() {
		Expression expression = primaryExpression();

		if (expression != null) {
			return expression;
		} else if (_lexer.accept(Token.TK_PLUS)) {
			expression = unaryExpression();

			if (expression != null) {
				return new PosExpression(expression);
			}
		} else if (_lexer.accept(Token.TK_MINUS)) {
			expression = unaryExpression();

			if (expression != null) {
				return new NegExpression(expression);
			}
		} else if (_lexer.accept(Token.TK_COS)) {
			expression = unaryExpression();

			if (expression != null) {
				return new CosExpression(expression);
			}
		} else if (_lexer.accept(Token.TK_SIN)) {
			expression = unaryExpression();

			if (expression != null) {
				return new SinExpression(expression);
			}
		}
		return null;
	}

	public Expression primaryExpression() {
		if (_lexer.accept(Token.TK_LEFT_PARENTHESIS)) {
			Expression expression = expression();

			if (expression != null) {
				_lexer.expect(Token.TK_RIGHT_PARENTHESIS);
				return new ParenthesisExpression(expression);
			}
		} else if (_lexer.accept(Token.TK_NUMBER)) {
			Expression expression = new ConstantExpression(
					Double.parseDouble(_lexer.getValue()));

			if (expression != null) {
				return expression;
			}
		}
		return null;
	}
}
