package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//요청처리 클래스(Model - CommandController)가 반드시 상속받아야 하는 인터페이스 
// => 인터페이스를 상속받은 모든 자식클래스가 같은 구조로 작성되도록 규칙을 제공 
// => 모든 자식클래스에 인스턴스를 인터페이스 참조변수에 저장하여 메소드 호출 - ★오버라이드에 의한 다형성★
//    원하는 메소드를 호출하여 자식클래스의 메소드 호출 가능 
// 요청은 FrontController가 받지만, 실제 동작은 CommandController가 실행
public interface Controller {
	String handlerequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
}
