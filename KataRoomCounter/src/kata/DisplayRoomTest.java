package kata;

import org.junit.*;

public class DisplayRoomTest {

	private DisplayRoom _displayRoom;
	
	@Before
	public void setUp()
	{
		_displayRoom = new DisplayRoom();
	}
	
	@Test
	public void should_display_room_not_null()
	{
		Assert.assertNotNull(_displayRoom);
	}
}
