package site.itwill07.aop;

import org.springframework.stereotype.Component;

//Ŭ�������� bean name(�⺻��) 
@Component(value = "aopBean")
public class AopAnnotationBean {
	public void display1() {
		System.out.println("*** AopAnnotationBean Ŭ������ display1()�޼ҵ� ȣ�� ***");
	}
	
	public void display2() {
		System.out.println("*** AopAnnotationBean Ŭ������ display2()�޼ҵ� ȣ�� ***");
	}
	
	public void display3() {
		System.out.println("*** AopAnnotationBean Ŭ������ display3()�޼ҵ� ȣ�� ***");
//		throw new RuntimeException();
	}

}