package site.itwill10.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class ValidController {
	
	@RequestMapping(value = "/valid_html", method = RequestMethod.GET )
	public String html() {
		return "valid/html_form";
	}
	
//	요청처리 메소드 
	@RequestMapping(value = "/valid_html", method = RequestMethod.POST)
//	입력태그의 name 속성값 = 필드명
	public String html(@ModelAttribute Hewon hewon, Model model) {
//		요청 처리 전 입력값에 대한 유효성 검사 
		if(hewon.getId()==null || hewon.getId().equals("")) {
			model.addAttribute("idMsg", "아이디 입력해죠랑!");
			return "valid/html_form";
		}
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, hewon.getId())) {
			model.addAttribute("idMsg", "아이디를 형식에 맞게 입력해쥴랭??");
			return "valid/html_form";
		}
		return "valid/html_result";
	}

//		JavaBean 필드에 저장되기전에 하나씩 유효성 검사 해쥼 => Spring의 유효성 어노테이션 사용 
//	     : 라이브러리 추가 >> Spring에서 제공해주는 어노테이션을 확장해주는 외부 라이브러리 존재
//		   https://mvnrepository.com/ >> 자바에서 제공해주는것(Validation-api) & hibernate-validator(확장라이브러리)  
	
	@RequestMapping(value = "/valid_spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Hewon hewon) {
		return "valid/spring_form";
	}
	
//	@Valid : Spring From 태그에 의해 전달된 값을 Command 객체의 필드에 저장하기 전 필드의 유효성 검사기능을 활성화 처리하기 위한 어노테이션 
//	          => JavaBean 클래스의 필드에 유효성 검사 관련 어노테이션을 사용 <= 어떤 필드를 어떻게 유효성 검사할건지 알아야 유효성 검사를 해쥬지!!
//	Errors : 유효성 검사후 발행되는 모~~~~~~든 Error 정보를 저장하기 위한 인스턴스 / 일종의 콜렉션 
	@RequestMapping(value = "/valid_spring", method =RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Hewon hewon, Errors errors) {
//		Errors.hasErrors() : Errors 인스턴스에 Error정보가 존재할 경우 true를 반환하는 메소드
		if(errors.hasErrors()) {
			return "valid/spring_form";
		}
		return "valid/spring_result";
	}
	
	
//	요청 처리메소드가 될수없음~ 아직은??
//	메소드의 반환값이 모든 ViewPage에 반환하는 기능이 구현
//	메소드 반환값이 모든 요청처리 메소드의 View페이지에 제공
	@ModelAttribute("genderList")
	public List<String> genderList() {
//		Arrays : 배열을 갖는 클래스, 
		return Arrays.asList("남자","여자","몬나요");
	}

}
























