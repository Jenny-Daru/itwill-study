package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러 클래스(Model) : 클라이언트의 요청을 처리하는 메소드가 작성된 클래스
//							=> 모델클래스 대신 컨트롤러클래스(Command Class)로 표현
public class ListController implements Controller {

	@Override
//	요청처리 메소드
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		service클래스의 메소드를 호출하여 데이터 처리 후 결과 반환 (원래 입력값이 있다면 입력값을 먼저 처리해야함)
//		 => 결과(memberList)
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("AAA","꿍다루","daru@daru.com"));
		memberList.add(new Member("BBB","융다루","yun@daru.com"));
		memberList.add(new Member("CCC","다루루","ruru@daru.com"));
		
		
//		처리결과(인스턴스)를 request 인스턴스에 속성으로 저장 
		request.setAttribute("memberList", memberList);
		
//		처리결과를 응답하는 페이지정보 반환
//		 => JSP문서(member_list)가 응답
//		* redirect: 붙이면 redirect이동 가능 *
//		return "redirect:member_list";
		return "member_list";
	}

}
