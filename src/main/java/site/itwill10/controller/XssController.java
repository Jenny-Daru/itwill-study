package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyncode.jtwig.functions.util.HtmlUtils;

@Controller
public class XssController {
	@RequestMapping(value = "/xss", method = RequestMethod.GET)
	public String xss() {
		return  "xss/input";
	}
	
//	XSS : 입력태그에 비정상적인 코드를 입력하여 프로그램을 공격하는 기술
//		   => 반드시 XSS 공격에 대한 방어를 위한 보안코딩 필요★
//	   	  [방법1] 응답할 때!! View페이지에서 처리 : 태그관련 문자를 Escape 문자로 변환
//				  => Core 태그 라이브러리의 out태그 이용  	
//				  => Functions 태그 라이브러리의 escapeXML() EL 함수를 사용 
//				  ★문제점 : 엔터 적용이안되어 <br>태그를 사용하여도 태그가 적용이 안됨★
	
//		  [방법2] 요청처리 메소드에서 처리 : 태그관련 문자를 Escape 문자로 변환 => ♥♥♥권장합니다♥♥♥
//				  => Spring에서 제공하는 HtmlUtils 클래스의 htmlEscape() 메소드 호출
	@RequestMapping(value = "/xss", method = RequestMethod.POST)
	public String xss(@RequestParam String subject, @RequestParam String content, Model model) {
		/*
		model.addAttribute("subject", subject);
//		내용에 엔터를 사용하면 미적용되므로 replace를 사용하여 적용하기
		model.addAttribute("content", content.replace("\n", "<br>"));
		*/
		
//		[기본적인 방법]
		/*
		model.addAttribute("subject", HtmlUtils.htmlEscape(subject));
		model.addAttribute("content", HtmlUtils.htmlEscape(content).replace("\n", "<br>"));
		*/
		
//		[아예태그를 없애는 방법 => pom.xml에 라이브러리 새로 빌드 => 메이블 레파지토리에가서 Jtwig-core]
//		 => 강력하지만 태그관련 기호들도 지워져버려서 관련된 문자들도 같이 지워지는 문제 발생 - 비권장
		model.addAttribute("subject", HtmlUtils.stripTags(subject));
		model.addAttribute("content", HtmlUtils.stripTags(content).replace("\n", "<br>"));
		
		return  "xss/output";
	}

}











