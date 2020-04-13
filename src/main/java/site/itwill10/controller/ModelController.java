package site.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name", "융다루");
//		매개변수에 Date 클래스 사용하여도 결과 출력 NO
//		model.addAttribute("now", date);
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
*/		
		return "model_display1";
	}
	
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "융디현");
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
*/		
		return "model_display2";
	}
	
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "꿍스");
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date()));
*/		
		return "model_display3";
	}

	
//	날짜와 시간정보의 공통된 코드 계속 반복!
//	공통된 코드가 반복되고 메소드에 같은 결과값을 반환할 경우 사용하는 => 어노테이션 사용 : @ModelAttribute
//	@ModelAttribute : 메소드에 선언된 경우 현재 컨트롤러에 선언된 모든 View페이지에 메소드의 반환값을 저장하여 제공하기 위한 어노테이션
//	  				  ★value(name)속성 : View페이지에 사용하기 위한 고유값을 속성값으로 설정 
	@ModelAttribute("now")
	public String getNow() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	}
	
	
}




















