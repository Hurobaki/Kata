package kata;

import java.util.Stack;

public class Calculator {
	private Stack<String> _operators;
	private Stack<Double> _operands;
	private String lastOperator = "";
	
	public Calculator() {
		_operators = new Stack<String>();
		_operands = new Stack<Double>();
	}
	
	public void operand(Double operand) {
		_operands.push(operand);
	}
	
	public void operator(String operator) {
		while (!_operators.isEmpty() && priority(_operators.peek()) >= priority(operator)){
			_operands.push(evaluate());
		}
		
		_operators.push(operator);
	}
	
	public void leftParenthesis() {
		_operators.push("(");
	}
	
	public void rigthParenthesis() {
		while (!_operators.peek().equals("(")) {
			_operands.push(evaluate());
		}
		
		_operators.pop();
	}
	
	public Double pop() {
		return _operands.pop();
	}
	
	public Double peek() {
		return _operands.peek();
	}
	
	public void clear() {
		_operators.clear();
		_operands.clear();
	}
	
	private Double evaluate() throws ArithmeticException{
		String operator = _operators.pop();
		Double operandRight = _operands.pop();
		Double operandLeft = _operands.pop();
		Double evaluationResult = 0.0;
		
		switch (operator) {
			case "+":
				evaluationResult = operandLeft + operandRight;
				break;
				
			case "-":
				evaluationResult = operandLeft - operandRight;
				break;
				
			case "*":
				evaluationResult = operandLeft * operandRight;
				break;
				
			case "/":
				evaluationResult = operandLeft / operandRight;
				break;
		}
		
		if(Double.isInfinite(evaluationResult)){
			throw new ArithmeticException();
		}
		
		return evaluationResult;
	}
	
	private int priority(String operator) {
		switch(operator) {
			case "(":
			case ")":	
				return 0;
				
			case "^":
				return 4;
				
			case "*":
			case "/":
				return 3;
				
			case "+":
			case "-":
				return 2;
				
			default:
				return 1;
		}
	}
	
	public boolean empty(){
		return _operands.isEmpty();
	}
}
