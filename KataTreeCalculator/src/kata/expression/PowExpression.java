package kata.expression;

import kata.interfaces.ASTVisitor;

public class PowExpression extends BinaryExpression {

	public PowExpression(Expression leftExpression, Expression rightExpression) {
		// TODO Auto-generated constructor stub
		super(leftExpression, rightExpression);
	}

	@Override
	public Double evaluate() {
		// TODO Auto-generated method stub
		return Math.pow(getLeftExpression().evaluate(), getRightExpression()
				.evaluate());
	}

	@Override
	public String toRPN() {
		String lhs = _leftExpression.toRPN();
		String rhs = _rightExpression.toRPN();
		return lhs + " " + rhs + " " + "^";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_leftExpression.accept(v);
		_rightExpression.accept(v);
		v.visit(this);
	}

}
