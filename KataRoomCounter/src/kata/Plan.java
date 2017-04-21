package kata;

public class Plan {
	
	private int _line;
	private int _column;
	private int[][] _map;
	
	public Plan(int line, int column, int[][] map)
	{
		_line = line;
		_column = column;
		_map = map;
	}
	
	public Point getPoint(int y, int x)
	{
		return new Point(y,x);
	}
	
	public int getState(int y, int x)
	{
		return _map[x][y];
	}
	
	public int[][] getMap()
	{
		return _map;
	}
	
	public int getLine(){
		return _line;
	}
	
	public int getColumn(){
		return _column;
	}
}
