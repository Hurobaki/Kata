package kata;

public class Student {
	
	private int _studentId;
	
	public Student(int studentId)
	{
		_studentId = studentId;
	}
	
	public String ask(int number)
	{
		String answer = "";
		
		if(number != 0)
		{
			if((number % 3) == 0) {
				answer += "Fizz";
			}
			if((number % 5) == 0) {
				answer += "Buzz";
			}
		}
		if(answer.isEmpty()) {
			answer = String.valueOf(number);				
		}
		return answer;
	}

	public int getStudentId() {
		return _studentId;
	}
	
	
}
