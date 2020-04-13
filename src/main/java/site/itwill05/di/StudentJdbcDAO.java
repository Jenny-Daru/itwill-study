package site.itwill05.di;

import java.util.List;

//DAO클래스 : 저장매체[DataSource - DBMS(오라클)]에게 정보에 대한 삽입, 변경, 삭제, 검색 기능을 제공하는 클래스
//	 		   => 메소드를 제공
//			   => 저장매체의 종류 또는 방법에 따라 여러 개의 DAO 클래스 존재
//			   => 프로그램에서 사용하는 DAO클래스가 변경될 수 있기 때문에 DAO 클래스가 변경되어도 다른 클래스(Service)에 영향을 최소화 하기 위해 인터페이스를 상속받아 작성 ★권장★

// 어플리케이션은 Service메소드 호출 => Service클래스의 메소드는 DAO클래스의 메소드호출 
public class StudentJdbcDAO implements StudentDAO {
	
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO 클래스의 기본 생성자 호출 ###");
	}

	@Override
	public int insertStudent(Student student) {
		System.out.println("★★★ StudentJdbcDAO 클래스의 insertStudent() 메소드 호출 ★★★");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("★★★ StudentJdbcDAO 클래스의 selectStudent() 메소드 호출 ★★★");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("★★★ StudentJdbcDAO 클래스의 selectStudentList() 메소드 호출 ★★★");
		return null;
	}



}
