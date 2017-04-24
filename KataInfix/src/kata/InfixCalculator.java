package kata;
 
import java.util.Stack;
 
public class InfixCalculator {
    private Stack<String> _operators;
    private Stack<Double> _operands;
   
    public InfixCalculator() {
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
    }
   
    public Double evaluate() {
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
                if (operandRight == 0.0) {
                    throw new IllegalArgumentException();
                }
               
                evaluationResult = operandLeft / operandRight;
                break;
        }
       
        return evaluationResult;
    }
   
    public int priority(String operator) {
        if (operator.equals("(") || operator.equals(")")) {
            return 1;
        }
        else if (operator.equals("^")) {
            return 4;
        }
        else if (operator.equals("*") || operator.equals("/")) {
            return 3;
        }
        else if (operator.equals("+") || operator.equals("-")) {
            return 2;
        }
        else {
            return 0;
        }
    }
   
    public Double pop() {
        return _operands.pop();
    }
   
    public void clear() {
        _operators.clear();
        _operands.clear();
    }
}