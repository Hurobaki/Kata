package kata.expression;

public class ParenthesisExpression extends UnaryExpression {

	public ParenthesisExpression(Expression expression) {
		super(expression);
	}
	
	@Override
	public Double evaluate() {
		return _expression.evaluate();
	}
}
