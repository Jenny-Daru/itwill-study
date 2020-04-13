package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//로그 출력하고 싶으면 log4j.xml의 root엘리먼트에서 priority를 warn => info로 변경하면 로그출력 가능 
// => info레벨 밑으로 절대 잡으면 안됨... DEBUG 해버리면 굉장히 많은 기록이 남아서 별로 권장하지 않음 최소 info다! 
// => log4.xml에 logger엘리먼트를 사용하여 추가하면 console에 로그기록이 남음~~~~~~ 

public class Log4jHelloWorld {
	private static final Logger logger = LoggerFactory.getLogger(Log4jHelloWorld.class);

	public String hello(String name) {
		logger.info("시작");
		String message=name+"님 안녕하세요.";
		logger.info("종료");
		return message;
	}
}
