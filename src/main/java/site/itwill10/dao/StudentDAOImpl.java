package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAO클래스 : DBMS 서버에 SQL 명령(Mapper에 등록된)을 전달하여 실행하고 실행된 결과(JavaType)를 반환하는 기능의 메소드를 선언하는 클래스
//             => Spring Bean으로 만들어져야만 사용가능   1.Bean엘리먼트   2.어노테이션 => 프론트컨트롤러만 읽어들이는 xml파일에가서 어노테이션 읽어들이는 설정
//			
//@Repository : DAO관련 클래스를 Spring Bean으로 등록하는 어노테이션 / 종속된 어노테이션이 더 많기 때문에 @Component 보다 더 사용
@Repository
public class StudentDAOImpl implements StudentDAO {
	
//	@Autowired : 자동으로 인젝션 , setter 필요없고, 위에서 어노테이션 사용해서 인젝션 했으니 얘도 어노테이션으로 인젝션 해줘야함
//	SqlSession 관련 Spring Bean을 인젝션 처리하여 필드에 저장 => root-context.xml에 등록된 sqlsession 사용 가능 => 메소드 사용가능
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int insertStudent(Student student) {
//		추상메소드와 동기화 되어있는 메소드를 호출해서 처리하고 반환까지 해쥼
		return sqlsession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlsession.getMapper(StudentMapper.class).selectStudentList();
	}

}
