package kata;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
	
	private Stack<Double> _stack;
	
	public RPNCalculator()
	{
		_stack = new Stack<Double>();
	}
	
	public Stack<Double> getStack()
	{
		return _stack;
	}
	
	public void push(Double numberToPush)
	{
		_stack.push(numberToPush);
	}
	
	public Double pop() throws EmptyStackException
	{	
		if(_stack.isEmpty())
		{
			throw new EmptyStackException();
		}
		
		return _stack.pop();
	}
	
	public void clear()
	{
		_stack.clear();
	}
	
	public void add() throws IllegalArgumentException
	{
		try
		{
			double operand1 = _stack.pop();
			double operand2 = _stack.pop();
			
			push(operand1 + operand2);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	public void substract() throws IllegalArgumentException
	{
		try
		{
			double operand1 = _stack.pop();
			double operand2 = _stack.pop();
			
			push(operand2 - operand1);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	public void multiply() throws IllegalArgumentException
	{
		try
		{
			double operand1 = _stack.pop();
			double operand2 = _stack.pop();
			
			push(operand1 * operand2);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}	
	}
	
	public void divide() throws IllegalArgumentException
	{
		try
		{
			double operand1 = _stack.pop();
			double operand2 = _stack.pop();
			
			if(operand1 == Double.valueOf(0))
			{
				throw new IllegalArgumentException();
			}
			
			push(operand2 / operand1);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}
		
	}
	
	public boolean empty()
	{
		return _stack.isEmpty();
	}
}
