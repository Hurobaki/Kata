package kata;

public class Tuple<N,R,O> {
	
	private final N _left;
	private final R _right;
	private final O _occurence;
	
	public Tuple(N numeric, R roman)
	{
		this._left = numeric;
		this._right = roman;
		this._occurence = null;
	}
	
	public Tuple(N numeric, R roman, O occurence)
	{
		this._left = numeric;
		this._right = roman;
		this._occurence = occurence;
	}
	
	public N getLeft()
	{
		return _left;
	}
	
	public R getRight()
	{
		return _right;
	}
	
	public O getOccurence()
	{
		return _occurence;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_left == null) ? 0 : _left.hashCode());
		result = prime * result
				+ ((_occurence == null) ? 0 : _occurence.hashCode());
		result = prime * result + ((_right == null) ? 0 : _right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tuple<?, ?, ?> other = (Tuple<?, ?, ?>) obj;
		if (_left == null) {
			if (other._left != null)
				return false;
		} else if (!_left.equals(other._left))
			return false;
		if (_occurence == null) {
			if (other._occurence != null)
				return false;
		} else if (!_occurence.equals(other._occurence))
			return false;
		if (_right == null) {
			if (other._right != null)
				return false;
		} else if (!_right.equals(other._right))
			return false;
		return true;
	}

	
	
	
}
