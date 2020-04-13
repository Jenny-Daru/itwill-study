package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//ModelAndView = 처리결과 + ViewName

//[ 요청처리 메소드에서 View페이지(JSP)에서 사용할 수 있도록 처리결과를 저장하는 방법 ] 
// 1. ModelAndView 인스턴스(객체)를 이용하여 처리결과를 저장 => 반환형 : ModelAndView 
// 2. HttpServletRequest 인스턴스(객체)를 이용하여 처리결과를 저장 => 반환형 : String(ViewName)
// 3. Model 인스턴스(객체)를 이용하여 처리결과를 저장 => 반환형 : String(ViewName)
// 4. ModelMap 인스턴스(객체)를 이용하여 처리결과를 저장 => 반환형 : String(ViewName)
@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
//	ModelAndView : 요청처리에 대한 결과값과 ViewName을 저장하기 위한 클래스 
//					=> request에 저장해서 JSP 문서에서 가져다 사용
	public ModelAndView modelAndView() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		
//		ModelAndView.addObject(String attributeName, Object attributeValue)
//		 : ViewPage에서 사용되도록 실행결과를 추가하는 메소드 , 기본 : Request Scope
//		   속성을 이용하여 값을 추가
		modelAndView.addObject("Daru", "꿍다류");
		
		return modelAndView;
	}
	*/
	
	
//	요청처리 메소드는 Front Controller에 의해 자동 호출
//	요청처리 메소드에 매개변수를 선언하여 Spring Container로부터 인스턴스를 제공받아 자동으로 매개변수에 전달하여 저장(없으면 만들어서라도 무조건 준다요)
//	 => 매개변수에 나 이거필요해요~ 요청하면 주는거!! 관리할 수 있는것들만 주는거입니당, 필요한 정보까지 같이전달도 해쥬는데 그정보 바꾸고 싶으면 setter로 변경해서 사용해
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
//		setter 사용 이유
//		 => 매개변수에 전달된 인스턴스에는 초기에 값을 가진것이 없기 때문에 setter메소드 호출하여 변경해야함 
		modelAndView.setViewName("result_display");
		modelAndView.addObject("Daru", "꿍다류찡♥");
		return modelAndView;
	}
	
	
	
	@RequestMapping("/resultRequest")
//	ViewName을 반환하는 것은 String이 편리하지~ 근데 전달값은 어떻게 받니? HttpServletRequest 사용하면 되지!!
//	같은 viewPage로 응답하여도 저장Scope가 다르기 때문에 결과값이 각각 출력됨
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("Dream", "아푸지망♥");
		return "result_display";
	}
	
	
//	♥♥♥ 가장 보편적 가장많이 사용 ♥♥♥ => 매개변수 더사용해도 가능해
//	Model 인스턴스 : 처리결과를 저장하기 위한 인스턴스
//	ModelAndView.addAttribute(String attributeName, Object attributeValue)
//	 : ViewPage 사용되도록 실행결과를 저장하는 메소드 , 기본 : Request Scope
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
//		기본적으로 request Scope
		model.addAttribute("DreamDaru", "꿍다류찡♥아푸지망♥");
		return "result_display";
	}
	
	
//	ModelMap클래스 : Model 인터페이스를 상속받아 작성된 클래스 - Model 인스턴스를 만들기 위해 
	@RequestMapping("/resultMap")
	public String modelMapResult(ModelMap map) {
//		기본적으로 request Scope
		map.addAttribute("DaruDream", "꿍다류찡♥보구싶다♥");
		return "result_display";
	}
	
}



















