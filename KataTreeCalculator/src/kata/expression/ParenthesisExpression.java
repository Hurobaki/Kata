package kata.expression;

import kata.interfaces.ASTVisitor;

public class ParenthesisExpression extends UnaryExpression {

	public ParenthesisExpression(Expression expression) {
		super(expression);
	}

	@Override
	public Double evaluate() {
		return _expression.evaluate();
	}

	@Override
	public String toRPN() {
		return _expression.toRPN();
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		_expression.accept(v);
		v.visit(this);
	}
}
