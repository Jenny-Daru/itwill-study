package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//이메일 전송관련 메세지(기록) 기능을 제공하는 클래스 - 횡단관심모듈
public class EmailSendAdvice {
//	이메일 전송전(핵심관심코드실행 전)에 실행될 기능을 구현한 메소드 - Before Advice 메소드
//	 => target메소드의 매개변수값을 JoinPoint 인스턴스로 제공받아 메세지 처리
	public void beforeMessage(JoinPoint joinPoint) {
// 		target메소드에 대한 정보를 가져욤 => JoinPoint, target메소드에 대한 정보는 매개변수가 가지고있움		
//		target메소드의 첫번째 매개변수의 값을 가져와 저장 
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		
//		원래 Logger이용해야하눈데 걍 sys이용
//		~ 님에게(받는사람 이메일주소) 제목을 전송하께요 라고 남기고싶다. 
		System.out.println("[Message]<"+email+">님에게! <"+subject+">제목의 이메일을 전송하께요오.");
	}
	
	
//	이메일 전송이 성공한 경우 실행될 기능을 구현한 메소드 - After-Returning 메소드 
//	 => target메소드의 반환값을 매개변수(xml의 returning속성값)로 제공받아 메세지 처리
	public void successMessage(String email) {
//		방법 1) Joinpoint를 이용하여 target메소드의 정보를 가져오기
//		방법 2) 받는 사람의 이메일주소를 반환하게 만들었기 때문에 매개변수에 저장되게 하기 
		System.out.println("[Message]<"+email+">님에게 이메일이 잘갔대요오.");
		
	}
	
	
//	이메일 전송이 실패한 경우 실행될 기능을 구현한 메소드 - After-Throwing 메소드
//	 => target메소드에서 발생된 예외 인스턴스를 매개변수로 제공받아 메세지 처리
	public void failMessage(Exception exception) {
//		예외처리 명령
		System.out.println("[Error]이메일 전송실패에욤...WHY??"+exception.getMessage());
		
	}

}








