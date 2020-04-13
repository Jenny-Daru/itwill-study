package site.itwill10.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.RestBoardDAO;
import site.itwill10.dto.RestBoard;

// [Ajax와 페이징처리가 핵심]
@Service
public class RestBoardServiceImpl implements RestBoardService {
	
	@Autowired
	private RestBoardDAO restBoardDAO;

	@Transactional
	@Override
	public void addRestBoard(RestBoard board) {
		restBoardDAO.insertRestBoard(board);
	}

	@Transactional
	@Override
	public void modifyRestBoard(RestBoard board) {
		/* 이게 맞지만 일단 주석처리
//		변경하기 전 게시글 번호로 게시글을 검색하기
//		테이블에 저장된 정보를 이용하여 실행될 SQL 명령의 전달값에 대한 유효성 검사
//		 => 전달값에 대한 오류 발생시 인위적 예외 발생 
		if(restBoardDAO.selectRestBoard(board.getNum())==null) {
			throw new Exception("변경하려고 하는 게시글 업따요~");
		}
		*/
		restBoardDAO.updateRestBoard(board);
	}

	@Transactional
	@Override
	public void removeRestBoard(int num) {
		restBoardDAO.deleteRestBoard(num);
	}

	@Override
	public RestBoard getRestBoard(int num) {
		return restBoardDAO.selectRestBoard(num);
	}

	@Override
	public int getRestBoardCount() {
		return restBoardDAO.selectRestBoardCount();
	}

	@Override
	public List<RestBoard> getRestBoardList(Map<String, Object> map) {
		return restBoardDAO.selectRestBoardList(map);
	}

}













