package kata;

public class AddExpression extends BinaryExpression {

	public AddExpression(Expression leftExpression, Expression rightExpression) {
		// TODO Auto-generated constructor stub
		super(leftExpression,rightExpression);
	}

	@Override
	public Double eval() {
		// TODO Auto-generated method stub
		return getLeftExpression().eval() + getRightExpression().eval();
	}
	
	
	
	

}
