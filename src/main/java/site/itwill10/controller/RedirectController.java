package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print")
	public String forward(Model model) {
//		View페이지에서 출력될 정보를 제공 - 기본: Request Scope
		model.addAttribute("name", "뀽다류");
		
//		View페이지(JSP)로 forward 이동
//		 => 클라이언트 브라우저의 요청 URL 주소 미변경 => ???????????????????
//		 => Request Scope로 제공되는 값을 사용
		return "redirect/forward_display";
	}

	/*
	@RequestMapping("/redirect_print")  //아니 요청 URL바꼇눈데????????????
	public String redirect(Model model) {
		model.addAttribute("name", "다류찡");
		return "redirect/redirect_display";   //포워드 이동 
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
//		FrontController에게 redirect로 이동시켜줘~ 요청 
//		반환되는 ViewName에 redirect 접두사(NameSpace)를 사용하면 redirect 이동
//		 => 클라이언트에게 301코드(재요청)와 요청URL 전달하여 재요청 구현
//		 => 클라이언트 브라우저의 요청 URL 주소 변경
		return "redirect:/redirect_print";
	}
	*/
	
	
//	포워드는 Request Scope를 통해서 정보를 전달받지만 리다이렉트는 불가
/*	
	@RequestMapping("/redirect_print")  
	public String redirect(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
//		요청처리 메소드의 Request가 다르므로 name으로 저장된것 사용 불가
//		리다이렉트 이동되기 전에 제공되는 정보 출력 불가능
		return "redirect/redirect_display";   
	}
	
//	Request Scope로 제공되는 정보[문자열(String만 가능)]는 리다이렉트 페이지에 QueryString 형식으로 전달
	@RequestMapping("/redirect")
	public String redirect2(Model model) {
		model.addAttribute("name", "융다루");
		return "redirect:/redirect_print";
	}
*/
	
//	[편리한 리다이렉트 이동방법]
	@RequestMapping("/redirect_print")  
	public String redirect() {
		return "redirect/redirect_display";   
	}	
	
	@RequestMapping("/redirect")
//	RedirectAttributes : 리다이렉트 이동에 의해 호출된 요청처리 메소드의 View페이지(redirect_display)에 정보를 제공하기 위한 기능의 인스턴스
//	RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
//	 : 리다이렉트 이동된 View페이지에 객체를 제공하는 메소드 (내자신이 아니고 다른애한테 줄때 사용)
	public String redirect2(RedirectAttributes attributes) {
		attributes.addFlashAttribute("name", "꿍스");
		return "redirect:/redirect_print";
	}
}















