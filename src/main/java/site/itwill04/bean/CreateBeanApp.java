package site.itwill04.bean;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

// Spring Container로 부터 Spring Bean을 제공받아 사용하는 방법
// => Bean Configuration File(XML)의 bean 엘리먼트로 클래스를 Spring Bean으로 관리되도록(등록) 설정
@SuppressWarnings("deprecation")
public class CreateBeanApp {
	public static void main(String[] args) {
//		개발자가 직접 인스턴스 안만들거임
//		CreateBean bean=new CreateBean();
		
//		Bean Configuration file은 여러개 만들어서 사용하는 것을 권장
//		Bean Configuration file(XML) >> bean엘리먼트 필요
		
//		[방법1] ApplicationContext 이용
		System.out.println("[방법 1].ApplicationContext 인터페이스를 상속받은 클래스 이용]");
		
//		Bean Configuration file 읽기 전
		System.out.println("=============== Spring Container 초기화 전 ===============");
//		ApplicationContext : Spring Container 기능을 제공하기 위한 인스턴스
//							  => Bean Configuration File에 설정된 모든 bean 엘리먼트의 클래스를 Spring Bean으로 *미리* 생성하여 관리되도록 구현 
		ApplicationContext context=new ClassPathXmlApplicationContext("04-1_beanCreate.xml");
		
//		Bean Configuration file 읽은 후
		System.out.println("=============== Spring Container 초기화 후 ===============");
		
		
//		지금 가져다 사용
//		DL(Dependency Lookup) : 컨테이너에게 필요한 객체를 반환받는 방법
//		ApplicationContext.getBean(String beanName) : beanName을 이용하여 원하는 Spring Bean을 반환하는 메소드
//		 											   => Object 타입으로 반환하므로 객체 형변환을 하여 사용
//		 											   => beanName으로 검색되는 Spring Bean이 없는 경우 NoSuchBeanDefinitionException 발생
//		CreateBean bean=(CreateBean)context.getBean("createBean1");		
		CreateBean bean1=(CreateBean)context.getBean("createBean");		
		bean1.display();
		
//		ClassPathXmlApplicationContext.close() : ApplicationContext 인스턴스를 제거하는 메소드
//												 => 컨테이너에 의해 관리되는 모든 Spring Bean도 같이 제거
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("========================================================================================");
		
		
		
//		[방법2] BeanFactory인터페이스를 상속받는 클래스를 이용 - 가장 기본, 간단한 형태 => Spring 2.5부터는 이거 사용안함
//		         => 단순히 bean을 생성 
		System.out.println("[방법 2].BeanFactory 인터페이스를 상속받은 클래스 이용]");
		
		System.out.println("=============== Spring Container 초기화 전 ===============");
//		입력스트림을 사용해야한다.
//		BeanFactory : Spring  Container 기능을 제공하기 위한 인스턴스
//		    		  => Bean Configuration File을 읽어도 Spring Bean을 미리 생성하지 않음. 메모리 효율이 좋음(근데, 가독성이 더 좋아야함! 미리생성하는 방법1이 훨좋음)
		BeanFactory factory=new XmlBeanFactory(new FileSystemResource("src/main/resources/04-1_beanCreate.xml"));
		
		System.out.println("=============== Spring Container 초기화 후 ===============");
//		BeanFactory.getBean(String beanName) : beanName을 이용하여 Spring Bean을 미리 생성하여 반환하는 메소드
		CreateBean bean2=(CreateBean)factory.getBean("createBean");
		bean2.display();
		
		
	}

}


















