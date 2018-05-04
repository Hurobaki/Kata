package kata.expression;

import kata.interfaces.ASTVisitor;

public class CosExpression extends UnaryExpression {

	public CosExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return Math.cos(_expression.evaluate());
	}

	@Override
	public String toRPN() {
		String rhs = _expression.toRPN();
		return rhs + " " + "cos";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_expression.accept(v);
		v.visit(this);
	}
}
