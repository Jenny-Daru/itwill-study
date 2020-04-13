package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container를 이용하여 인스턴스를 제공받아 사용
// => 인스턴스 생성, 사용, 소멸 LifeCycle을 관리 
// => 개발자가 아닌 Spring Container가 인스턴스를 생성하여 제공 - IoC

// 우클릭 >> Spring Bean Configuration File(XML)을 이용하여 인스턴스 생성과 관계(의존)에 대한 설정
//  => src/main/resources 폴더안에 작성 (xml)
public class MessagePrintApp {
	public static void main(String[] args) {
		
		/*
		[IOC가 아닌 개발자가 직접 인스턴스 생성및 관계설정]
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
//		포함관계 설정
		print.setObject(object);
		print.messagePrint();
		*/
		
//		xml 생성 작성 후
//		ApplicationContext 인스턴스 생성 - Spring Container
//		 => Spring Bean Configuration File(XML)을 읽어 Spring Bean 생성
//		얘는 인터페이스라 인스턴스 생성못함!! 얘를 상속받는 자식들이 겁니 많음
//		ClassPath : 클래스가 접근 가능한 디렉토리 => src/main두개만 가능 
		ApplicationContext context = new ClassPathXmlApplicationContext("03_message.xml");
		
//		Spring Container로 부터 Spring Bean을 제공받아 저장
//		 => bean 엘리먼트의 고유값(messagePrint로 만들어진 엘리먼트를 주세요)을 전달하여 반환
//		Spring Container는 생성만 하는 것이아니라 필요한 것을 제공도 해줌
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
//		Spring Container 제거
		((ClassPathXmlApplicationContext)context).close();
		
		
	}

}





