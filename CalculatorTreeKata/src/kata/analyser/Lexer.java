package kata.analyser;

public class Lexer {

	private String _statement;
	private int _cursor;

	private Token _token;
	private String _value;
	private String _oldValue;

	public static enum Token {
		TK_START, TK_END, TK_NOP, TK_HELP, TK_QUIT, TK_CLEAR, TK_NUMBER, TK_LEFT_PARENTHESIS, TK_RIGHT_PARENTHESIS, TK_PLUS, TK_MINUS, TK_MULTIPLY, TK_DIVIDE, TK_POW, TK_SIN, TK_COS
	};

	public Lexer(String statement) {
		_statement = statement;
		_token = Token.TK_START;
		_value = "START";
		_oldValue = "";
		_cursor = 0;
	}

	public boolean accept(Token token) {
		if (token == _token) {
			_oldValue = _value;
			nextToken();
			return true;
		}
		return false;
	}

	public boolean expect(Token token) throws IllegalArgumentException {
		if (!accept(token)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public void nextToken() throws IllegalArgumentException {
		int statementLength = _statement.length();
		if (_cursor == statementLength) {
			_token = Token.TK_END;
			_value = "END";
		} else {
			char currentChar = _statement.charAt(_cursor);

			while (currentChar == ' ') {
				_cursor++;
				currentChar = _statement.charAt(_cursor);
			}

			try {
				if (currentChar != ' ' && currentChar != '\t') {
					if (isParenthesis(currentChar)) {

					} else if (isNumber(currentChar)) {

					} else if (getOperator(currentChar)) {

					} else if (getOperand()) {

					}
				}
			} catch (StringIndexOutOfBoundsException e) {
				throw new IllegalArgumentException();
			}

		}
	}

	private boolean isParenthesis(char currentChar) {
		switch (currentChar) {
		case '(':
			_token = Token.TK_LEFT_PARENTHESIS;
			_value = "(";
			_cursor++;
			return true;

		case ')':
			_token = Token.TK_RIGHT_PARENTHESIS;
			_value = ")";
			_cursor++;
			return true;
		}

		return false;
	}

	private boolean isNumber(char currentChar) {
		String tokenNumber = "";
		int cursorNumber = _cursor;
		boolean hasUnaryOperator = false;
		int statementLength = _statement.length();

		if (currentChar == '+' || currentChar == '-') {
			tokenNumber += String.valueOf(currentChar);
			hasUnaryOperator = true;
			cursorNumber++;
		}

		currentChar = _statement.charAt(cursorNumber);

		while (currentChar != ' ' && currentChar != '\t'
				&& !isOperator(currentChar) && cursorNumber < statementLength
				&& currentChar != '(' && currentChar != ')') {
			tokenNumber += currentChar;
			cursorNumber++;

			if (cursorNumber < statementLength) {
				currentChar = _statement.charAt(cursorNumber);
			}
		}

		if (hasUnaryOperator && !isOperator(_value.charAt(0))
				&& _token != Token.TK_LEFT_PARENTHESIS
				&& _token != Token.TK_RIGHT_PARENTHESIS
				&& _token != Token.TK_CLEAR && _token != Token.TK_HELP
				&& _token != Token.TK_QUIT && _token != Token.TK_START) {
			return false;
		}

		try {
			Double.parseDouble(tokenNumber);

			_cursor = cursorNumber;
			_token = Token.TK_NUMBER;
			_value = tokenNumber;

			return true;
		} catch (NumberFormatException e) {
		}

		return false;
	}

	private boolean isOperator(char currentChar) {
		String tokenOperator = "";
		int cursorOperator = _cursor;
		int statementLength = _statement.length();

		switch (currentChar) {
		case '+':
			return true;

		case '-':
			return true;

		case '*':
			return true;

		case '/':
			return true;

		case '^':
			return true;
		}

		while (String.valueOf(currentChar).matches("[a-zA-Z]+\\.?")
				&& cursorOperator < statementLength) {
			currentChar = _statement.charAt(cursorOperator);
			tokenOperator += currentChar;
			cursorOperator++;
		}

		switch (tokenOperator) {
		case "sin":
			return true;

		case "cos":
			return true;
		}

		return false;
	}

	private boolean getOperator(char currentChar) {
		String tokenOperator = "";
		int cursorOperator = _cursor;
		int statementLength = _statement.length();

		switch (currentChar) {
		case '+':
			_token = Token.TK_PLUS;
			_value = String.valueOf(currentChar);
			_cursor++;
			return true;

		case '-':
			_token = Token.TK_MINUS;
			_value = String.valueOf(currentChar);
			_cursor++;
			return true;

		case '*':
			_token = Token.TK_MULTIPLY;
			_value = String.valueOf(currentChar);
			_cursor++;
			return true;

		case '/':
			_token = Token.TK_DIVIDE;
			_value = String.valueOf(currentChar);
			_cursor++;
			return true;

		case '^':
			_token = Token.TK_POW;
			_value = String.valueOf(currentChar);
			_cursor++;
			return true;
		}

		while (cursorOperator < statementLength) {
			currentChar = _statement.charAt(cursorOperator);

			if (String.valueOf(currentChar).matches("[a-zA-Z]+\\.?")) {
				tokenOperator += currentChar;
				cursorOperator++;
			} else {
				break;
			}
		}

		switch (tokenOperator) {
		case "sin":
			_cursor = cursorOperator;
			_token = Token.TK_SIN;
			_value = tokenOperator;
			return true;

		case "cos":
			_cursor = cursorOperator;
			_token = Token.TK_COS;
			_value = tokenOperator;
			return true;
		}

		return false;
	}

	private boolean getOperand() {
		String tokenOperand = "";
		int statementLength = _statement.length();
		char currentChar = _statement.charAt(_cursor);

		currentChar = _statement.charAt(_cursor);

		while (currentChar != ' ' && currentChar != '\t'
				&& !isOperator(currentChar) && _cursor < statementLength) {
			tokenOperand += currentChar;
			_cursor++;

			if (_cursor < statementLength) {
				currentChar = _statement.charAt(_cursor);
			}

			switch (tokenOperand.toLowerCase()) {
			case "clear":
				_token = Token.TK_CLEAR;
				_value = tokenOperand;
				return true;

			case "help":
				_token = Token.TK_HELP;
				_value = tokenOperand;
				return true;

			case "quit":
				_token = Token.TK_QUIT;
				_value = tokenOperand;
				return true;
			}
		}

		return false;
	}

	public Token getToken() {
		return _token;
	}

	public String getValue() {
		return _oldValue;
	}
}
