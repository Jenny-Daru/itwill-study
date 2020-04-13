package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

//입력값을 전달받아 join_display.jsp에서 출력 
@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
//	출력하기 위해서는 요청처리 메소드에서는 입력값을 전달받아 ViewPage에게 제공 
//	입력태그의 name속성값과 매개변수의 이름이 다르게 설정 => 400에러코드 미발생
//	매개변수 많아지면 어떤게 입력값(전달값)인지, 객체인지 판단하기 힘듬
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
*/
	
	
//	★ 입력값을 전달받아 저장 => 매개변수 : @RequestParam 어노테이션 설정하는 것 권장 ★
//	입력태그의 name속성값과 매개변수의 이름이 다른 경우 400에러 발생 
//	속성을 통해 다양한 설정도 가능하니 안쓰는거 보다는 쓰는게 더낫지
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd, @RequestParam String name, @RequestParam String email,
			              @RequestParam String phone1, @RequestParam String phone2, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
*/
	
//	@ModelAttribute : ViewPage에게 출력값을 제공하는 어노테이션 => ♥♥♥메소드의 반환값 또는 입력값 제공♥♥♥ 
//	입력값을 전달받아 전달받아 저장하는 매개변수 => @ModelAttribute 설정 : 입력값을 ViewPage에 자동으로 제공
//	 => Model도 필요없고 model.addAttribute도 필요없지 >> 에러는 안떨어지지만 값이 전달이 안됨!!!
//	 => @ModelAttribute 어노테이션 value 속성 : 저장속성명을 속성값으로 설정 - 다른 속성X  >>  속성값만 설정 가능
	// 											입력태그의 name 속성값과 동일한 이름으로 설정해야만 매개변수에 입력값 저장
	//  										입력태그의 name 속성값 value 속성값이 다른 경우 매개변수에 입력값 미저장
//	                                             value속성 생략 - 매개변수의 자료형이 자동으로 속성명으로 설정 - 첫문자는 소문자로 변경되어 제공
//																  매개변수의 자료형 기본형(Wrapper), String  >> 속성을 생략할 경우 ViewPage에게 미제공
//	입력태그의 name속성값과 @ModelAttribute 어노테이션의 value 속성값이 다른 경우 
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd, @ModelAttribute("name") String name, @ModelAttribute("email") String email,
							@ModelAttribute("phone1") String phone1, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_display";
	}
*/
	
//	입력값이 너무많아 불편~~해결 방법
//	[ 입력값을 전달받는 매개변수가 많을 경우 >> Map을 이용하여 값을 가져오기 + @RequestParam ]
//	매개변수의 자료형 => Map 선언 : 입력값이 Map의 엔트리(Key와 Value)로 자동 저장 
//	 				  => 입력태그  name 속성값 : MapKey
//										입력값 : MapValue
//	Map 매개변수에 입력값이 저장되기 위해서는 반드시 @RequestParam 어노테이션 선언 
//	 => 만약, @RequestParam 어노테이션 생략 >> 매개변수에 빈(Empty) Map객체가 저장 
//	입력값이 Map에 저장되기 위해서는 어노테이션 꼬오오오오오오옥 사용해야한다!!! @RequestParam => 입력값을 매개변수에 저장해쥬세요
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	Map의 형태는 String과 Ojbect이지만 ~~ 어차피 값을 String으로 가져올거니까!! String 써도됨
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("map",memberMap);
		return "join_display";
	}
*/
	
//	[ 입력값을 전달받아 DB 연동 ]
//	긍디 DB연동할 떄에는 DTO를 많이 이용해~ 이것을 가장많이 사용 
//  Model이 없어도 @ModelAttribute이 입력값을 가져다가 ViewPage에게 제공 
	
//	매개변수의 자료형을 JavaBean으로 선언한 경우 입력값이  JavaBean객체의 필드에 자동저장
//	 => 단, JavaBean클래스의 필드명 = 입력태그의 name속성값
//	JavaBean 매개변수 : @ModelAttribute 어노테이션 선언
//	 => @ModelAttribute 생략도 가능 
//	 => value 속성을 이용하여 ViewPage에 제공되는 속성명 설정가능 >> value 속성 : 생략 >> 클래스명이 자동으로 속성명으로 지정
//	Command 객체 : 입력값을 저장하여 View페이지에 제공하는 객체 
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		member.setId("id");
		member.setId("passwd");
		member.setId("name");
		member.setId("email");
		member.setId("phone1");
		member.setId("phone2");
		member.setId("phone3");
		return "join_display";
	}	
*/
	
//	@RequestMapping의 속성값을 사용하는 방법 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
//		입력에 대한 유효성 검사 => form태그 사용하지 않고, Spring에서 제공해주는 태그사용 
		if(member.getId().equals("Daru")) {
			model.addAttribute("message", "뜨든!!!이미 사용즁인 아이디지롱~");
			return "join_form";
		}
		return "join_display";
	}		
	
	

}
















