package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//타이머기능 
public class ExecutionTimeApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-4_timer.xml");
		
		System.out.println("======================================================================================================================");	
		
		ExecutionTimeBean bean=context.getBean("executionTimeBean", ExecutionTimeBean.class);
//		run메소드가 실행될때 도대체 얼마나 걸렸눈지 알아보는 프로그램 만둘기
		bean.run();
		
		System.out.println("======================================================================================================================");	
		
		((ClassPathXmlApplicationContext)context).close();			
	}
}
