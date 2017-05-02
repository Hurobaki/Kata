package kata.expression;

public abstract class BinaryExpression extends Expression {
	protected Expression _leftExpression;
	protected Expression _rightExpression;

	public BinaryExpression(Expression leftExpression,
			Expression rightExpression) {
		_leftExpression = leftExpression;
		_rightExpression = rightExpression;
	}

	public Expression getLeftExpression() {
		return _leftExpression;
	}

	public Expression getRightExpression() {
		return _rightExpression;
	}

}
