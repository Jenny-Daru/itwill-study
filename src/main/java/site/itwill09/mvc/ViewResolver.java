package site.itwill09.mvc;

//View페이지를 제공하는 기능의 클래스
// => 좀 더 쉽게 view페이지를 변경하기 위해 생성 
public class ViewResolver {
//	문자열을 전달받아 응답할 View페이지(JSP 문서)로 변환하여 반환하는 메소드
//	 => "WEB-INF" 디렉토리에 JSP문서를 작성하여 클라이언트의 요청을 거부 (사용자의 요청에 의해 WAS가 접근못하고, Web어플리케이션을 통해서만 접근가능)
//	 => Controller에서 반환하는것이 문자열로 반환해준다. 그것을 전달받아 JSP 문서로 반환해줄거야
//	    클라이언트가 요청하지 못하도록 WEB-INF에 만들어줄거임 , WAS가 요청받아도 JSP를 응답못하게 해줄려고 
	public String getViewPage(String view) {
		return "/WEB-INF/mvc/"+view+".jsp";
	}

}
