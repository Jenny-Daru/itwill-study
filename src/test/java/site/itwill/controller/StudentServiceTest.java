package site.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//테스트 클래스에서는 단위 프로그램(Service클래스)을 검사하기 위한 목적으로 작성

// Service클래스나 DAO관련 Spring Bean이 어디에 있는지 Bean Configuration File을 찾아 읽어들이기 
//  => 어노테이션 관련 Bean Configuration File은 하나만 가능 
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebApplicationContext 객체(Spring Container)를 이용하여 Spring Bean을 관리하도록 설정하는 어노테이션
//						  => Spring Container를 기본적으로 어플리케이션 컨텍스트를 이용하지만 이걸 사용하면 웹어플리케이션 컨텍스트 가능 
//   				     ★★★웹관련 자원이나 컨트롤러 테스트 하기위해서는 꼬옥 이 어노테이션 사용★★★
//  					
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentServiceTest.class);
	
//	SutdnetService 메소드를 테스트하고 싶음 => 메소드를 호출하기 위해 서비스 메소드 저장가능한 필드 선언 => 인젝션하기 
	@Autowired
	private StudentService studentService;
	
//	사용자에게 입력받는것이 아니고 직접 setter메소드 호출하여 확인 
	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setNo(9000);
		student.setName("융사자");
		student.setPhone("010-8888-8888");
		student.setAddress("깊은산골짜기 동굴");
		student.setBirthday("1000-10-10");
		studentService.addstudent(student);
		logger.info("학생정보 추가 관련 기능 구현 성공!");
	}
	
	@Test
	public void testgetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		for(Student student:studentList) {
			/*
			logger.info(student.getNo()+","+student.getName()+", "+student.getPhone()
							+", "+student.getAddress()+", "+student.getBirthday().substring(0, 10));
			 */
			logger.info(student.toString());
		}
		
		
	}
		

}















