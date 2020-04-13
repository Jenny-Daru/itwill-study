package site.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//value 속성을 이용하여 beanName 설정 가능, 다른 속성과 같이 사용하지 않을 경우 생략가능
//@Component("studentService")

//@Service : Service클래스를 Spring Bean으로 등록하기 위한 어노테이션 
//			  => 종속된 어노테이션이 존재하므로 사용 (Controller어노테이션 - MVC에서 나중에 배움, 종속된 어노테이션)
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
//	@Resource : Spring Bean의 자동 Injection(DI)기능을 제공하기 위한 어노테이션
//				=> JDK 라이브러리에서 제공되는 어노테이션 - 특정 Framework에 종속되지 않는다.
//	@Resource
	
//	@Autowired : Spring Framework가 제공하는 어노테이션(Spring에서만 사용 가능)
//				  => Spring 라이브러리에서 제공하는 어노테이션, 다른 Framework에서 영향을 받지 않음
//				  => bean 에리먼트의 autowire 속성의 "byType" 속성값과 같은 방법으로 Injection
//				  => byType은 setter 메소드가 없으면 에러발생 , but Autowired는 setter 메소드를 선언하지 않아도 Setter Injection 가능
//				  => 생성자를 이용하여 Injection 불가능
	
//				  ★문제점★ 필드의 자료형이 인터페이스인 경우 자식클래스가 Spring Bean으로 여러개 등록되면 예외 발생
//					  해결1) 자식클래스가 Spring Bean으로 여러개 등록된 경우 "byName" 속성값과 같은 방법으로 Injection 처리
//							  => 자식클래스 중 하나의 beanName을 필드명과 동일한 이름으로 변경
//								 "byType"이 우선 적용 >> "byName" 적용 
//					  해결2) @Qualifier 어노테이션을 이용하여 Injection 처리할 Spring Bean 설정
//							 @Qualifier :value 속성에 beanName을 지정하여 SpringBean을 Injection 처리하는 어노테이션
//							  => 반드시!!! @Autowired어노테이션 사용 후 @Qualifier 작성 , @Autowired 어노테이션의 종속된 어노테이션
	
	@Autowired
//	@Qualifier(value = "studentJdbcDAO")
	@Qualifier(value = "studentMyBatisDAO")
	private StudentDAO studentDAO;

/*
//	♥서비스는 DAO 여러개 처리 하므로 필드마다 전부 @Autowired를 사용하여 Injection 처리♥ 
	@Autowired
	private StudentDAO studentDAO1;
*/
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl 클래스의 기본 생성자 호출 ###");
	}

	public AnnotationStudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### AnnotationStudentServiceImpl 클래스의 매개변수가 선언된 생성자 호출 ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) 메소드 호출 ***");
		this.studentDAO = studentDAO;
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 addStudent(Student student) 메소드 호출 ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudent(int num) 메소드 호출 ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl 클래스의 getStudentList() 메소드 호출 ***");
		return studentDAO.selectStudentList();
	}
}


















