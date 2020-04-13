package site.itwill04.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//	@Configuration : 클래스를 Spring Bean으로 등록하는 기능을 제공하는 어노테이션
//					  => Bean Configuration File의 beans 엘리먼트와 유사한 기능 제공
@Configuration
public class AnnotationConfiguration {
//	@Bean : Spring Container에게 Spring Bean을 생성하여 반환하는 메소드를 제공하는 어노테이션 
//			 => Bean Configuration File의 bean 엘리먼트와 유사한 기능 제공
//			 => 메소드명이 자동으로 beanName으로 설정
//			 => name 어노테이션 속성을 이용하여 beanName 설정 가능
//	이메소드로 인스턴스 생성해서 관리좀 해조요~ 라고 부탁할 수 있다.
//	@(Bean = "") name값을 줄 수 있지만 안주면 annotationBean가 기본
	@Bean
	public AnnotationBean annotationBean() {
		return new AnnotationBean();
	}
	
	

}
