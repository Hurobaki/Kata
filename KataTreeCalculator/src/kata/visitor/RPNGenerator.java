package kata.visitor;

import kata.expression.AddExpression;
import kata.expression.ConstantExpression;
import kata.expression.CosExpression;
import kata.expression.DivExpression;
import kata.expression.MulExpression;
import kata.expression.NegExpression;
import kata.expression.ParenthesisExpression;
import kata.expression.PosExpression;
import kata.expression.PowExpression;
import kata.expression.SinExpression;
import kata.expression.SubExpression;
import kata.interfaces.ASTVisitor;

public class RPNGenerator implements ASTVisitor {

	private StringBuilder _builder = new StringBuilder();

	public RPNGenerator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void visit(AddExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" + ");
	}

	@Override
	public void visit(ConstantExpression e) {
		// TODO Auto-generated method stub
		_builder.append(e.getConstant() + " ");
	}

	@Override
	public void visit(CosExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" cos ");
	}

	@Override
	public void visit(DivExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" / ");
	}

	@Override
	public void visit(MulExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" * ");
	}

	@Override
	public void visit(NegExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" neg ");
	}

	@Override
	public void visit(ParenthesisExpression e) {
		// TODO Auto-generated method stub
		_builder.append("");
	}

	@Override
	public void visit(PosExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" pos ");
	}

	@Override
	public void visit(PowExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" ^ ");
	}

	@Override
	public void visit(SinExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" sin ");
	}

	@Override
	public void visit(SubExpression e) {
		// TODO Auto-generated method stub
		_builder.append(" - ");
	}

	public String getString() {
		return _builder.toString();
	}

}
