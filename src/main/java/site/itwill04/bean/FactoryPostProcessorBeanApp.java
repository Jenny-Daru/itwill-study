package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactoryPostProcessorBeanApp {
	public static void main(String[] args) {
		System.out.println("======================= Spring Container 초기화 전 =======================");
		
//		파일을 읽어 스프링 컨테이너를 만들어줘 => 미리 빈 생성
		ApplicationContext context=new ClassPathXmlApplicationContext("04-3_beanFactory.xml");
		
		System.out.println("======================= Spring Container 초기화 후 =======================");
		
		FactoryPostProcessorBeanOne beanOne=(FactoryPostProcessorBeanOne)context.getBean("factoryPostProcessorBeanOne");
		beanOne.display();
		
		System.out.println("==========================================================================");

		FactoryPostProcessorBeanTwo beanTwo=(FactoryPostProcessorBeanTwo)context.getBean("factoryPostProcessorBeanTwo");
		beanTwo.display();
		
		System.out.println("==========================================================================");
		
		((ClassPathXmlApplicationContext)context).close();		
	}

}
