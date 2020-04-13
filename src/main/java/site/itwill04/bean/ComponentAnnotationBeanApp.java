package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ComponentAnnotationBeanApp {
	public static void main(String[] args) {
		System.out.println("======================= Spring Container 초기화 전 =======================");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-6_beanAnnotation.xml");
		
		System.out.println("======================= Spring Container 초기화 후 =======================");	
		
		ComponentAnnotationBean bean=context.getBean("cab",ComponentAnnotationBean.class);
		bean.display();
	
		System.out.println("==========================================================================");	

		((ClassPathXmlApplicationContext)context).close();				
	}

}
