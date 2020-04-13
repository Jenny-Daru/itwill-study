package site.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//클라이언트 요청정보와 처리 인스턴스를 저장하기 위한 콜렉션 필드가 선언된 클래스
// => 이전에는 콜렉션필드 프론트 컨트롤러에 만들어서 사용하였지만 따로 만들어서 사용할것임
public class HandlerMapping {
//	콜렉션 필드 -   Key : 요청정보(String)
//				  value : 처리인스턴스(Controller) => 처리클래스가 Controller를 상속받으니까
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
//		객체생성 
		mapping=new HashMap<String, Controller>();
//		Map 필드의 초기화 작업 메소드 호출
		initConfig();
	}
	
	private void initConfig() {
//		Map필드에 사용자의 요청정보와 처리인스턴스를 저장
		mapping.put("/list.itwill", new ListController());
		mapping.put("/view.itwill", new ViewController());
	}
	
//	클라이언트 요청정보를 전달받아 처리 인스턴스를 반환하는 메소드
//	 => 프론트 컨트롤러에서 init메소드 필요없고, 처리메소드도 필요없음??
	public Controller getController(String command) {
		return mapping.get(command);
		
	}
	
}
