package site.itwill04.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component : 클래스를 Spring Bean으로 등록하는 어노테이션
//              => 클래스명이 자동으로 beanName으로 설정 - 첫문자는 소문자로 변환
//			 : value 어노테이션 속성값으로 beanName 설정 가능
//				=> 다른 속성을 선언하지 않을 경우 value 키워드 생략 가능 => beanName이 변경 되었으니 cab로 가져다 사용
// bean 엘리먼트의 속성과 유사한 기능을 제공하는 어노테이션 - @Lazy, @Scope

//[@Component를 잘 사용하지 않고, @Component를 상속받는 다른 자식 어노테이션들을 많이 사용]
//@Repository(DAO), @Service(Service) , @Controller(Controller), => Component를 상속받는 어노테이션 
@Lazy
@Component(value = "cab")
public class ComponentAnnotationBean {

	public ComponentAnnotationBean() {
		System.out.println("★★★ ComponentAnnotationBean 클래스의 기본 생성자 호출 ★★★");
	}
	
	public void display() {
		System.out.println("●●● ComponentAnnotationBean 클래스의 display() 메소드 호출 ●●●");
	}
	
}
