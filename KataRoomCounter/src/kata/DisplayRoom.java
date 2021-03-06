package kata;

public class DisplayRoom {
	
	private RoomCounter[] _roomCounter;
	private Plan[] _plan;
	
	public DisplayRoom()
	{
		_roomCounter = new RoomCounter[7];
		_plan = new Plan[7];
		
		_plan[0] = new Plan(10,17, new int[][]{
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
				
		});
		
		_plan[1] = new Plan(10,17, new int[][]{
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		});
		
		_plan[2] = new Plan(10,18, new int[][]{
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,0,0,0,0,1,0,0,0,0,0,1},
				{1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1},
				{1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,1},
				{1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,1},
				{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
		});
		
		_plan[3] = new Plan(5,5, new int[][]{
				{1,1,1,1,1},
				{1,0,1,0,1},
				{1,0,0,0,1},
				{1,0,1,1,1},
				{1,1,1,1,1}
		});
		
		_plan[4] = new Plan(5, 5, new int[][]{
				{1,1,1,1,1},
				{1,0,1,0,1},
				{1,1,0,1,1},
				{1,0,0,0,1},
				{1,1,1,1,1}
		});
		
		_plan[5] = new Plan(10,10, new int[][]{
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1}
		});
		
		_plan[6] = new Plan(10,10, new int[][]{
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,0,1,1,1,1,1},
				{1,1,1,0,0,0,1,1,1,1},
				{1,1,0,0,0,0,0,1,1,1},
				{1,1,1,0,0,0,1,1,1,1},
				{1,1,1,1,0,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,1}
		});
		
		_roomCounter[0] = new RoomCounter(_plan[0]);
		_roomCounter[1] = new RoomCounter(_plan[1]);
		_roomCounter[2] = new RoomCounter(_plan[2]);
		_roomCounter[3] = new RoomCounter(_plan[3]);
		_roomCounter[4] = new RoomCounter(_plan[4]);
		_roomCounter[5] = new RoomCounter(_plan[5]);
		_roomCounter[6] = new RoomCounter(_plan[6]);
		
		count();
		//newCount();
		//countThirdVersion();
	}
	
	private void count(){
        for(int roomCurrent = 0; roomCurrent < _roomCounter.length; roomCurrent++){
            _roomCounter[0] = new RoomCounter(_plan[0]);
            int lineNumber = _plan[roomCurrent].getLine();
            int columnNumber = _plan[roomCurrent].getColumn();
            int[][] map = _plan[roomCurrent].getMap();
           
            for (int line = 0; line < lineNumber; line++) {
                for (int column = 0; column < columnNumber; column++) {
                    System.out.print(map[line][column] + " ");
                }
               
                System.out.println("");
            }
           
            System.out.println("");
           
            System.out.println("Room count : " + _roomCounter[roomCurrent].count() + " \n");
        }
    }
	
	private void newCount(){
        for(int roomCurrent = 0; roomCurrent < _roomCounter.length; roomCurrent++){
            _roomCounter[0] = new RoomCounter(_plan[0]);
            int lineNumber = _plan[roomCurrent].getLine();
            int columnNumber = _plan[roomCurrent].getColumn();
            int[][] map = _plan[roomCurrent].getMap();
           
            for (int line = 0; line < lineNumber; line++) {
                for (int column = 0; column < columnNumber; column++) {
                    System.out.print(map[line][column] + " ");
                }
               
                System.out.println("");
            }
           
            System.out.println("");
           
            System.out.println("Room count : " + _roomCounter[roomCurrent].newCount() + " \n");
        }
    }
	
	private void countThirdVersion(){
        for(int roomCurrent = 0; roomCurrent < _roomCounter.length; roomCurrent++){
            _roomCounter[0] = new RoomCounter(_plan[0]);
            int lineNumber = _plan[roomCurrent].getLine();
            int columnNumber = _plan[roomCurrent].getColumn();
            int[][] map = _plan[roomCurrent].getMap();
           
            for (int line = 0; line < lineNumber; line++) {
                for (int column = 0; column < columnNumber; column++) {
                    System.out.print(map[line][column] + " ");
                }
               
                System.out.println("");
            }
           
            System.out.println("");
           
            System.out.println("Room count : " + _roomCounter[roomCurrent].countThirdVersion() + " \n");
        }
    }
	
	
}
