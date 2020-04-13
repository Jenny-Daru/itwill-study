package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//횡단관심모듈 : 횡단관심코드로 작성된 메소드가 선언된 클래스 - Advice 클래스(핵심관심에 삽입되어야 Advice 클래스라 불리움)
public class StudentAdvice {
	
//	기록은 Log4j이용
//	어떤클래스에 대한 정보를 기록할거니? StudentAdvice요!
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
//	before 메소드 : target메소드 실행 전 삽입될 코드를 작성하기 위한 메소드
	public void beforeLog() {
		logger.info("[before]핵심관심코드 실행전 삽입되어 동작되는 횡단관심코드");
	}
	
//	무언가가 일어나야 고칠수 있기 때문에 개발자들에게 아주 중요하고, 꼭 만들기를 권장하며 더 나은 버전으로 업데이트 가능
//	프로그램 실행시 예외가 발생 >> 예외처리 사용(try~catch~finally)과 같은 역할을 한다
//	afterReturning : try , 사용자입장에서 중요(LogFile)
//	 afterThrowing : catch
//	         after : finally

//	afterReturning 메소드 : target메소드의 정상적인 실행 후 삽입될 코드를 작성하기 위한 메소드
	public void afterReturningLog() {
		logger.info("[after-returning]핵심관심코드의 정상적인 실행 후(try) 삽입되어 동작되는 횡단관심코드");
	}
	
//	afterThrowing 메소드 : target메소드 실행시 예외가 발생된 경우 삽입될 코드를 작성하기 위한 메소드
	public void afterThrowingLog() {
		logger.info("[after-throwing]핵심관심코드 실행시 예외가(catch) 발생된 경우 삽입되어 동작되는 횡단관심코드");
	}	
	
//	after 메소드 : target메소드 실행 후 삽입될 코드를 작성하기 위한 메소드
	public void afterLog() {
		logger.info("[after]핵심관심코드 실행 후 무조건(finally) 삽입되어 동작되는 횡단관심코드");
	}
	
//	JoinPoint : arround >> 반환형 void 사용불가, Object사용 권장 >> 매개변수 ProceedingJoinPoint 선언
	
//	Around Advice 메소드 : target메소드 실행 전 또는 실행 후 삽입될 코드를 작성하기 위한 메소드
//						   반환형 => Object 타입 // ★매개변수(필수)★ => ProceedingJoinPoint 타입으로 선언 // Throwable예외(예외의 부모) 발생 - 프로그램에서 발생하는 모든 오류 처리
//							>>  WHY?? 타겟메소드가 반환하는 자료형이 뭔지 모르기 때문
//	 ProceedingJoinPoint : target메소드에 대한 정보를 저장하는 인스턴스
//						   Spring Container에 의해 인스턴스를 전달받아 매개변수에 자동 저장
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
//		스프링컨테이너(Aspect)가 호출해쥬는게 아니고 개발자가 매개변수를 이용하여 target메소드를 호출해야해 
		logger.info("[arround]핵심관심코드 실행 전에 삽입되어 동작되는 횡단관심코드");
		
//		target메소드 호출(ProceedingJoinPoint가 호출)
//		ProceedingJoinPoint.proceed() : target메소드를 호출하는 메소드
//										target메소드의 반환값을 제공받아 저장  >> 저장값 반환
//										target메소드에서 발생되는 예외 처리    >> target메소드도 모르는데 어떤 예외가 발생하는지도 모름~ 떠넘겨 throw처리
		Object object=joinPoint.proceed();
		
		logger.info("[arround]핵심관심코드 실행 후에 삽입되어 동작되는 횡단관심코드");
		
		return object;
	}
}

















