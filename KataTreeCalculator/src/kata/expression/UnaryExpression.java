package kata.expression;

public abstract class UnaryExpression extends Expression {
	protected Expression _expression;
	
	public UnaryExpression(Expression expression) {
		super();
		_expression = expression;
	}
	
	public Expression getExpression() {
		return _expression;
	}
}
