package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanAttributeApp {
	public static void main(String[] args) {
		System.out.println("======================= Spring Container 초기화 전 =======================");
		
		ApplicationContext context=new ClassPathXmlApplicationContext("04-5_beanAttribute.xml");
		
		System.out.println("======================= Spring Container 초기화 후 =======================");
//		ApplicationContext.getBean(String beanName) 오버로드된 메소드들이 아쥬아쥬 많다~~
//		ApplicationContext.getBean(String beanName) : Object 타입의 Spring Bean을 반환하는 메소드
//													   => Object 타입을 반환 하므로 객체형변환(개발자가 직접!)을 이용해야만 자식인스턴스의 메소드 호출
//		InitDestroyMethodBean bean=(InitDestroyMethodBean) context.getBean("initDestroyMethodBean");
		
//		★ 권장 ★ 가독성인 측면을 보았을 때 더 뛰어남.
//		ApplicationContext.getBean(String beanName, Class<T> clazz) : 자식 인스턴스 타입으로 형변환된 Spring Bean을 반환하는 메소드
//		 															   => Object타입으로 주지말고 형변환 해서줘!! // 메모리(Static)에 저장되어있는 클래스 표현 방법 
		InitDestroyMethodBean bean=(InitDestroyMethodBean) context.getBean("initDestroyMethodBean",InitDestroyMethodBean.class);
		
//		bean.init();
		bean.display();
//		bean.destroy();

		System.out.println("==========================================================================");	
		
		context.getBean("lazyInitBean",LazyInitBean.class);
		
		System.out.println("==========================================================================");	
		
//		여러번 호출하여도 스프링빈이 인스턴스를 하나만 생성 (lazy-init 속성 true로 인하여)
		ScopeBean bean1=context.getBean("singletonBean",ScopeBean.class);
		ScopeBean bean2=context.getBean("singletonBean",ScopeBean.class);
		ScopeBean bean3=context.getBean("singletonBean",ScopeBean.class);
		
		System.out.println("bean1 = "+bean1);
		System.out.println("bean2 = "+bean2);
		System.out.println("bean3 = "+bean3);
		
		System.out.println("==========================================================================");	
		
		ScopeBean bean4=context.getBean("prototypeBean",ScopeBean.class);
		ScopeBean bean5=context.getBean("prototypeBean",ScopeBean.class);
		ScopeBean bean6=context.getBean("prototypeBean",ScopeBean.class);
		
		System.out.println("bean4 = "+bean4);
		System.out.println("bean5 = "+bean5);
		System.out.println("bean6 = "+bean6);

		((ClassPathXmlApplicationContext)context).close();		

	}

}





