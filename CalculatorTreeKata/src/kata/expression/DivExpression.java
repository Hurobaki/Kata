package kata.expression;

public class DivExpression extends BinaryExpression {

	public DivExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() throws ArithmeticException {
		Double evaluationResult = _leftExpression.evaluate() / _rightExpression.evaluate();
		
		if (Double.isInfinite(evaluationResult)) {
			throw new ArithmeticException();
		}
		
		if (Double.isNaN(evaluationResult)) {
			throw new ArithmeticException();
		}
		
		return evaluationResult;
	}
}
