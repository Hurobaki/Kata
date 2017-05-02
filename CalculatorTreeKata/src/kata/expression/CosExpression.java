package kata.expression;

public class CosExpression extends UnaryExpression {

	public CosExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return Math.cos(_expression.evaluate());
	}
}
