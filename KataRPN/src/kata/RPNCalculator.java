package kata;

import java.util.EmptyStackException;
import java.util.Stack;

public class RPNCalculator {
	
	private Stack<Double> _stack;
	private double operand1;
	private double operand2;
	
	public RPNCalculator()
	{
		_stack = new Stack<Double>();
	}
	
	public void push(Double numberToPush)
	{
		_stack.push(numberToPush);
	}
	
	public void pop()
	{
		
	}
	
	public void clear()
	{
		_stack.clear();
	}
	
	public void add() throws IllegalArgumentException
	{
		try
		{
			operand1 = _stack.pop();
			operand2 = _stack.pop();
			
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
			operand1 = _stack.pop();
			operand2 = _stack.pop();
			
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
			operand1 = _stack.pop();
			operand2 = _stack.pop();
			
			push(operand1 * operand2);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}	
	}
	
	public void divide()
	{
		try
		{
			operand1 = _stack.pop();
			operand2 = _stack.pop();
			
			push(operand2 / operand1);
		}catch(EmptyStackException e)
		{
			throw new IllegalArgumentException();
		}
		
	}
}
