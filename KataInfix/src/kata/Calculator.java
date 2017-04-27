package kata;

import java.util.Stack;

public class Calculator {
	private Stack<Tuple<String, Integer>> _operators;
	private Stack<Double> _operands;
	private String _lastPreviousOperator;
	private boolean _firstPush;
	
	public Calculator() {
		_operators = new Stack<Tuple<String, Integer>>();
		_operands = new Stack<Double>();
		_lastPreviousOperator = "";
		_firstPush = true;
	}
	
	public void operand(Double operand) {
		_firstPush = false;
		_operands.push(operand);
		_lastPreviousOperator = "";
	}
	
	public void operator(String operator) {
		int operandNumber = 0;
		
		if(_firstPush) {
			operandNumber = 1;
		}
		else if(_lastPreviousOperator.equals("")) {
			operandNumber = 2;
			
			while (!_operators.isEmpty() && priority(_operators.peek().getOperator()) >= priority(operator)){
				_operands.push(evaluate());
			}
		}
		else {
			operandNumber = 1;
		}
		
		_operators.push(new Tuple<String,Integer>(operator, operandNumber));
		_lastPreviousOperator = operator;
		_firstPush = false;
	}
	
	public void leftParenthesis() {
		_operators.push(new Tuple<String,Integer>("(", 0));
	}
	
	public void rigthParenthesis() {
		while (!_operators.peek().getOperator().equals("(")) {
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
		_lastPreviousOperator = "";
		_firstPush = true;
	}
	
	private Double evaluate() throws ArithmeticException {
		Tuple<String,Integer> operator = _operators.pop();
		Double evaluationResult = 0.0;
		
		switch (operator.getOperator()) {
			case "+": {
				if(operator.getOperandNumber() == 1){
					Double operand = _operands.pop();
					evaluationResult = +operand;
				}
				else{
					Double operandRight = _operands.pop();
					Double operandLeft = _operands.pop();
					evaluationResult = operandLeft + operandRight;
				}
			}break;
				
			case "-": {
				if(operator.getOperandNumber() == 1){
					Double operand = _operands.pop();
					evaluationResult = -operand;
				}
				else{
					Double operandRight = _operands.pop();
					Double operandLeft = _operands.pop();
					evaluationResult = operandLeft - operandRight;
				}
			}break;
				
			case "*": {
				Double operandRight = _operands.pop();
				Double operandLeft = _operands.pop();
				evaluationResult = operandLeft * operandRight;
			}break;
				
			case "/": {
				Double operandRight = _operands.pop();
				Double operandLeft = _operands.pop();
				evaluationResult = operandLeft / operandRight;
			}break;
			
			case "^": {
				Double operandRight = _operands.pop();
				Double operandLeft = _operands.pop();
				evaluationResult = Math.pow(operandLeft, operandRight);
			}break;
			
			case "sin": {
				Double operand = _operands.pop();
				evaluationResult = Math.sin(operand);
			}break;
			
			case "cos": {
				Double operand = _operands.pop();
				evaluationResult = Math.cos(operand);
			}break;
			
			case "olivier": {
				_operands.pop();
				evaluationResult = 42.0;
			}break;
		}
		
		if (Double.isInfinite(evaluationResult)) {
			throw new ArithmeticException();
		}
		
		if (Double.isNaN(evaluationResult)) {
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
			case "sin":
			case "cos":
			case "olivier":
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
