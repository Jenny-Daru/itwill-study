package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorldApp {
//	Logger : 로그 프로그램을 기록을 전달하기 위한 인스턴스
//	LoggerFactory.getLogger(Class<?> clazz) : 메모리에 저장된 클래스(Clazz)를 이용하여 기록을 전달하기 위한 Logger 인스턴스를 생성하여 반환하는 메소드
	private static final Logger logger = LoggerFactory.getLogger(Log4jHelloWorldApp.class);
//	아직 기록을 전달하지 않음!!
	
	public static void main(String[] args) {
//		여기서 info를 사용하여 기록을 전달해야함
//		Logger.info(String message) : 로그이벤트를 발생하여 메세지를 전달하는 메소드
//		info레벨의 로그이벤트를 발생시켜서 이런 메세지를 전달하겠다!!
		logger.info("시작");
		Log4jHelloWorld hw=new Log4jHelloWorld();
		String message=hw.hello("꿈다루");
		System.out.println("message = "+message);
		logger.info("종료");
		
	}
}
