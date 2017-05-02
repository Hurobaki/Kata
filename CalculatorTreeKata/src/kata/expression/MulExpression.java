package kata.expression;
public class MulExpression extends BinaryExpression {

	public MulExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() {
		return _leftExpression.evaluate() * _rightExpression.evaluate();
	}
}
