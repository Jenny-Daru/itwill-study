package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
/*	
//  클라이언트의 모든 정보가 들어있는데 나는 필요한것만 가져오고 싶음 => 매개변수 사용
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		
		return "param_display";
	}
*/	
	
//	매개변수를 선언하면 전달값을 자동으로 제공받아 저장 >> 알아서 해쥬지는 않고 규칙이 존재
//	 => ★입력태그의 name 속성값과 매개변수의 이름이 같은 경우 저장★ Front Controller가 Container통해서 알아서 해쥼 
//	      문제1) 입력태그의 name 속성값과 매개변수의 이름이 다른 경우 매개변수에 Null저장 
//		  문제2) 입력값에 대한 캐릭터셋 변경 불가능 - 한글 입력 불가능 
//	   			  => 인코딩 필터를 사용하여 입력값을 제공받아 저장하기 전에 캐릭터셋 변경 >> web.xml 파일에서 설정
//	 	request는 특별한 경우만 사용 WHY??? 모든정보를 다 가지고 있으니까 ~ ~ ~ 필요없는건 사용안하고싶음 
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
	
//	4/3 추가 등록 
//	@RequestParam : 입력값을 전달받아 저장하기 위한 매개변수에 선언하는 어노테이션 ★권장★
//	입력태그에서 입력받은 name속성값과 전달받아 저장하는 매개변수명을 다르게 설정할 경우 => Error없이 null값이 저장
//	 but, @RequestParam 어노테이션을 사용할 경우 400에러 (잘못된요청)
//	 => 입력값을 반드시 매개변수에 전달받아 저장하기 위해 사용하는 어노테이션
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/

//	만약, form태그에서 name속성값과 전달받는 매개변수명이 다를경우 400에러가 발생
//	 => RequestParam 속성값을 사용
//	@RequestParam 어노테이션의 속성을 이용하여 입력값에 대한 전달 설정
//	              value 속성 : 입력태그의 고유값(name속성값)을 속성값으로 설정
//								=> 입력태그의 name속성값과 매개변수의 이름이 다른 경우 사용 
//								=> 입력태그의 name속성값을 설정하여 입력값을 매개변수에 저장 가능
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("username") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
//	@RequestParam 의 required 속성 : false 또는 true를 속성값으로 설정
//								     false(필수) => name속성값과 매개변수의 이름이 같지않아도 400에러코드 미발생 => 이거사용할바에는 걍 빼!! 걍 쓰지않는게 좋지
//													ex) 게시판에서 pageNum과 검색키워드를 전달받지만, 검색키워드를 안받을 경우도 존재하지 그럴때 사용
//									        true => name속성값과 매개변수의 이름이 같지않을 경우 400에럭코드 발생
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
//	@RequestParam 의 defaultValue 속성 : 매개변수에 저장될 기본값을 속성값으로 설정
//										  => 매개변수에 입력값이 저장되지 않을 경우 자동 저장되는 값 설정
//											 1.입력태그에서 값을 입력하지 않았을 경우 
//											 2.400에러 미발생 하기 위해 name속성값과 매개변수의 이름이 같지않을 경우에 사용 
//											 ex) pageNum을 전달해야하는데 안넘어올 경우 에러발생하는데 기본값으로 1을 설정할 경우 에러발생하지 않음
//	입력값이 존재   => 입력값을 출력
//			 미존재 => 기본값을 출력
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value = "username", defaultValue = "뀨웅다루") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}	
}















