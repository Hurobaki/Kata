package kata.expression;

import kata.interfaces.ASTVisitor;

public class NegExpression extends UnaryExpression {

	public NegExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return -_expression.evaluate();
	}

	@Override
	public String toRPN() {
		String rhs = _expression.toRPN();
		return rhs + " " + "neg";
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_expression.accept(v);
		v.visit(this);
	}
}
