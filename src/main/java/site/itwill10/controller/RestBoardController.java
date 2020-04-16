package site.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import site.itwill10.dto.RestBoard;
import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;


// REST 기능을 제공하는 요청처리 메소드에 대한 JSON 응답결과를 확인을 위해 Advanced REST Client 크롬앱을 설치하여 테스트
// => 현업에서 가장많이 사용하는 테스트 프로그램 

// AJAX 요청에 의해 호출되는 요청처리 메소드의 method 속성값 : RequestMethod(Enum)의 상수필드(요청방식) 
// => GET(검색기능구현), POST(저장기능구현), PUT(전체 변경), PATCH(부분변경), DELETE(삭제) 등 
@Controller
//@RestController
// : 모든 요청처리 메소드의 반환값으로 응답되도록 설정하는 어노테이션 
//   => 요청처리 메소드에서 @ResponseBody 어노테이션을 사용하지 않아도 메소드 반환값으로 응답처리 
//   => Restful 기능을 제공하는 컨트롤러 클래스를 작성할 경우 사용(스마트 기기에서 필요한 값을 저장 변경 삭제하는 컨트롤러가 존재 할 경우 많이 사용)
//      요청처리 메소드가 무조건 응답을 ResponseBody로 함!! 즉, 요청처리 메소드에 @ResponseBody를 사용하지 않아도됨.
//@RestController
public class RestBoardController {
	
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
//	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//	게시글 목록을 Ajax로 요청
//	REST_BOARD 테이블에 저장된 게시글 목록을 검색하여 JSON 형태로 응답하는 요청처리 메소드
//	 => 게시글 목록을 페이징 처리하여 응답되도록 설정(페이지 번호 전달받는 것이 중요) 
//	 => defaultValue = "1"를 사용하여 페이지번호를 전달받지 않아도 기본적으로 1을 전달받아 에러없이 출력되도록 설정
//	 => 총게시글을 갯수를 알아야 페이징 처리 가능
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody //뷰페이지 응답하지 않을것 , 자동으로 객체로 반환
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
//		System.out.println("pageNum = "+pageNum);
		
//		REST_BOARD 테이블에 저장된 게시글의 갯수를 검색하여 반환받아 저장
		int totalBoard=restBoardService.getRestBoardCount();
		
		int pageSize=5;    //  한페이지에 검색되는 게시글의 갯수를 임의로 설정
		
		int blockSize=5;   //  페이지 블럭에 출력될 페이지의 갯수를 임의로 설정
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
//		Service 클래스의 메소드(getRestBoardList가 startRow와 endRow를 받아 Map에 저장)를 호출하기 위해 매개변수에 전달될 Map 객체 
		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());  // 요청페이지 시작 번호 
		pagerMap.put("endRow", pager.getEndRow());      // 요청페이지 마지막 번호
		
//		요청처리 메소드의 반환값으로 사용될 Map 객체 생성
//		 => 응답결과를 Map객체의 엔트리(Entry)로 저장하여 반환 - Entry >> JSON(JavaScript 객체)
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		두개의 자바스크립트 객체 , "restBoardList" => 배열객체 / "Pager" => Object객체
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager", pager);
		
		return returnMap;
		
	}
	
	
	
//	게시글을 전달받아 REST_BOARD 테이블에 저장하고 응답결과를 문자열로 반환하는 요청처리 메소드  
//	 => 일반적으로 저장할 경우 POST, 검색은 GET으로 요청 
//	 => 한글이 깨지지 않도록 POST 방식으로 요청
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody //View가 아닌 메소드가 응답
//	@RequestBody 어노테이션을 이용하여 JSON 형태의 입력값을 Java 객체의 필드로 변환받아 저장
	public String restBoardAdd(@RequestBody RestBoard board) {
//		Xss 공격에 대한 방어로 태그 관련 문자를 회피 문자로 변환하여 변경(ex.제목 or 내용)
//		 => 태그 스크립트 제거, 사용자가 입력한 악의적 문자를 방지
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	
	/*
//	게시글 번호를 잔달받아 REST_TABLE에 저장된 해당 게시글을 검색하여 JSON 형태로 응답하는 요청처리 메소드
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
		
	}
	*/
	
	//게시글 번호를 URL 주소로 전달받아 REST_BOARD테이블에 저장된 해당 게시글을 검색하여 JSON 형태로 응답하는 요청처리 메소드 
	// => 요청 자원의 URL 주소에 {변수명}형식으로 표현 
	// => @PathBariable 어노테이션을 이용하여 URL 주소로 전달된 값을 매개변수에 저장 가능 
	//    URL 주소가 하나의 data가 되는것 
	//요청자원의 변수명과 매개변수명을 같도록 선언해야만 하며 다를 경우 @Pathvariable 어노테이션의 value 속성값으로 요청자원의 변수명 설정 가능
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
		
	}	
	
	
//	게시글을 전달받아 REST_BOARD 테이블에 저장된 게시글을 변경하고 결과를 문자열로 응답하는 요청처리 메소드
//	 => 요청방식이 여러 개인 경우 method 속성값을 {} 안에 나열하여 선언
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT,RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	
//	게시글번호를 URL주소로 전달받아 REST_BOARD 테이블에 저장된 게시글을 삭제하고 결과를 문자열로 응답하는 요청처리 메소드
	@RequestMapping(value = "/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoarddelete(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
	

}

































