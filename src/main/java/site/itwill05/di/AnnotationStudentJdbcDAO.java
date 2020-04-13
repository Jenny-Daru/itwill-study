package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//				=> 기본적으로 클래스명이 beanName이 설정되지만 value 속성을 이용하여 beanName 변경 가능
//				=> value 속성 생략가능
//@Component("studentDAO") => DAO클래스는 Component 사용하지 않음!!

//@Repository : DAO 클래스만! Spring Bean으로 등록하기 위한 어노테이션, 트랜젝션 관리에 대한 기능을 받을 수 있으므로 권장(Component는 못받음)
//				=> 기본적인 것은 똑같지만, 이 어노테이션에 종속된 어노테이션이 더 많음!! 메소드에 다양한 어노테이션을 더 제공
//				=> Component : 부모 , Repository : 자식 
@Repository("studentJdbcDAO")
public class AnnotationStudentJdbcDAO implements StudentDAO {
	private StudentDAO studentDAO;
	
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO의 insertStudent(Student student)메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO의 selectStudent(int num)메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO의 List<Student> selectStudentList()메소드 호출 ***");
		return null;
	}

}
