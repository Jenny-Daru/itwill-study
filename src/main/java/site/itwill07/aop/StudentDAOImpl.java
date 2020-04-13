package site.itwill07.aop;

import java.util.List;

//핵심관심코드를 가지고 있는 모듈
//메소드 호출 =>  DB연동잘된거라고 봐도 무관

//핵심관심모듈 : 핵심관심코드가 작성된 메소드가 선언된 클래스

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl 클래스의 insertStudent(Student student)메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl 클래스의 selectStudent(int num)메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectListStudent() {
		System.out.println("*** StudentDAOImpl 클래스의 List<Student> selectListStudent()메소드 호출 ***");
		return null;
	}
	

}
