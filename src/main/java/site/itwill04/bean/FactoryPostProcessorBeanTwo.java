package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//인스턴스의 필드를 만들때 name의 값을 저장하지 않아 name에는 null
//특별한 목적의 클래스 => 인터페이스, 클래스 상속받아 사용 가능 

//BeanFactoryPostProcessor 인터페이스를 상속받아 작성한 클래스
// => postProcessBeanFactory() 메소드 오버라이드 선언

// Spring Container에 의해 Spring Bean 생성 후 postProcessBeanFactory() 메소드 자동호출 => 초기화 작업
// : ConfigurableListableBeanFactory 인스턴스를 매개변수로 전달받아 getBean() 메소드로 다른 Spring Bean을 반환하여 초기화 작업
// : 다른 Spring Bean의 필드값을 현재 클래스의 필드값 변경
public class FactoryPostProcessorBeanTwo implements BeanFactoryPostProcessor {
	private String name;
	
	public FactoryPostProcessorBeanTwo() {
		System.out.println("★★★ FactoryPostProcessorBeanTwo 클래스의 기본 생성자 ★★★");
//		name="꿍다루";

	}
	
	public void display() {
		System.out.println("●●● FactoryPostProcessorBeanTwo 클래스의 display() 메소드 호출 ●●●");
		System.out.println("FactoryPostProcessorBeanTwo 클래스의 name 필드값 =  "+name);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("●●● FactoryPostProcessorBeanTwo 클래스의 postProcessBeanFactory() 메소드 호출 ●●●");
		FactoryPostProcessorBeanOne bean=(FactoryPostProcessorBeanOne)beanFactory.getBean("factoryPostProcessorBeanOne");
		name=bean.getName();
	}	
}











