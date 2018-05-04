package kata.expression;

import kata.interfaces.ASTVisitor;

public class SubExpression extends BinaryExpression {

	public SubExpression(Expression leftExpression, Expression rightExpression) {
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() {
		return _rightExpression.evaluate() - _leftExpression.evaluate();
	}

	@Override
	public String toRPN() {
		String lhs = _leftExpression.toRPN();
		String rhs = _rightExpression.toRPN();
		return lhs + " " + rhs + " " + "-";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_leftExpression.accept(v);
		_rightExpression.accept(v);
		v.visit(this);
	}
}
