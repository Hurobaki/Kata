package kata.expression;

public class SubExpression extends BinaryExpression {

	public SubExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() {
		return _rightExpression.evaluate() - _leftExpression.evaluate();
	}
}
