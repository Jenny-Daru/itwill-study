package site.itwill09.springMVC;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//Command Controller 클래스 : 직접 만들지않고 SpringFramework가 제공해주는 Controller 인터페이스를 상속받아 작성
//얘가 서비스를 가져다 사용할거고 서비스는 DAO를 가져다 사용할거지
public class ListController implements Controller {

	@Override
//	ModelAndView 반환
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		service클래스의 메소드를 호출하여 데이터 처리 후 결과 반환 (원래 입력값이 있다면 입력값을 먼저 처리해야함)
//		 => 결과(memberList)
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("AAA","꿍다루","daru@daru.com"));
		memberList.add(new Member("BBB","융다루","yun@daru.com"));
		memberList.add(new Member("CCC","다루루","ruru@daru.com"));
		
//		ModelAndView : 요청처리 결과와 응답 페이지 정보를 저장하는 클래스
		ModelAndView mav=new ModelAndView();
		
//		ModelAndView.addObject(String attributeName, Object attributeValue) 
//		 : 요청처리 결과를 추가하는 메소드 (map 형태로 객체를 추가해주세요~)
//		    => request.setAttribute() 메소드와 유사한 기능을 제공
//		    => 저장의 범위 자체를 바꿀수 있으므로 때에 따라 내부적으로 session을 사용할 수 있음 
		mav.addObject("memberList",memberList);
		
//		ModelAndView.setViewName(String viewName) : 응답페이지 정보를 변경하는 메소드
		mav.setViewName("member_list");
		
		return mav;
	}

}
