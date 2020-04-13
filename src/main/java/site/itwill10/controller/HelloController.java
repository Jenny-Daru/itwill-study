package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Command Controller : 반드시 Controller인터페이스 상속, ★Spring Bean으로 등록 => 중요 => 어노테이션 사용★ 
//@Component => Controller 인터페이스를 상속받아야함, @RequestMapping 사용 불가능  

//@Controller : Command Controller 역할의 클래스를 Spring Bean으로 등록하기 위한 어노테이션
//				 => 기본적으로 클래스명을 beanName으로 설정 - 속성을 이용하여 변경가능 (Injection 시키거나 가져다 사용하지 않으니 굳이 변경안함)
//				 => Controller 인터페이스를 상속받지 않아도 Command Controller 클래스로 작동가능 
//				 => Command Controller라 부르지 않음, @Controller 어노테이션을 쓰는 순간 달라짐 
//				 => Command Controller는 하나의 요청을 받아서 처리하는것 이지만!
//				 => 클라이언트의 요청에 대한 처리 메소드를 여러개 선언 가능 => Controller라 부름 => HandlerMapping 사용하지않아도 가능
//                   >> ♥@RequestMapping♥ 사용자의 요청을 메소드 단위로 처리  
//				 FrontController가 요청을 받고 Command Controller가 실제로 처리하지만 요청과 처리 둘다 하기 때문에 Controller라 불리움 
@Controller
public class HelloController {
//	기록객체 생성 >> 이벤트 발생 >> 기록구현체가 catch하여 기록가능 
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);
	
//	클라이언트의 요청을 처리하기 위한 메소드(여러개 가능)
//	@RequestMapping : 클라이언트 요청정보를 제공받아 메소드를 호출하여 실행하는 어노테이션  => @Controller에 종속되어 있으므로 @Controller을 사용 후 적용 가능
//					  => ★value속성(필수) : 클라이언트 요청정보를 속성값으로 설정 - 다른 속성이 없는 경우 value생략하고 속성값만 설정 가능 
//					  => web.xml에서 확장자 없이 /(모든요청)으로 요청받는것 설정되어 있으므로 클라이언트가 확장자없이 hello라고 요청하면 컨테이너가 이메소드를 호출해쥼
	
//	요청처리 메소드는 ★반드시 View Name을 반환해야 한다★
//	 => Front Controller는 ViewName을 전달받아 ViewResolver 클래스를 이용하여 JSP 파일경로로 변환하여 포워드 이동 
//		즉, viewName이 없으면 viewResolver에게 전달할 정보가 없고, JSP 문서도 없음 망..
	

//	[♥♥♥ 요청처리 메소드에서 Front Controller에게 viewName(JSP를 만들기 위한 Name)을 전달하는 방법 - 3가지 ♥♥♥] 
//	 => 응답하고자 하는 JSP문서가 됨
//	1. 요청 처리 메소드의 반환형 void 선언 : 메소드명을 ViewName으로 제공 
//	2. 요청 처리 메소드의 반환형 String 선언 : 반환값(문자열String 인스턴스)을 ViewName으로 제공 => JSP로 응답할 경우 사용, 가장많이 사용
//	3. 요청 처리 메소드의 반환형 ModelAndView 선언 : 반환값(ModelAnd★View★인스턴스)을 ViewName으로 제공
//													  => 특별한 경우 사용,  내부적으로getter메소드 호출하여 view를 가져다 사용해서 실행
//	♥♥♥메소드명은 아무렇게 해도 상관없지만 반환형과 매개변수는 규칙이 존재 !! 매개변수 : 컨테이너에게 필요한 객체를 제공받기 위해 필요♥♥♥
	
	
	@RequestMapping(value = "/hello")
	public void hello() {
//		[1]
//		Command Controller는 ModelAndView를 반환하였지만 여기서는 void !!!
//		요청처리 명령 구현 - Servie 클래스의 메소드 호출 / service =>  DAO호출 / DAO => MyBatis
		logger.info("/hello 요청 >> HelloController클래스의 hello() 메소드 호출");
		
	}
	
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
//		[2]
//		메소드의 클래스명이 같아도 상관없지만 매개변수는 다르게 설정해야함 
		logger.info("/helloViewName 요청 >> HelloController클래스의 helloViewName() 메소드 호출");
		return "hello";
	}
	
	
	@RequestMapping("/helloMAV")
//	ModelAndView : 요청처리에 대한 결과값과 ViewName을 저장하기 위한 클래스 
	public ModelAndView helloModelAndView() {
//		[3]
		logger.info("/helloMAV 요청 >> HelloController클래스의 helloModelAndView() 메소드 호출");
		/*
		ModelAndView modelAndView=new ModelAndView();
//		ModelAndView.setViewName(String ViewName) : ViewName을 변경하는 메소드
		modelAndView.setViewName("hello");
		*/
		
//		생성자를 이용하여 ViewName 초기화하여 저장
		ModelAndView modelAndView=new ModelAndView("hello");
		return modelAndView;
	}
	
	
}














