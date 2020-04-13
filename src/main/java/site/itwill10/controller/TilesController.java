package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//이제부터 이것이 main이다!!!!!!!!!!!!!
@Controller
public class TilesController {
//	사이트의 main 페이지를 요청한 경우 호출되는 메소드 
//	 => 어차피 메인은 GET이야~ value랑 method 생략가능~
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template() {
//		원래는 JSP를 return 해줘야하지만 고유값(Template페이지의 이름)을 return해쥴거다~
//		tiles.xml 파일에 선언된 definition 엘리먼트의 고유값(name속성값)을 ViewName으로 반환하면 설정된 템플릿 페이지(JSP)로 응답 처리
//		 >> 프론트 컨트롤러가 받아서 뷰리저버한테 전달 >> 뷰리저버가 JSP찾아서 출력~   ★tiles.xml 꼬옥 만들기★
		
//		웹어플리케이션 컨텍스트가 접근 가능한 곳은 WEB-INF만 접근 가능하므로 여지껏 여기다 xml을 생성했지 
		return "main";
	}
	
	
	@RequestMapping(value = "/tiles1")
	public String tiles1() {
//		반환되는 ViewName이 definition 엘리먼트의 고유값과 JSP파일명으로 설정 
		return "hello_tiles";
	}
	
	
//	디렉토리 구분자가 있으면 tiles.xml에서 인식하지 못함 => 문자열만 인식하니까~~ 추가해 실행하고 싶으면
	@RequestMapping(value = "/tiles2")
	public String tiles2() {
//		디렉토리이름/JSP파일명이 되는거~~~~~~~~ xml에 definition */*로 추가해서 사용하면됨
		return "tiles/hi_tiles";
	}
	
	@RequestMapping(value = "/tiles3")
	public String tiles3() {
		return "tiles/good/by_tiles";
	}	
	
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}	
	
	
	@RequestMapping(value = "/admin_hello")
	public String adminHello() {
		return "admin/hello";
	}	
}












