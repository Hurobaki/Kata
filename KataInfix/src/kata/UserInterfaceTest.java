package kata;


import org.junit.*;

public class UserInterfaceTest {

	private UserInterface _userInterface;
	
	@Before
	public void setUp()
	{
		_userInterface = new UserInterface(System.in, System.out);
	}
	
	@Test
	public void should_user_interface_not_null()
	{
		Assert.assertNotNull(_userInterface);
	}

}
