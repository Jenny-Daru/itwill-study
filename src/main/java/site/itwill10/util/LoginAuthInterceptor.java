package site.itwill10.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

//로그인 관련 권한 처리를 위한 인터셉터 클래스 (작성후  servlet-context.xml 가서 Spring bean등록 후 ㅅ용)
// => 로그인 사용자가 아닌 경우 로그인 입력페이지로 이동 (목적지도 저장 가능하도록 설정)
// => 로그인 성공 후 기존 요청 페이지로 응답되도록 설정
public class LoginAuthInterceptor extends HandlerInterceptorAdapter {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loginUserinfo")==null) {
			String url=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI", url+query);
			}
			
			response.sendRedirect(request.getContextPath()+"/userinfo/login");
			return false;    //false로 설정하여 요청처리 메소드 호출되지 않도록 설정
		}
		return true;
	}

}
