package kata;

public class PosExpression extends UnaryExpression {

	public PosExpression(Expression expression) {
		// TODO Auto-generated constructor stub
		super(expression);
	}

	@Override
	public Double eval() {
		// TODO Auto-generated method stub
		return getExpression().eval();
	}

}
