package kata.expression;

public class PosExpression extends UnaryExpression {

	public PosExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return +_expression.evaluate();
	}
}
