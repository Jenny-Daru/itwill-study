package site.itwill08.dao;

import java.util.List;

//실질적으로 어플리케이션들이 제공해쥬는 기능을 만드는 곳 
// 핵심 => DAO클래스의 메소드를 호출 => DAO클래스의 인스턴스를 필드로 생성 => Injection 

public class StudentServiceImpl implements StudentService {
//	Bean Configuration File에서 SutdentDAO관련 Spring Bean을 필드에 Injection 처리 
//	 => Injection 처리된 StudentDAO 인터페이스의 자식 클래스 메소드 호출 가능, Injection처리 안되었다면 NullPointException 발생!
//	 => 필드의 자료형을 인터페이스로 선언하면 Injection된 DAO클래스의 Spring Bean이 변경되어도 소스 미변경
//	 => 필드의 자료형이 인터페이스가 아니고 클래스일 경우 Injection된 Spring Bean을 변경할 시 필드도 변경해야함 >> 불편
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
