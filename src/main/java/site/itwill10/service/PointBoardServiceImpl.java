package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.PointBoardDAO;
import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;

//Service 클래스의 메소드에서 예외가 발생된 경우 예외 발생 전 실행된 모~~~~든 DAO 클래스 메소드의 SQL명령(select 상관없음, INSERT,UPDATE,DELETE)은
// ★반드시★ ROLLBACK 처리되도록 작성 => Spring에서는 트랜젝션을 일관성 있게 처리할 수 있도록 TransactionManager 관련 클래스 제공
//  => spring-tx라이브러리를 사용(spring-jdbc 라이브러리 빌드하면 자동으로 빌드됨) 


//PointBoardServiceImpl => 핵심관심 코듈
//=> 횡단관심 모듈 (advice클래스 존재해야하지만 만들지 않음. 트랜젝션 매니저가 그 역할을 할것 !! )
@Service
public class PointBoardServiceImpl implements PointBoardService {
	
	@Autowired
	private PointBoardDAO pointBoardDAO;
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
//	게시글 정보를 전달받아 POINTBOARD 테이블에 저장하고 작성자 정보를 반환하는 메소드 
//	 => 게시글 작성자를 전달하여 POINTUSER테이블의 사용자 정보의 포인트가 증가되도록 작성
//	    게시글을 저장되면 포인트가 올라가고 그 포인트로 등급 상승!!
	@Transactional
	@Override
	public PointUser addPointBoard(PointBoard board) {
//		게시글 저장 전 작성자로 사용자를 검사하고 사용자가 없는 경우 - 이상한 경우
		
//		이명령이 먼저 실행되면 존재하지 않는 작성자의 게시글이 저장될 수 있고~ 
//		그럼 밑에 명령에서 존재하지 않는 작성자 이고, 작성자가 없으니 포인트도 증가시킬수 없음!! 
//		 예외 발생 => 해결 ) 트랜젝션 매니저를 이용하여 롤백처리 
		pointBoardDAO.insertPointBoard(board);
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("존재하지 않는 작성자 입니당!");
		}
		/*
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("존재하지 않는 작성자 입니당!");
		}
		*/
		pointUserDAO.updatePointUserPlus(board.getWriter());
		return pointUserDAO.selectPointUser(board.getWriter());
	}

//	게시글 번호를 전달받아 POINTBOARD 테이블에 저장된 게시글을 삭제하고 작성자를 반환하는 메소드
//	 => 게시글 작성자를 전달하여 POINTUSER테이블에 저장된 사용자의 포인트가 감소되도록 작성
//	     걍 메소드 호출하면 됨
	@Transactional
	@Override
	public PointUser erasePointBoard(int num) {
//		게시글 작성자와 로그인작성자 같아야 삭제해야함 
		PointBoard board=pointBoardDAO.selectPointBoard(num);
		if(board==null) {
			throw new RuntimeException("존재하지 않는 게시글 입니당!");
		}
		String writer=pointBoardDAO.selectPointBoard(num).getWriter();
		pointBoardDAO.deletePointBoard(num);
		pointUserDAO.updatePointUserMinus(writer);
		return pointUserDAO.selectPointUser(writer);
	}

//	POINTBOARD 테이블에 저장된 모든 게시글을 검색하여 반환하는 메소드
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}



















