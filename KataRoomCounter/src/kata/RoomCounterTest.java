package kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RoomCounterTest {
	
	private RoomCounter[] _roomCounter;
	private Plan[] _plan;
	
	@Before
	public void setUp()
	{
		_roomCounter = new RoomCounter[5];
		_plan = new Plan[5];
		
		_plan[0] = new Plan(5,5, new int[][]{
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1},
				{1,1,1,1,1}
		});
		
		_plan[1] = new Plan(5,5, new int[][]{
				{1,1,1,1,1},
				{1,0,1,0,1},
				{1,0,1,0,1},
				{1,0,0,0,1},
				{1,1,1,1,1}
		});
		
		_plan[2] = new Plan(5,5, new int[][]{
				{1,1,1,1,1},
				{1,0,1,0,1},
				{1,0,1,1,1},
				{1,0,0,0,1},
				{1,1,1,1,1}
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
		
		_roomCounter[0] = new RoomCounter(_plan[0]);
		_roomCounter[1] = new RoomCounter(_plan[1]);
		_roomCounter[2] = new RoomCounter(_plan[2]);
		_roomCounter[3] = new RoomCounter(_plan[3]);
		_roomCounter[4] = new RoomCounter(_plan[4]);
		
	}

	@Test
	public void should_room_counter_0_not_null() {
		Assert.assertNotNull(_roomCounter[0]);
	}
	
	@Test
	public void should_room_counter_1_not_null() {
		Assert.assertNotNull(_roomCounter[1]);
	}
	
	@Test
	public void should_return_0_for_count_plan_0()
	{
		Assert.assertEquals(0, _roomCounter[0].count());
	}
	
	@Test
	public void should_return_1_for_count_plan_1()
	{
		Assert.assertEquals(1, _roomCounter[1].count());
	}
	
	@Test
	public void should_return_2_for_count_plan_2()
	{
		Assert.assertEquals(2, _roomCounter[2].count());
	}
	
	@Test
	public void should_return_1_for_count_plan_3()
	{
		Assert.assertEquals(1, _roomCounter[3].count());
	}
	
	@Test
	public void should_return_3_for_count_plan_4()
	{
		Assert.assertEquals(3, _roomCounter[4].count());
	}
	
	@Test
	public void should_return_3_for_new_count_plan_4()
	{
		Assert.assertEquals(3, _roomCounter[4].newCount());
	}
}
