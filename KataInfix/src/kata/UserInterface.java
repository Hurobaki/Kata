package kata;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.EmptyStackException;
import java.util.Scanner;

public class UserInterface {
	private Calculator _calculator;
	private PrintStream _printStream;
	private InputStream _inputStream;
	private boolean _running = true;
    private Scanner _scanner;
    
    private String _token;
    private String _previousToken;
    private int _charIterator;
    private int _evalutionsCounter;
    private int _userRequestLength;
	
	public UserInterface(InputStream inputStream, PrintStream printStream) {
		_calculator = new Calculator();
		_printStream = printStream;
		_inputStream = inputStream;
		_evalutionsCounter = 0;
		_previousToken = "";
		_token = "";
	}
	
	public void run() {
		 _scanner = new Scanner(_inputStream);
         
         do{
        	 _evalutionsCounter = 0;
             _printStream.print("Calculator > ");
             String userRequest = _scanner.nextLine();
            
             try{
                 parse(userRequest);
             }
             catch(IllegalArgumentException | EmptyStackException e1){
                 _printStream.println("*** Syntax error ***");
             }
             catch(ArithmeticException e2) {
            	 _printStream.println("*** Arithmetic error ***");
             }
            
         }
         while(_running);
	}
	
	public void parse(String userRequest){
		userRequest = "(" + userRequest + ")";
		_userRequestLength = userRequest.length();

		for (_charIterator = 0; _charIterator < _userRequestLength; _charIterator++) {
		    char currentChar = userRequest.charAt(_charIterator);
		    
		    if (currentChar != ' ' && currentChar != '\t') {
		    	if (isNumber(userRequest, currentChar)) {
		    		evaluate();
		    	}
		    	else if (isOperator(String.valueOf(currentChar))) {
		    		_token = String.valueOf(currentChar);
		    		evaluate();
		    	}
		    	else {
		    		_token = getOperand(userRequest);
			    	evaluate();
		    	}
		    }
		}
		
		if(_calculator.empty() == false) {
            _printStream.println(String.valueOf(_calculator.peek()));                    
        }
	}
	
	private boolean isNumber(String userRequest, char currentChar) {
		int charIteratorUnary = _charIterator;
		String tokenUnary = "";
		boolean hasUnaryOperator = false;
		
		if (currentChar == '+' || currentChar == '-') {
			tokenUnary += String.valueOf(currentChar);
			charIteratorUnary++;
			hasUnaryOperator = true;
		}
		
		currentChar = userRequest.charAt(charIteratorUnary);
			
		while(currentChar != ' ' && currentChar != '\t' && !isOperator(String.valueOf(currentChar)) && charIteratorUnary < userRequest.length()) {
			tokenUnary += currentChar;
			charIteratorUnary++;
			currentChar = userRequest.charAt(charIteratorUnary);
		}
		
		if (hasUnaryOperator && !isOperator(_previousToken)) {
			return false;
		}
		
		try {
			Double.parseDouble(tokenUnary);
			
			_charIterator = charIteratorUnary - 1;
			_token = tokenUnary;
			return true;
		}
		catch(NumberFormatException e) {}
	
		return false;
	}
	
	private boolean isOperator(String token) {
		if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^") || token.equals("(") || token.equals(")")) {
			return true;
		}
		
		return false;
	}
	
	private String getOperand(String userRequest) {
		char currentChar = userRequest.charAt(_charIterator);
		String tokenOperand = "";
		
		while(currentChar != ' ' && currentChar != '\t' && !isOperator(String.valueOf(currentChar)) && _charIterator < userRequest.length()) {
			tokenOperand += currentChar;
			_charIterator++;
			currentChar = userRequest.charAt(_charIterator);
		}
		
		_charIterator--;
		
		return tokenOperand;
	}
	
	private void evaluate() {
        switch (_token) {
        	case "+":
            case "-":
            case "/":
            case "*":
            case "^":
    			_calculator.operator(String.valueOf(_token));
                break;
                
            case "(":
    			_calculator.leftParenthesis();
    			break;
    			
    		case ")":
    			_calculator.rigthParenthesis();
    			break;
                
            case "clear":
			clear();
                break;
                
            case "help":
                help();
                break;
                
            case "sin":
            	_calculator.operator("sin");
                break;
                
            case "cos":
            	_calculator.operator("cos");
                break;
                
            case "olivier":
            	_calculator.operator("olivier");
                break;
                
            case "quit":
                quit();
                break;
                
            default:
            	_calculator.operand(Double.parseDouble(_token));
                break;
        }
        
        _previousToken = _token;
        _token = "";
        _evalutionsCounter++;
    }

	private void clear() {
		_calculator.clear();
		_calculator.leftParenthesis();
		_charIterator++;
	}

    private void quit() {
        _printStream.println("Bye !");
        _running = false;
        _charIterator = _userRequestLength - 1;
        clear();
        _scanner.close();
    }

    private void help() {
        _printStream.println("Help !");
    }
}
