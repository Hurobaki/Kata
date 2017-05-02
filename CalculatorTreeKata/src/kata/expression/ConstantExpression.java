package kata.expression;

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
}
