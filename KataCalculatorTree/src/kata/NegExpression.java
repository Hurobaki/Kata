package kata;

public class NegExpression extends UnaryExpression{

	public NegExpression(Expression expression) {
		// TODO Auto-generated constructor stub
		super(expression);
	}

	@Override
	public Double eval() {
		// TODO Auto-generated method stub
		return getExpression().eval();
	}

}
