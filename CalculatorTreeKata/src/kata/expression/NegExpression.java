package kata.expression;

public class NegExpression extends UnaryExpression {

	public NegExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return -_expression.evaluate();
	}
}
