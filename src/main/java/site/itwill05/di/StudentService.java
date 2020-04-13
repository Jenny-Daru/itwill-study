package site.itwill05.di;

import java.util.List;

//학생정보에 대한 Service 클래스가 반드시 상속받아야 하는 인터페이스
//실제 어플리케이션이 가져다 사용하는 메소드
public interface StudentService {
	void addStudent(Student student);
	Student getStudent(int num);
	List<Student> getStudentList();
}
