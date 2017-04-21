package kata;

import static org.junit.Assert.*;

import org.junit.*;

public class ClassRoomTest {
	
	private ClassRoom _classroom;
	
	@Before
	public void setUp()
	{
		_classroom = new ClassRoom(42);
	}

	@Test
	public void should_classroom_not_null() {
		Assert.assertNotNull(_classroom);
	}

	@Test
	public void should_not_raise_exception_teacher_asking()
	{
		_classroom.teacherAsking();
	}
}
