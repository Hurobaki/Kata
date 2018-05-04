package kata.expression;

import kata.interfaces.ASTVisitor;

public abstract class Expression {
	public Expression() {

	}

	public abstract void accept(ASTVisitor v);

	public abstract Double evaluate();

	public abstract String toRPN();
}