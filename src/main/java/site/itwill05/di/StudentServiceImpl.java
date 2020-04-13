package site.itwill05.di;

import java.util.List;

//Impl : 개발자들끼리 인터페이스를 상속받는 클래스를 정할 때 사용

//Service 클래스 : 프로그램 작성에 필요한 기능을 제공하기 위한 클래스 - 모듈
//					=> DAO 클래스의 메소드를 호출하여 프로그램에 필요한 기능을 제공하는 메소드를 작성
//					=> Service 클래스가 변경되어도 프로그램(웹어플리케이션-모델)에 영향을 최소화 하기 위해 인터페이스를 상속받아 작성

//DAO클래스에 발생되는 오류 처리
// * 스프링프레임워크 : 컴퍼넌트들의 집합체  //  * 컴퍼넌트 : 모듈의 집합체
public class StudentServiceImpl implements StudentService {
	
//	★Service 클래스는 DAO클래스의 메소드 호출 이것이 핵심★ >> 객체 필요(인스턴스) >> 필드로 만들어줘야함(그래야 모든 메소드가 다 사용가능)
//	클래스로 만들어진 객체가 저장되어야 한다. => setter,getter / 생성자를 이용
//	StudentJdbcDAO 인스턴스를 저장하여 포함관계 설정(일반적인 association 관계)
	
//	필드값으로 StudentJdbcDAO 인스턴스를 저장하여 포함관계 설정
// 	=> 생성자 또는 Setter 메소드를 이용하여 인스턴스 저장 
//	private StudentJdbcDAO sutdentJdbcDAO;
//	private StudentMyBatisDAO studentMyBatisDAO;
	
	
	/*
//	필드의 클래스(자료형)이 변경될 경우 모든 생성자와 모든 메소드를 변경해야하는 불편함 => 영향력이 어마무시함
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO sutdentJdbcDAO) {
		super();
		this.sutdentJdbcDAO = sutdentJdbcDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}
	

	public StudentJdbcDAO getSutdentJdbcDAO() {
		return sutdentJdbcDAO;
	}


	public void setSutdentJdbcDAO(StudentJdbcDAO sutdentJdbcDAO) {
		this.sutdentJdbcDAO = sutdentJdbcDAO;
		System.out.println("*** StudentServiceImpl 클래스의 setSutdentJdbcDAO(StudentJdbcDAO sutdentJdbcDAO) 메소드 호출 ***");
	}


	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		sutdentJdbcDAO.insertStudent(student);
		
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return sutdentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return sutdentJdbcDAO.selectStudentList();
	}
*/	
	

//	부모 인터페이스로 선언하면 자식들을 모두 저장가능 
//	부모 인터페이스를 이용하여 참조필드 선언하면 모든 자식 인스턴스 저장
//	 => 자식 인스턴스가 변경될 경우 클래스에 미영향
	
//	인터페이스로 필드를 만들면 자식인스턴스가 저장 >> 생성자 , setter 이용 
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("*** StudentServiceImpl 클래스의 setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) 메소드 호출 ***");
		this.studentDAO = studentDAO;
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}


















