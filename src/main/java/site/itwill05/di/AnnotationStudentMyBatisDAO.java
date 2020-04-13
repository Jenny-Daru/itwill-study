package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Repository : DAO 클래스만! Spring Bean으로 등록하기 위한 어노테이션, 트랜젝션 관리에 대한 기능을 받을 수 있으므로 권장(Component는 못받음)
@Repository("studentMyBatisDAO")
public class AnnotationStudentMyBatisDAO implements StudentDAO {

	public AnnotationStudentMyBatisDAO() {
		System.out.println("### AnnotationStudentMyBatisDAO 클래스의 기본 생성자 호출 ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMyBatisDAO 클래스의 insertStudent() 메소드 호출 ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMyBatisDAO 클래스의 selectStudent() 메소드 호출 ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentMyBatisDAO 클래스의 selectStudentList() 메소드 호출 ***");
		return null;
	}

}
