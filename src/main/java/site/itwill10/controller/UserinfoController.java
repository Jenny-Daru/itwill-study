package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;
import site.itwill10.service.UserinfoService;

@Controller
//요청처리 메소드 요청시 상위 디렉토리가 됨 
@RequestMapping("/userinfo")
public class UserinfoController {
	
	@Autowired
	private UserinfoService userinfoService;
	
//	관리자가 페이지를 요청한 경우에만 요청메소드의 명령이 실행되도록 권한 설정
//	 => 이 메소드를 요청한 클라이언트가 관리자인지 아닌지 확인해야함
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) {
//		session에 "loginUserinfo"로 저장된 정보가 있다면~~~ 저장 없으면 null저장됨
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
//		로그인 사용자가 아니거나 관리자가 아니라면
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			return "userinfo/user_error";
		}
		return "userinfo/user_write";
	}
	
//	try ~ cathch를 사용하면 느려지므로 ExceptionHandler 이용
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (UserinfoExistsException e) {
			model.addAttribute("message", e.getMessage());
//			아이디 중복
			return "userinfo/user_write";
		} catch (Exception e) {
			e.printStackTrace();          //  개발자가 에러볼수 있게 적어두기~
			return "userinfo/user_error";
		}
		return "redirect:/userinfo/login";
	}
	*/
	
//	Service 클래스의 메소드 실행시 예외가 발생될 경우 발생된 예외를 처리하지 않고 FrontController 에게 전달
//	 => FrontController는 예외가 떠넘겨 받으면 예외처리(ExceptionHandler) 메소드를 호출하여 예외 처리
//	 => ExceptionHandler는 예외를 처리하는 방법 2가지 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) throws LoginAuthFailException, UserinfoNotFoundException {
//		인증실패 - 예외발생 
		userinfoService.loginAuth(userinfo);
		
//		인증성공 - session을 이용하여 인증정보(회원정보) 저장 => 권한설정 ,  "loginUserinfo"에 id를 저장
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		
		if(session.getAttribute("destURI")!=null) {
			String destURI=(String)session.getAttribute("destURI");
			session.removeAttribute("destURI");
			return "redirect:"+destURI;
		}
		return "userinfo/user_login";
	}
	
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/userinfo/login";
	}
	
	
//	@ExceptionHandler 
//	 : Controller 클래스의 요청처리 메소드에서 예외가 발생된 경우 예외를 처리하기 위한 메소드를 설정하기 위한 어노테이션
//	    => 어떤예외를 처리할 것인지!!  value 속성 : 예외 클래스(Clazz)를 속성값으로 설정
//	 예외처리 관련 정보를 예외처리 메소드의 매개변수를 선언하여 제공받아 사용
	@ExceptionHandler(UserinfoExistsException.class)
	public String execeptionHandelr(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String execeptionHandelr(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";
	}
	
	/*
//	Exeception을 처리하는 예외처리 메소드가 존재할 경우 생략 가능
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String execeptionHandelr(UserinfoNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "userinfo/user_login";
	}
	*/
	
	
	/*
	
	예외처리 컨트롤러를 따로 만들어서 사용
	@ExceptionHandler(Exception.class)
	public String execeptionHandelr(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}
	*/

}















