package kata.expression;

import kata.interfaces.ASTVisitor;

public class ConstantExpression extends Expression {

	private Double _constant;

	public ConstantExpression(Double constant) {
		_constant = constant;
	}

	@Override
	public Double evaluate() {
		return _constant;
	}

	public Double getConstant() {
		return _constant;
	}

	@Override
	public String toRPN() {
		String constant = _constant.toString();
		return constant;
	}

	@Override
	public void accept(ASTVisitor v) {
		// TODO Auto-generated method stub
		v.visit(this);
	}
}
