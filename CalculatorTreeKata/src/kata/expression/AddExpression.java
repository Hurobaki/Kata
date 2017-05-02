package kata.expression;

public class AddExpression extends BinaryExpression {

	public AddExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() {
		return _leftExpression.evaluate() + _rightExpression.evaluate();
	}
}
