package kata.interfaces;

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

public interface ASTVisitor {
	void visit(AddExpression e);

	void visit(ConstantExpression e);

	void visit(CosExpression e);

	void visit(DivExpression e);

	void visit(MulExpression e);

	void visit(NegExpression e);

	void visit(ParenthesisExpression e);

	void visit(PosExpression e);

	void visit(PowExpression e);

	void visit(SinExpression e);

	void visit(SubExpression e);

}
