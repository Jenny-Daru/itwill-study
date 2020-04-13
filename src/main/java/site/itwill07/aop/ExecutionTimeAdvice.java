package site.itwill07.aop;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

//횡단관심코드를 가지고 있는 Advice클래스
public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
//	target메소드의 명령이 실행되는 처리시간(m)을 계산하여 기록하기 위한 메소드 >> target메소드 실행전과 실행후의 명령을 계산해야함
//	 => Around Advice메소드
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
//		run메소드 호출전 시간 측정  / target메소드 실행후 시간 측정 => TimeStamp 시간 활용 => 기록은 logger
//		핵심관심코드가 실행되도록 등록 후 처리 
		
//		target메소드의 명령 실행 전 시스템의 현재 시간정보(TimeStamp)를 반환받아 저장
//		1)Date클래스 
//		2)currenctTime클래스
		
		/*
//		방법 1) Java에서 제공하는 System클래스 사용 
		long startTime=System.currentTimeMillis();
		
//		target메소드의 명령 실행
		Object object=joinPoint.proceed();
		
//		target메소드 실행 후 시스템의 현재 시간정보(StopStamp)를 반환받아 저장
		long stopTime=System.currentTimeMillis();
		
		logger.info("실행시간 = "+(stopTime-startTime)+"ms 걸려찌요!");
		
		return object;
		*/
		
//		방법 2) SpringFramework에서 제공하는 StopWatch클래스 사용 
//		다른 스레드에 영향을 받지 않고 실행하는 방법
//		 => bean에서 미리만들고 가져다 사용하는게 더 좋음
//		StopWatch : 시간을 측정하기 위한 기능을 제공하는 클래스
		StopWatch stopWatch=new StopWatch();
		
//		StopWatch.start() : 시간 측정 시작 메소드
		stopWatch.start();
		
		Object object=joinPoint.proceed();
		
//		stopWatch.stop() : 시간 측정 종료 메소드
		stopWatch.stop();
		
		logger.info("실행시간 = "+stopWatch.getTotalTimeMillis()+"ms 걸려찌요!");
		
		return object;
		
		/* 망망망
		Timestamp timestamp1=new Timestamp(System.currentTimeMillis());
		long time1=timestamp1.getTime();
		logger.info("target메소드 실행 전 걸린시간맞나요?="+time1);
		
		Object object=joinPoint.proceed();
		
		Timestamp timestamp2=new Timestamp(System.currentTimeMillis());
		logger.info("target메소드 실행 후 걸린시간맞나요?="+timestamp2.getTime());
		
		System.out.println("[총 걸린시간] = ");
		
		return object;
		*/
		
	}

}








