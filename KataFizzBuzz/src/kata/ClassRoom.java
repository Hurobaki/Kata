package kata;

import java.util.Vector;

public class ClassRoom {
	
	private Teacher _teacher;
	private Vector<Student> _students;
	

	public ClassRoom(int numberOfStudent)
	{
		_teacher = new Teacher(this);
		_students = new Vector<Student>();
		populateStudents(numberOfStudent);
	}

	private void populateStudents(int numberOfStudent)
	{
		for (int studentId = 1; studentId <= numberOfStudent; studentId++) {
			_students.add(new Student(studentId));
		}
	}

	public Student getStudent(int studentIndex)
	{
		return _students.get(studentIndex % _students.size());
	}
	
	public void teacherAsking()
	{
		_teacher.ask();
	}
}