package kata.expression;

public class SinExpression extends UnaryExpression {

	public SinExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return Math.sin(_expression.evaluate());
	}
}
