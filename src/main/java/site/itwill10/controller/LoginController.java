package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
//		/ : 경로를 지정할 때 디렉토리와 파일을 구분하는 것 
//		    => WEB-INF(생략) >> view >> session폴더 >> Login_form.jsp
//		    => views밑에 폴더를 만들어서 사용 
		return "session/login_form";
	}
	
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	입력값이 간단할 경우 매개변수를 이용해 값 전달받기 
//	모든 View페이지에 값을 제공하기 위해서는 session을 사용
//	매개변수의 자료형이 HttpSession인 경우 자동으로 세션이 바인딩되어 제공
	public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
		if(!id.equals("Daru") || !password.equals("123456")) {     //인증실패
//			forward이동되는 View페이지(JSP문서)에만 제공 - Request Scope
			model.addAttribute("message", "아디랑 비번 틀려찌~ 크크");
			model.addAttribute("id", id);
			return "session/login_form";
		}
		
//		컨텍스트에 존재하는 모든 자원에게 제공 - Session Scope
//		 => 로그인 권한
		session.setAttribute("loginId", id);
		return "session/login_result";
	}
	*/
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute  Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("Daru") || !hewon.getPw().equals("123456")) {     //인증실패
			model.addAttribute("message", "아디랑 비번 틀려찌~ 크크");
			return "session/login_form";
		}
		
		session.setAttribute("loginId", hewon.getId());
		return "session/login_result";
	}	

}














