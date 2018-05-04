package kata.visitor;

import java.util.Stack;

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

public class ASTEvaluator implements ASTVisitor {

	private Stack<Double> _stack;

	public ASTEvaluator() {
		// TODO Auto-generated constructor stub
		_stack = new Stack<Double>();
	}

	@Override
	public void visit(AddExpression e) {
		// TODO Auto-generated method stub
		Double operand1 = _stack.pop();
		Double operand2 = _stack.pop();

		_stack.push(operand1 + operand2);
	}

	@Override
	public void visit(ConstantExpression e) {
		// TODO Auto-generated method stub
		_stack.push(e.getConstant());
	}

	@Override
	public void visit(CosExpression e) {
		// TODO Auto-generated method stub
		Double operand = _stack.pop();

		_stack.push(Math.cos(operand));
	}

	@Override
	public void visit(DivExpression e) {
		// TODO Auto-generated method stub
		Double operand1 = _stack.pop();
		Double operand2 = _stack.pop();

		_stack.push(operand2 / operand1);
	}

	@Override
	public void visit(MulExpression e) {
		// TODO Auto-generated method stub
		Double operand1 = _stack.pop();
		Double operand2 = _stack.pop();

		_stack.push(operand1 * operand2);
	}

	@Override
	public void visit(NegExpression e) {
		// TODO Auto-generated method stub
		Double operand = _stack.pop();

		_stack.push(-operand);
	}

	@Override
	public void visit(ParenthesisExpression e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(PosExpression e) {
		// TODO Auto-generated method stub
		Double operand = _stack.pop();

		_stack.push(+operand);
	}

	@Override
	public void visit(PowExpression e) {
		// TODO Auto-generated method stub
		Double operand1 = _stack.pop();
		Double operand2 = _stack.pop();

		_stack.push(Math.pow(operand2, operand1));
	}

	@Override
	public void visit(SinExpression e) {
		// TODO Auto-generated method stub
		Double operand = _stack.pop();

		_stack.push(Math.sin(operand));
	}

	@Override
	public void visit(SubExpression e) {
		// TODO Auto-generated method stub
		Double operand1 = _stack.pop();
		Double operand2 = _stack.pop();

		_stack.push(operand2 - operand1);
	}

	public Double getResult() {
		return _stack.pop();
	}

}
