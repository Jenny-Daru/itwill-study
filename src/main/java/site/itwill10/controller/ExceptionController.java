package site.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//예외처리 메소드만 선언된 클래스 
// => 하나의 Controller가 아닌 모든 Controller 클래스의 요청처리 메소드에서 발생된 예외

//@RestController : REST를 제공하는 컨트롤러의 예외처리를 하기 위한 어노테이션
//@ControllerAdvice : 예외처리 메소드만 선언된 클래스에 사용하는 어노테이션 , AOP 일종의 횡단관심 코드 
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String execeptionHandelr(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}

}
