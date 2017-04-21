package kata;

import static org.junit.Assert.*;

import org.junit.*;

public class StudentTest {
	
	Student _student;
	
	@Before
	public void setUp()
	{
		_student = new Student(42);
	}

	@Test
	public void should_instantiate_student() {
		Assert.assertNotNull(_student);
	}
	
	@Test
	public void should_return_42_for_student_Id()
	{
		Assert.assertEquals(42, _student.getStudentId());
	}
	
	@Test
	public void should_return_1_when_asking_1()
	{
		Assert.assertEquals("1", _student.ask(1));
	}
	
	@Test
	public void should_return_0_when_asking_0()
	{
		Assert.assertEquals("0", _student.ask(0));
	}
	
	@Test
	public void should_return_Fizz_when_is_modulo_3()
	{
		Assert.assertEquals("Fizz", _student.ask(3));
	}
	
	@Test
	public void should_return_Buzz_when_is_modulo_5()
	{
		Assert.assertEquals("Buzz", _student.ask(5));
	}
	
	@Test
	public void should_return_FizzBuzz_when_is_modulo_3_and_5()
	{
		Assert.assertEquals("FizzBuzz", _student.ask(15));
	}
	
	
}
