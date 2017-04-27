package kata;

public class Tuple<Operator, OperandNumber> {
	private final Operator _operator;
	private final OperandNumber _operandNumber;
	
	public Tuple(Operator operand, OperandNumber operandNumber) {
		this._operator = operand;
		this._operandNumber = operandNumber;
	}

	public Operator getOperator() { return _operator; }
	public OperandNumber getOperandNumber() { return _operandNumber; }

	@Override
	public int hashCode() { return _operator.hashCode() ^ _operandNumber.hashCode(); }

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tuple)){
			return false;
		}
		
		Tuple<Operator,OperandNumber> pairo = (Tuple<Operator,OperandNumber>) o;
		
		return this._operator.equals(pairo.getOperator()) &&
           this._operandNumber.equals(pairo.getOperandNumber());
	}
}