package kata;

public abstract class BinaryExpression extends Expression {

	private Expression _leftExpression;
	private Expression _rightExpression;
	
	
	public BinaryExpression(Expression leftExpression, Expression rightExpression) {
		// TODO Auto-generated constructor stub
		super();
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
