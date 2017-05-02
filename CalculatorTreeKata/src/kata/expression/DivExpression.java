package kata.expression;

import kata.interfaces.ASTVisitor;

public class DivExpression extends BinaryExpression {

	public DivExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() throws ArithmeticException {
		Double evaluationResult = _leftExpression.evaluate()
				/ _rightExpression.evaluate();

		if (Double.isInfinite(evaluationResult)) {
			throw new ArithmeticException();
		}

		if (Double.isNaN(evaluationResult)) {
			throw new ArithmeticException();
		}

		return evaluationResult;
	}

	@Override
	public String toRPN() {
		String lhs = _leftExpression.toRPN();
		String rhs = _rightExpression.toRPN();
		return lhs + " " + rhs + " " + "/";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_leftExpression.accept(v);
		_rightExpression.accept(v);
		v.visit(this);
	}
}
