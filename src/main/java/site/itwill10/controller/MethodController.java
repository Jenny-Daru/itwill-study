package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
//	입력페이지에 대한 요청처리 메소드
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
//	출력페이지에 대한 요청처리 메소드
//	 => 입력값을 전달받아 View페이지에서 출력되도록 제공
//	    입력값을 가져와야징 request 사용
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request) throws UnsupportedEncodingException {
//		가져오기전에 한글입력 제대로 받게 설정, UTF-8 >> 예외처리 >> 떠넘기기
//		HttpServletRequest.setCharacterEncoding(String encoding) : 입력값에 대한 캐릭터셋을 변경하는 메소드 
//																    UnsupportedEncodingException 발생 >> 떠넘겨
		request.setCharacterEncoding("UTF-8");
		
//		입력값 전달받아 저장 
		String name=request.getParameter("name");
		
//		request이용하여 저장
		request.setAttribute("name", name);
		
		return "method_output1";
	}
	
	
//	[★★★요청하는 URL 주소가 같은 경우 - 요청방식만 다르게 설정★★★]
	
//	입력페이지에 대한 요청처리 메소드
//	method 속성 : 요청방식을 속성값으로 설정 
//				   => 클라이언트 요청방식에 의해 요청처리 메소드 호출
//	★주의 : RequestMethod(Enum 자료형-상수필드만 가지고 있음)의 상수필드를 사용하여 속성값으로 설정
//	클라이언트가 메소드호출 뿐만아니라 GET방식으로 요청했을시 실행
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}

	
//	출력페이지에 대한 요청처리 메소드
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
//		입력값을 잘못 가져왔을 경우 method_input2로 리다이렉트 이동 , 에러처리 완젼 편리 
		if(name==null || name.equals("")) {
			request.setAttribute("message", "이름을 입력해쥴래요오오오오오?????");
			return "method_input2";
		}
		return "method_output2";
	}
}







