package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect : Spring Bean으로 등록된 클래스에 Aspect 기능을 제공하기 위한 어노테이션 >> 얘가 있어야 종속된 어노테이션으로 기능 구현
//           => Bean Configuration File의 aspect 엘리먼트와 유사한 역할을 수행
@Aspect
public class AopAnnotationAdvice {
	private static final Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class);
	
//	@Pointcut : PointCut을 설정하기 위한 어노테이션  >> 다른 클래스에 설정하여도 무방해! 
//				 => Bean Configuration File의 pointCut 엘리먼트와 유사한 역할을 수행	
//	     		 => pointCut 설정에 대한 재사용을 위해 설정
//				 => 메소드명과 매개변수가 PointCut 고유값으로 인식되어 메소드 호출 형태로 PointCut 고유값 사용
//				 => 다른 클래스에 PointCut설정도 가능
	
//	value속성 : PointCut지정을 위한 정보(execution,within)를 속성값으로 설정
//				=> 다른 속성이 없는 경우 속성값만 설정 가능
	@Pointcut("within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
//	Aspect 기능을 제공
//	@Before : Before Advice메소드를 설정하는 어노테이션
//			   => Bean Configuration File의 before 엘리먼트와 유사한 역할 수행
//	value속성 : PointCut지정을 위한 정보(execution,within)를 속성값으로 설정
//	 			=> value속성값으로 @Pointcut 어노테이션의 메소드를 호출하여 사용
//	@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		logger.info("[Before]핵심관심코드 실행 전 삽입되어 실행되는 횡단관심코드");
	}
	
//	@AfterReturning : afterRrturining Advice메소드를 설정하는 어노테이션
//			          => Bean Configuration File의 afterRrturining 엘리먼트와 유사한 역할 수행
//				      => value속성값 대신 pointcut 속성 사용 가능 
//	returning 속성 : target메소드의 반환값을 저장하기 위한 매개변수명을 속성값으로 설정
	@AfterReturning(pointcut = "aopPointCut()", returning = "object")
	public void afterRrturiningLog(Object object) {
		logger.info("[AfterRrturiningLog]핵심관심코드 정상 실행 후 삽입되어 실행되는 횡단관심코드");
		
	}
	
//	@AfterThrowing : AfterThrowing Advice메소드를 설정하는 어노테이션
//			          => Bean Configuration File의 AfterThrowing 엘리먼트와 유사한 역할 수행
//				      => value속성값 대신 pointcut 속성 사용 가능 
//	throwing 속성 : target메소드의 반환값을 저장하기 위한 매개변수명을 속성값으로 설정
//	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[AfterThrowing]핵심관심코드에서 예외 발생 후 삽입되어 실행되는 횡단관심코드");
		
	}
	
//	@After : After Advice메소드를 설정하는 어노테이션
//    => Bean Configuration File의 After 엘리먼트와 유사한 역할 수행
//	@After(pointcut = "aopPointCut()", throwing = "exception")
	@After("aopPointCut()")
	public void afterLog() {
	logger.info("[After]핵심관심코드 실행 후 삽입되어 실행되는 횡단관심코드");
	
	}
	
//	@@Around : Around Advice메소드를 설정하는 어노테이션
//  => Bean Configuration File의 Around 엘리먼트와 유사한 역할 수행
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
	logger.info("[Around]핵심관심코드 실행 전 삽입되어 실행되는 횡단관심코드");
	
	Object object=joinPoint.proceed(); 
	
	logger.info("[Around]핵심관심코드 실행 후 삽입되어 실행되는 횡단관심코드");
	
	return object;
	
	}	

}











