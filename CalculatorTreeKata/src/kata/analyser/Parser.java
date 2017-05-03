package kata.analyser;

import kata.analyser.Lexer.Token;
import kata.command.ClearCommand;
import kata.command.Command;
import kata.command.HelpCommand;
import kata.command.QuitCommand;
import kata.expression.AddExpression;
import kata.expression.ConstantExpression;
import kata.expression.CosExpression;
import kata.expression.DivExpression;
import kata.expression.Expression;
import kata.expression.MulExpression;
import kata.expression.NegExpression;
import kata.expression.ParenthesisExpression;
import kata.expression.PosExpression;
import kata.expression.PowExpression;
import kata.expression.SinExpression;
import kata.expression.SubExpression;
import kata.visitor.ASTEvaluator;
import kata.visitor.RPNGenerator;

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
			// if (_lexer.expect(Token.TK_END)) {
			/*
			 * System.out.println(expression.evaluate());
			 * System.out.println(expression.toRPN());
			 */
			/*
			 * } else { throw new IllegalArgumentException(); }
			 */

			RPNGenerator visitor = new RPNGenerator();
			expression.accept(visitor);
			System.out.println("RPN >" + " " + visitor.getString());

			ASTEvaluator evaluator = new ASTEvaluator();
			expression.accept(evaluator);
			System.out.println("Result >" + " " + evaluator.getResult());
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

		Expression expression = addsubExpression();

		if (expression != null) {
			return expression;
		}
		return null;
	}

	public Expression addsubExpression() {
		Expression expression = muldivExpression();

		if (expression != null) {
			return addsubExpression(expression);
		}

		return null;
	}

	public Expression addsubExpression(Expression lhs) {

		if (_lexer.accept(Token.TK_PLUS)) {
			Expression rhs = muldivExpression();

			if (rhs == null) {
				throw new IllegalArgumentException();
			}
			return addsubExpression(new AddExpression(lhs, rhs));

		}

		if (_lexer.accept(Token.TK_MINUS)) {
			Expression rhs = muldivExpression();

			if (rhs == null) {
				throw new IllegalArgumentException();
			}
			return addsubExpression(new SubExpression(lhs, rhs));
		}

		return lhs;

	}

	public Expression muldivExpression() {
		Expression expression = binaryExpression();

		if (expression != null) {
			return muldivExpression(expression);
		}

		return null;
	}

	public Expression muldivExpression(Expression lhs) {

		if (_lexer.accept(Token.TK_MULTIPLY)) {
			Expression rhs = binaryExpression();

			if (rhs == null) {
				throw new IllegalArgumentException();
			}
			return muldivExpression(new MulExpression(lhs, rhs));
		}

		if (_lexer.accept(Token.TK_DIVIDE)) {
			Expression rhs = binaryExpression();

			if (rhs == null) {
				throw new IllegalArgumentException();
			}
			return muldivExpression(new DivExpression(lhs, rhs));
		}

		return lhs;
	}

	public Expression binaryExpression() {
		Expression expression = unaryExpression();

		if (expression != null) {
			return binaryExpression(expression);
		}

		return null;
	}

	public Expression binaryExpression(Expression lhs) {

		if (_lexer.accept(Token.TK_POW)) {
			Expression rhs = unaryExpression();

			if (rhs == null) {
				throw new IllegalArgumentException();
			}
			return binaryExpression(new PowExpression(lhs, rhs));
		}

		return lhs;
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
