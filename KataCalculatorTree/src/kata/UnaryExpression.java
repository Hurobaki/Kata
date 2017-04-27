package kata;

public abstract class UnaryExpression extends Expression {

	private Expression _expression;
	
	public UnaryExpression(Expression expression) {
		// TODO Auto-generated constructor stub
		super();
		_expression = expression;
	}

	public Expression getExpression() {
		return _expression;
	}
}
