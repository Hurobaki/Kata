package kata;

import static org.junit.Assert.*;

import org.junit.*;

public class TeacherTest {
	
	private Teacher _teacher;
	
	@Before
	public void SetUp()
	{
		_teacher = new Teacher(new ClassRoom(42));
	}

	@Test
	public void should_instantiate_teacher() {
		Assert.assertNotNull(_teacher);
	}

	
	@Test
	public void should_not_raise_exception()
	{
		_teacher.ask();
	}
	
}
