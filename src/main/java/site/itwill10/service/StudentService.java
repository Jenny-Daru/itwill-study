package site.itwill10.service;

import java.util.List;

import site.itwill10.dto.Student;

public interface StudentService {
	void addstudent(Student student);
	
	List<Student> getStudentList();
}
