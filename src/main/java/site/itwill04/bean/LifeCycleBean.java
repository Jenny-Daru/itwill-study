package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class LifeCycleBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
										ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware,
										InitializingBean, DisposableBean {
	public LifeCycleBean() {
		System.out.println("★★★ LifeCycleBean 클래스의 기본 생성자 호출 ★★★");
	}
	
	public void display() {
		System.out.println("●●● LifeCycleBean 클래스의 display() 메소드 호출 ●●●");
	}

	@Override
//	초기화 작업을 위해 컨테이너가 자동호출(매개변수에는 BeanName값이 들어감)
	public void setBeanName(String name) {
//		XML에 존재하는 BeanName을 가져와 변경
		System.out.println("★★★ LifeCycleBean 클래스의 setBeanName 메소드 호출 ★★★");
//		System.out.println("name = "+name);
		
		
	}

	@Override
	//  클래스 로더를 매개변수를 통해 가져옴
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("★★★ LifeCycleBean 클래스의 setBeanClassLoader 메소드 호출 ★★★");
		
	}

	@Override
	//스프링빈을 만들어주는 인스턴스
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("★★★ LifeCycleBean 클래스의 setBeanFactory 메소드 호출 ★★★");
		
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("★★★ LifeCycleBean 클래스의 setResourceLoader 메소드 호출 ★★★");
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("★★★ LifeCycleBean 클래스의 setApplicationEventPublisher 메소드 호출 ★★★");
		
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("★★★ LifeCycleBean 클래스의 setMessageSource 메소드 호출 ★★★");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("★★★ LifeCycleBean 클래스의 setApplicationContext 메소드 호출 ★★★");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("★★★ LifeCycleBean 클래스의 afterPropertiesSet 메소드 호출 ★★★");
		
	}
	
//	3/24 시작
	public void initMethod() {
		System.out.println("★★★ LifeCycleBean 클래스의 initMethod 메소드 호출 ★★★");
		
	}

//	스프링 컨테이너가 제거되면 제거되기전 가지고 있는 모든 스프링 빈을 소멸하는데 그전에 마무리작업을 얘가해줌
	@Override
	public void destroy() throws Exception {
		System.out.println("★★★ LifeCycleBean 클래스의 destroy 메소드 호출 ★★★");
		
	}

	public void destroyMethod() throws Exception {
		System.out.println("★★★ LifeCycleBean 클래스의 destroyMethod 메소드 호출 ★★★");
		
	}


}












