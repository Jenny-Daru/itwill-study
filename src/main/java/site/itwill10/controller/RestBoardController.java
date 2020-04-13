package site.itwill10.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;

@Controller
public class RestBoardController {
	
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
//	★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
//	게시글 목록을 Ajax로 요청
//	클라이언트 요청에 의해 게시글 목록을 JSON 형식의 문자열로 응답하는 요청처리 메소드
//	 => 게시글 목록을 페이징 처리하여 응답되도록 설정(페이지 번호 전달받는 것이 중요) 
//	 => defaultValue = "1"를 사용하여 페이지번호를 전달받지 않아도 기본적으로 1을 전달받아 에러없이 출력되도록 설정
//	 => 총게시글을 갯수를 알아야 페이징 처리 가능
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody //뷰페이지 응답하지 않을것 , 자동으로 객체로 반환
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
//		REST_BOARD 테이블에 저장된 게시글의 갯수를 검색하여 반환받아 저장
		int totalBoard=restBoardService.getRestBoardCount();
		
//		한페이지에 검색되는 게시글의 갯수를 임의로 설정
		int pageSize=5;
		
//		페이지 블럭에 출력될 페이지의 갯수를 임의로 설정
		int blockSize=5;
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		return null;
		
	}

}















