package kata;

public class Tuple<Left, Right> {
	private final Left _left;
	private final Right _right;

	public Tuple(Left left, Right right) {
		_left = left;
		_right = right;
	}

	public Left getLeft() { return _left; }
	public Right getRight() { return _right; }

	@Override
	public boolean equals(Object o) {
		if (!(o instanceof Tuple)){
			return false;
		}
		
		@SuppressWarnings("unchecked")
		Tuple<Left,Right> pairo = (Tuple<Left,Right>) o;
		
		return this._left.equals(pairo.getLeft()) &&
           this._right.equals(pairo.getRight());
	}
}