package site.itwill07.aop;

import org.springframework.stereotype.Component;

//클래스명이 bean name(기본값) 
@Component(value = "aopBean")
public class AopAnnotationBean {
	public void display1() {
		System.out.println("*** AopAnnotationBean 클래스의 display1()메소드 호출 ***");
	}
	
	public void display2() {
		System.out.println("*** AopAnnotationBean 클래스의 display2()메소드 호출 ***");
	}
	
	public void display3() {
		System.out.println("*** AopAnnotationBean 클래스의 display3()메소드 호출 ***");
//		throw new RuntimeException();
	}

}
