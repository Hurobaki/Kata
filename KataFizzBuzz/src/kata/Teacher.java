package kata;

public class Teacher {
	
	private ClassRoom _classroom;
	private static final int MAX_NUMBER = 100;
	
	public Teacher(ClassRoom classroom)
	{
		_classroom = classroom;
	}
	
	public void ask()
	{		
		for(int numberAsked = 1; numberAsked <= MAX_NUMBER; numberAsked++)
		{
			Student student = _classroom.getStudent(numberAsked-1);
			String answer = student.ask(numberAsked);
			System.out.println("the math teacher asks " + numberAsked + " => the student #" + student.getStudentId()+ " answers " + answer);
		}
	}
	
	
}
