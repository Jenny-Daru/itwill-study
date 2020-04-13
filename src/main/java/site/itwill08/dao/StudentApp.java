package site.itwill08.dao;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		System.out.println("==========================================================================");
		
//		자식은 부모한테 저장시킬수 있다. >> 나중에 service가 바껴도 영향이 덜주니까 이렇게 하는게 좋움
		StudentService service=context.getBean("studentService", StudentService.class);
		/*
		Student student=new Student();
		student.setNo(6000);
		student.setName("서쪼딩");
		student.setPhone("010-6666-6666");
		student.setAddress("헬뜨쟝");
		student.setBirthday("2020-02-18");
		service.addStudent(student);
		*/
		
		Student student=service.getStudent(2000);
		student.setBirthday("1989-12-22");
		service.modifyStudent(student);
		
//		service.removeStudent(4000);
		
		List<Student> studentList=service.getStudentList();
		for(Student stu:studentList) {
			System.out.println(stu.getNo()+", "+stu.getName()+", "+stu.getPhone()+", "+stu.getAddress()+", "+stu.getBirthday().substring(0,10));
		}

		System.out.println("==========================================================================");

		((ClassPathXmlApplicationContext)context).close();
	}
}
