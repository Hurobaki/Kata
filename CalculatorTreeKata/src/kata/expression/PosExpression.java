package kata.expression;

import kata.interfaces.ASTVisitor;

public class PosExpression extends UnaryExpression {

	public PosExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return +_expression.evaluate();
	}

	@Override
	public String toRPN() {
		String rhs = _expression.toRPN();
		return rhs + " " + "pos";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_expression.accept(v);
		v.visit(this);
	}
}
