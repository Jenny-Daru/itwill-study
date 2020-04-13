package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//컨트롤러(Controller) : 클라이언트의 모든 요청을 받아 URL 주소를 분석하여 요청에 대한 처리클래스를 인스턴스로 생성하여 
//						 모델(처리)클래스(Model)의 인스턴스 메소드를 호출하여 요청 처리 후 JSP(View) 문서로 응답되도록 흐름을 제어하기 위한 서블릿 클래스 
// 						 ★반드시!! 단일 진입점의 역할★ <= 얘만 요청을 받아 처리할거지, 다른애가 요청받아 처리하면 안댐 
//							=> ♥♥♥ web.xml 파일에서 서블릿클래스(WAS에 의해 실행되는 클래스)를 서블릿으로 등록하고 
//									   단일진입점 역할로 실행될 수 있도록 URL 패턴으로 매핑처리 ♥♥♥ - 안하면 의미업쯤
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	클라이언트 요청을 처리하기 위한 WAS 프로그램이 자동 호출하는 메소드
//	요청을 처리하기 위해 사용해야하는 객체 두개(request, response), 이거두개면 web어플리케이션 만들수 잇움
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 클라이언트의 요청 URL 주소를 분석 - 요구사항 파악 
//		    => 얘가 원하는 작업이 도대체 모니?
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
//		클라이언트의 요청 요구사항을 command가 분석해줌
		String command=requestURI.substring(contextPath.length());
		
//		2. 요청에 대한 컨트롤러(처리)클래스의 메소드 호출하고 응답페이지(handlerequest가 준다) 정보를 반환받아 저장
//		    => 컨트롤러클래스가 존재해야하고, 클래스가 없으면 인스턴스호출, 메소드 호출 불가하지!!  => 컨트롤러클래스 만들고 와라 => Controller인터페이스 작성 Go!
//		    => 요청 처리 클래스 : Model >> Controller
//		    command요청에 따라 요구사항을 해줘야하는데 인스턴스가 필요해 인스턴스 먼저 생성
		/*
		Controller controller=null;
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if (command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		
		String view=controller.handlerequest(request, response);
		*/
		
//		위에처럼 사용하지 않고, HandlerMapping 클래스를 따로 만들었으니 
//		요청정보를 전달하여 처리 인스턴스를 반환받아 처리 
		HandlerMapping handlerMapping=new HandlerMapping();
		Controller controller=handlerMapping.getController(command);
		
//		처리메소드를 호출하고 응답페이지 정보를 반환받아 저장
		String view=controller.handlerequest(request, response);
		
		
//		3. 응답페이지로 forward 이동하여 클라이언트에게 응답결과를 제공
//		    => 반환받은 응답페이지 정보를 View페이지로 변환하여 포워드 이동
		ViewResolver viewResolver=new ViewResolver();
		String viewPage=viewResolver.getViewPage(view);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
		
	}

}














