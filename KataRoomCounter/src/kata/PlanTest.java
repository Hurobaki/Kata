package kata;

import org.junit.*;

public class PlanTest {
	
	private Plan _plan;
	
	@Before
	public void setUp(){		
		_plan = new Plan(5,5,new int[][]{
				{1,1,1,1,1},	
				{1,1,1,1,1},	
				{1,1,1,1,1},	
				{1,1,1,1,1},	
				{1,1,1,1,1},	
		});
	}

	@Test
	public void should_plan_not_null() {
		Assert.assertNotNull(_plan);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void should_raison_exception()
	{
		_plan.getPoint(150,150);
	}
	
	@Test
	public void should_return_1_for_get_point()
	{
		Assert.assertEquals(1, _plan.getPoint(2, 4));
	}
	

}
