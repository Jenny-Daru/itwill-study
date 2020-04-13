package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//advice메소드 
public class JoinPointAdvice {
//	[ JoinPoint ] 
	
//	Around Advice 메소드 반환형 => Object 타입으로 선언, ProceedingJoinPoint 매개변수를 이용하여 메소드 선언
//								=> target메소드에서 발생되는 예외를 Throwable 타입으로 제공하여 예외 처리     >>  Proceeding를 호출할 때 발생되는 예외이기 때문  
	
//	Before, After, After-Returning, After-Throwing의 Advice메소드 반환형 => void, 매개변수 없이 선언
//	=> JoinPoint의 Advice메소드에 따라 다른 자료형의 매개변수를 선언 
//	=> Around Advice메소드를 제외한 다른 Advice 메소드는 ★JoinPoint 자료형의 매개변수를 선언★
//	=> 선언된 매개변수에는 Spring Container에 의해 인스턴스가 자동 저장
	
//	JoinPoint : 타겟 메소드의 정보를 저장하는 인스턴스
//				=> Advice 메소드에서 target메소드 정보를 이용하여 횡단관심코드 작성
//				=> ProceedingJoinPoint 인스턴스는 target메소드 호출 가능
	
//	Before Advice 메소드
//	joinPoint 매개변수에 target메소드에 대한 정보 저장 => 횡단관심코드 메소드에서 사용, 정보만 가져다 사용하는거!!!
//	횡단관심코드에서 핵심관심코드의 target메소드 정보를 가져다 사용한다면 JoinPoint사용 
	public void displayTarget(JoinPoint joinPoint) {
		/*
//		★ 어떤클래스에서 어떤메소드를 호출할 때 어떤 예외가 발생했는지 알려면 JoinPoint 사용해야해 ★
//		System.out.println("[before]핵심관심코드 실행 전에 삽입되어 동작될 ★횡단★관심코드");
		
//		JoinPoint.getTarget() : Object반환, target메소드를 호출하는 핵심관심모듈(인스턴스)를 반환메소드  >> target메소드는 JoinPoint가 호출하고 있다. App에서
//		    Object.getClass() : 핵심관심모듈(인스턴스)의 클래스(Clazz)를 반환하는 메소드
//		      Class.getName() : 클래스(Clazz)의 패키지를 포함한 클래스명을 반환하는 메소드
//		target메소드가 선언된 클래스가 누구니???
//		System.out.println(joinPoint.getTarget().getClass().getName());
		String className=joinPoint.getTarget().getClass().getSimpleName();
		
//		JoinPoint.getSignature() : target메소드의 정보(Signature인스턴스)를 반환하는 메소드
//		Signature.getName() : target메소드의 이름을 반환하는 메소드
		String methodName=joinPoint.getSignature().getName();
		System.out.println("[before]"+className+"클래스의 "+methodName+" 메소드 호출이욤");
		*/
		
//		joinPoint.getArgs() : target메소드의 매개변수를 Object 배열로 반환하는 메소드 >> target메소드의 자료형과 메소드 갯수르 모르니 Object배열로 받아줘야해
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] objects=joinPoint.getArgs();
//		타겟메소드에 대한 정보를 가져와 횡단관심모듈에서 사용하려고 사용한다!!! >> 매개변수의 전달된 값을 이용하여 유효성검사 가능 
		System.out.println("[before]"+className+"클래스의 "+methodName+" 메소드의 매개변수 갯수 = "+objects.length);
		
	}
	
//	After Returning Advice 메소드 => 정상적으로 실행될 때 동작되는 메소드
//	로그,기록할 경우에 많이 사용
//	 => Object 타입의 매개변수를 선언하여 target메소드의 반환값을 전달받아 저장
//	 => target메소드의 반환형을 지정하지 않은 경우 매개변수를 Object 타입으로 설정
	public void displayName(Object object) {
//		System.out.println("[after-returning]핵심관심코드 정상 실행 후 삽입될 횡단관심코드");
		
//		[핵심관심코드의 반환값을 횡단관심코드가 전달받아 사용하는 경우]
//		반환받은 값이 문자열인 경우 >> 반환받은 값 문자열로 변환하여 저장
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"님, 방가욤♥");
		}
	}
	
//	After Throwing Advice 메소드
//	예외처리를 위해 많이 사용(사용자/개발자)
//	 => 매개변수를 선언하여 target메소드의 예외정보를 전달받아 저장
//	 => target메소드의 예외를 지정하지 않은 경우 매개변수를 Exception 타입으로 설정
	public void displayException(Exception exception) {
//		System.out.println("[after-Throwing]핵심관심코드 실행 시 예외가 발생될 경우 삽입되어 동잘될 횡단관심코드");
//		어떤클래스의 어떤메소드에서 어떤예외가 발생되었는지 보여쥬는게 더좋아 => JoinPoint사용해야하는데 어떤예외는 JoinPoint가 몰라요
//		 => target메소드가 어떤 예외가 발생할지 광범위하니까 exception 사용 >> 코드가 실행되지않고 예외발생 >> exception은 Container가 전달못해쥬니까 
//		     >> xml의 aop엘리먼트에서 throwing속성 사용하여 어떤매개변수에 저장해 주세요~ 설정  
		System.out.println("[after-Throwing] 예외메세지♥ =>"+exception.getMessage());
		
		
	}
	
	
}















