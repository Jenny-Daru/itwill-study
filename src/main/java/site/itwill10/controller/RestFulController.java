package site.itwill10.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberListXML;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.service.RestMemberService;

//Spring 3.0 부터   MVC 기능 강화 
//Spring 4.0 부터  Rest 기능 강화  => 어노테이션 더 많아짐 
//Spring 5.0 부터 cloud 기능 추가

//Rest(Representational State Transfer) 기능을 제공하는 컨트롤러 
// => 하나의 요청 URL 자원이 하나의 리소스를 대표하도록 제공 
// => 목적 : 다양한 기기에서 요청에 대한 응답결과로 공통적으로 처리할 수 있는 형식의 텍스트 데이터를 전달하는 것
//           공통적으로 처리할 수 있는 형식의 텍스트 데이터 >> JSON 또는 XML(대용량)
// => 웹사이트 에서는 Ajax 기능으로 요청하여 응답결과를 제공받아 DHTML을 구현 
@Controller
public class RestFulController {
	
	@Autowired
	private RestMemberService restMemberService;
/*	
//	[ 일반적으로 프로그램을 만드는 방법 ]
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
//	입력값을 전달받아 저장 => 매개변수 이용
//	Model을 이용하여 뷰페이지에 속성값을 제공 
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	
*/	
//	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★[왕 중요]★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//	[ JSP를 통하지 않고 직접적으로 요청에 대한 응답을 해주는 방법 ]
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
/*	
//  [ 1) @ResponseBody어노테이션 사용 ]
//	클라이언트가 REST방식으로 POST 요청했다면 JSP로 응답하면 안됨!!
//	@ResponseBody : 반환결과를 ViewResolver에게 전달하지 않고 요청처리 메소드에서 직접 응답 처리 하도록 설정하는 어노테이션 
//					 => 요청처리 메소드의 반환값이 ViewName이 아닌 클라이언트에게 응답하는 결과(XML 또는 JSON)로 사용
//	 @RequestBody : 자원에 대한 요청이 POST, PUT, DELETE 등의 요청에 의해 전달된 모든 입력값을 JSON 형식의 텍스트 데이터(JavaScript 객체)로 전달받아 저장하기 위한 어노테이션
//					 => 단, GET 방식으로 요청하여 전달된 데이터 저장 불가능
//	 				 => Ajax 요청에 의해 전달된 입력값을 저장하기 위해 사용 , 몇개든 상관없이 통째로 가져와서 사용
//	실행하면 유니코드로 반환결과 나옴.
	 => @RequestBody를 사용하여 JavaScript 객체로 입력값들을 전달받음 
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		return input;
	}	
 */ 

//	브라우저가 문자열을 받아 그냥 출력하면 되니까 에러 안남
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public @ResponseBody String rest(@RequestBody String input) {
		return input;
	}

	//	[ 2) @ResponseBody의 위치를 반환형 앞에 선언도 가능(비권장) - XML로 응답하는 요청처리 메소드 ]
//	 클라이언트 요청에 대한 회원정보를 XML 텍스트 데이터로 응답하는 요청처리 메소드 
//	  => String이 아닌 객체를 응답할 경우 500에러 발생 => 도대체 브라우저가 어떻게 받아서 출력할지 몰라서 XML로 변환하여 반환하는 프로그램 필요 
//	     Java객체를 XML 또는 JSON 형식의 텍스트 데이터(String)로 자동 변환하여 응답되도록 설정 >> 실제 클라이언트한테 전달하기 전에 중간에 String으로 만들어서 클라이언트에게 전달
//		 ★1) XMLBinder 프로그램 필요(JDK내부에 이미 존재-라이브러리 필요없음 있는거 사용), JDK1.9버전부터 막혀있음 => XMLBinder 찾아서 빌드하여 사용 	
//	     2) JSONBinder 프로그램 필요(미존재 - 라이브러리 빌드하여 사용) 
	
//	@ResponseBody를 사용하여 클라이언트에게 RestMemberXML로 응답해줄게요.

//	 이것은 가능!!! String으로 반환하니까~~~~~
	/*
	@RequestMapping("/Xml_member")
	@ResponseBody
	public String restMemberXML() {
		return restMemberService.getRestMemberListXML().get(0).getId();
	}
	*/
	
//	[ Java 객체를 XML 형식의 문자열로 응답하는 메소드 ]
//	 => [위의 방법1)]반환되는 클래스 자료형에서 JAXB(Java Architecture form XML Binding) 기능 이용하여 변환처리 => RestMemberXML.java 고고!!
	@RequestMapping("/Xml_member")
	@ResponseBody
	public RestMemberXML restMemberXML() {
//		회원정보 목록이있다면 그중에 0번째 요소의 RestMemberXML의 객체(회원정보)를 반환해줄게요!
//		 => 브라우저가 문자열이 아닌 Java객체(RestMemberXML의 객체,배열)를 받아서 출력해야 하니까 인식못함 500에러 
//		 => Spring으로 변환시켜주는 변환프로그램이 없으므로 에러 발생 
		return restMemberService.getRestMemberListXML().get(0);
	}
	/*
//	회원목록을 반환하는 메소드
//	 => 목록을 반환해주는 Java객체가 없다.
	@RequestMapping("/Xml_list")
	@ResponseBody
	public List<RestMemberXML> restMemberListXML() {
		return restMemberService.getRestMemberListXML();
	}	
	*/
	
//	해결 방법 1) 회원정보를 저장하는 List필드가 선언된 클래스 필요
//	클라이언트 요청에 대한 회원정보를 XML텍스트 데이터로 응답하는 요청처리 메소드
	@RequestMapping("/Xml_list")
	@ResponseBody
	public RestMemberListXML restMemberListXML() {
//		
		RestMemberListXML listXML=new RestMemberListXML();
		listXML.setRestMemberList(restMemberService.getRestMemberListXML());
		return listXML;
	}	
	
//	@ResponseBody를 사용하지 않음 => JSP가 응답(display_xml.jsp)
//	회원목록을 AJAX 기능으로 요청하여 응답처리하는 메소드
	@RequestMapping("/xml_print")
	public String displayXML() {
		return "rest/display_xml";
	}
	
//**************************************************  JSON방법  ************************************************************
//	[ Java 객체를 JSON 형식의 문자열로 응답하는 메소드 ]	
//	해결 방법 2) Java객체를 JSON으로 변경 후 응답 
//	클라이언트 요청에 대한 회원정보를 JSON 텍스트 데이터로 응답하는 요청처리 메소드
//	 에러발생 => JSON 텍스트 데이터로 응답해주는 라이브러리 필요 => maven이용 => pom.xml
//			  => jackson-databind 기능을 이용하여 Java 객체를 JSON 형식의 문자열로 자동변환하여 응답처리 
//	  		  => Maven을 이용하여 jackson-databind 라이브러리 빌드 처리
//			  => 라이브러리만 빌드하여 실행하면 결과출력! 아쥬좋음~~
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}	
	
//	클라이언트 요청에 대한 회원정보를 JSON 텍스트 데이터로 응답하는 요청처리 메소드
	@RequestMapping("/json_list")
	@ResponseBody
	public List<RestMemberJSON> restMemberListJSON() {
		return restMemberService.getRestMemberListJSON();
	}	
	
//	회원목록을 AJAX 기능으로 요청하여 JSON으로 응답받아 출력하는 요청처리 메소드
	@RequestMapping("/json_print")
	public String displayJSON() {
		return "rest/display_json";
	}	
	
	
//	************************************ JSON의 장점 : dto 생성하지 않고 하는 방법 ************************************
	@RequestMapping(value = "/json_map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
//	모든 입력값을 Map객체의 엔트리로 저장받아 응답처리 (입력태그의 name 속성 : key, 입력태그의 입력값 : value)
//	 => Map객체(JavaScript객체)를 반환하면 jackson-databind 기능을 이용하여 JSON 타입의 문자열로 응답
//	 => JavaBean(DTO)클래스가 없는 경우 Map 객체를 이용하여 응답처리 
	@RequestMapping(value = "/json_map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> input(@RequestParam Map<String, String> map) {
		return map;
	}
	
//	ResponseEntity : 요청에 대한 응답을 요청처리 메소드에서 직접 제공하기 위한 클래스
//					 => @ResponseBody 어노테이션 역할을 제공하는 클래스
//					 => 제네릭에 응답 객체의 자료형을 설정
//	뷰페이지말고 내가 직접 ResponseEntity로 응답해줄게~~ 할때 사용
	@RequestMapping(value = "/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemberList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
//			ResponseEntity 객체 생성시 요청에 대한 응답결과와 응답코드 저장
			entity=new ResponseEntity<List<RestMemberJSON>>(restMemberService.getRestMemberListJSON(),HttpStatus.OK);
		} catch (Exception e) {
//			ResponseEntity 객체 생성시 요청에 대한 응답[에러]코드 저장
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
//	************************************************************************
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
	
	
	
	
	
	
}






















