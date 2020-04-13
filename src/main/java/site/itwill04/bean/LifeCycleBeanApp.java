package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container는 Spring Bean의 생성, 사용, 소멸에 대한 생명주기(LifeCycle)를 관리
// => 생성자를 만드는 것이 필드의 초기화 작업이 편리

// [ Spring Bean 생성에 대한 초기화 작업 순서 ]
// 1. 생성자(Constructor) 호출 : 인스턴스를 생성할 때 XML 파일로부터 인스턴스(값)를 전달받아 필드값 변경 가능 
//                               가장 보편적 => Constructor Injection ★ 중요  ★

// 2.       Setter 메소드 호출 : 인스턴스를 생성후 XML 파일로부터 인스턴스(값)를 전달받아 필드값 변경 가능  => Setter Injection
//                               인스턴스가 만들어지자마자 컨터이너는 setter 메소드 호출함 (무조건은 아님) ★ 중요  ★

// 3. BeanNameAware 인터페이스를 상속받아 인터페이스의 setBeanName() 메소드 호출 
//	   : 인스턴스 생성 후 컨테이너에게 BeanName을 제공받아 필드값 변경

// 4. BeanClassLoaderAware 인터페이스의 setBeanClassLoader() 메소드 호출 
//     : 인스턴스 생성 후 컨테이너에게 BeanClassLoader 인스턴스를 제공받아 필드값 변경

// 5. BeanFactoryAware 인터페이스의 setBeanFactory() 메소드 호출
//     : 인스턴스 생성 후 컨테이너에게 BeanFactory 인스턴스를 제공받아 필드값 변경

// 6. ResourceLoaderAware 인터페이스의 setResourceLoader() 메소드 호출
//	   : 인스턴스 생성 후 컨테이너에게 BeanFactory 인스턴스를 제공받아 필드값 변경

// 7. ApplicationEventPublisherAware 인터페이스의 setApplicationEventPublisher() 메소드 호출
//     : 인스턴스 생성 후 컨테이너에게 ApplicationEventPublisher 인스턴스를 제공받아 필드값 변경

// 8. MessageSourceAware 인터페이스의 setMessageSource() 메소드 호출
//	   : 인스턴스 생성 후 컨테이너에게 MessageSource 인스턴스를 제공받아 필드값 변경

// 9. ApplicationContextAware 인터페이스의 setApplicationContext() 메소드 호출 
//     : 인스턴스 생성 후 컨테이너에게 ApplicationContext 인스턴스를 제공받아 필드값 변경
//        => ★ 중요  ★ - 웹에서 사용(request/response 사용하지 않고 얘 사용함!얘한테 모든걸 달라하면됨
//                         스프링에서 파일의 경로 찾을때 사용 

// 10와13은 클래스 다시 만들어야함 => postProcessorBean.java
// 10. BeanPostProcessor 인터페이스의 postProcessBeforeInitialization() 메소드 호출
//		: 인스턴스 생성 후 컨테이너에게 MessageSource 인스턴스를 제공받아 필드값 변경

// 11. InitializingBean 인터페이스의 afterPropertiesSet() 메소드 호출
//     : 인스턴스 생성 후 Properties(key,value저장/이름과 값) 파일을 읽어 필드값 변경

// 12. bean 엘리먼트의 init-method 속성값으로 설정된 메소드 호출

// 13. BeanPostProcessor 인터페이스의 postProcessAfterInitialization() 메소드 호출
//      : 인스턴스 생성 후 컨테이너에게 MessageSource 인스턴스를 제공받아 필드값 변경

//Spring Bean 소멸에 대한 마무리 작업 순서
// 1. DisposableBean 인터페이스의 destroy() 메소드 호출
// 2. bean 엘리먼트의 destroy-method 속성값으로 설정된 메소드 호출

public class LifeCycleBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container 초기화 전 ===============");
		
//		여기에 스프링 컨테이너 만들거임 , xml 파일 읽어 들일거임 
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanLifeCycle.xml");
		
		System.out.println("=============== Spring Container 초기화 후 ===============");

//		메소드 호출할거
		LifeCycleBean bean=(LifeCycleBean)context.getBean("lifeCycleBean");
		bean.display();
		System.out.println("=============== Spring Container 마무리 전 ===============");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("=============== Spring Container 마무리 후 ===============");

	}

}
