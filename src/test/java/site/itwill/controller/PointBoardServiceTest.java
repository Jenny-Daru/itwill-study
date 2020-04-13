package site.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;
import site.itwill10.service.PointBoardService;
import site.itwill10.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@FixMethodOrder : 테스트 메소드의 호출 순서를 설정하는 어노테이션 - ex ) 저장 후 삭제나 검색 가능
//					MethodSorters속성 : Enum자료형(상수필드 여러개)의 상수필드를 이용하여 호출순서 설정 
//									    =>1.MethodSorters.DEFAULT(기본) * 정확히 예측 불가 - 실행순서 부정확 (비권장)*
//										   : 테스트 메소드의 HashCode(메모리 주소를 보기 좋게 16진수 형태로 만든것-고유값존재)를 이용하여 호출순서 설정
//											  >> 차례대로 읽어들여 호출되어 실행, 메모리가 시퀀스로 저장되지만 실행은 때에따라 빈곳을 찾아 실행되는 경우 발생
//										  2. MethodSorters.JVM : JVM이 테스트 메소드를 불러온 순서대로 호출순서 설정 * 예측 불가 *
//										  3. MethodSorters.NAME_ASCENDING : 테스트 메소드의 이름을 오름차순으로 하여 호출순서 설정 * 정확히 예측 가능 *
//											  >> 메소드명 알파벳 순서로 호출되지만 숫자를 부여하여 순서대로 호출가능하게 하는것이 좋음!!
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	@Autowired
//	사용자 정보를 읽어들이는 필드 선언 - Test위해
	private PointUserService pointUserService;
/*
	@Test
	public void testAddPointUser() {
		PointUser user=new PointUser();
		user.setId("Daru");
		user.setName("꿍다루");
		
//		저장된 사용자 유저 반환, 테이블에 저장 후 잘 되었는지 확인~
		PointUser addUser=pointUserService.addPointUser(user);
//		PointBoardService메소드 확인하기 위해서는 사용자 정보가 필요하기 때문에 사용자를 먼저 확인!!
		logger.info("아이디 = "+addUser.getId()+", 이름 = "+addUser.getName()+", 포인트 = "+addUser.getPoint());
		
//		한번실행 후 이미 insert된 정보기 때문에 재실행 한다면 인위적 예외가 발생하여 하단의 명령 실행 정지 
	}
	*/
	
//	이제부터 진짜 Test하고 싶은거 시작
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
//	pointBoard에 게시글을 저정하기 위해 만들어진 서비스메소드 호출하여 테스트
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		board.setWriter("XXX");
		board.setSubject("나는 엑스맨~");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
		
	}
	
/*
	@Test
//	게시글을 삭제
	public void testErasePointBoard() {
		PointUser user= pointBoardService.erasePointBoard(1);
		logger.info("아이디 = "+user.getId()+", 이름 = "+user.getName()+", 포인트 = "+user.getPoint());
		
	}
	
 */
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		for(PointBoard board:boardList) {
			logger.info("글번호 = "+board.getNum()+", 작성자 = "+board.getWriter()+", 글제목 = "+board.getSubject());
		}
	}
}



















