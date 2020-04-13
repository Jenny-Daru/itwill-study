package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("============================================================");
		
//		05-1_di.xml에서 Spring Bean 인스턴스를 가져와 studetn1이라는 이름의 인스턴스를 Sutdent라는 클래스로 형변환해서 주세요~
		Student student1=context.getBean("student1", Student.class);
//		student1.setNum(num); //이래도 상관없지만 나중에 또 변경되었을시 다시 재설정해야하므로 귀찮.... 비권장함..
//		 => xml 에서 초기화 작업해라
		System.out.println(student1); 
		
		System.out.println("============================================================");
		
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2); 
		
		System.out.println("============================================================");
		
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3); 
		
		System.out.println("============================================================");
		
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4); 
		
		System.out.println("============================================================");
		
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("============================================================");
		
		/*
//		StudentServiceImpl studentserviceImpl=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
//		System.out.println(studentserviceImpl.getSutdentJdbcDAO());
		studentserviceImpl.addStudent(null);
		studentserviceImpl.getStudent(0);
		studentserviceImpl.getStudentList();
		*/
		
//		Service클래스로 참조변수를 만드는것이 더효율적 => 인터페이스
//		훗날 서비스가 바껴도 부모가 모든 자식을 다 저장 가능하지
		StudentService stuentService=context.getBean("studentService", StudentService.class);
		stuentService.addStudent(null);
		stuentService.getStudent(0);
		stuentService.getStudentList();		
		
		System.out.println("============================================================");
		
		((ClassPathXmlApplicationContext)context).close();
	}

}


















