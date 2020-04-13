package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
//	사용자 정보를 전달받아 POINTUSER테이블에 저장하고 저장된 사용자 정보를 검색하여 반환하는 메소드
	@Override
	public PointUser addPointUser(PointUser user) {
//		값이 저장되기전에 validation을 이용하여 검사 가능하지만 DB에 관련된 검사는 여기서 가능 
//		테이블에 값이 저장되었는지 확인!!   ♥♥♥♥♥♥♥♥♥♥형식 : 컨트롤러에서 / DB 관련 : Service에서 검사(예외처리)♥♥♥♥♥♥♥♥♥♥
//		전달된 사용자의 아이디 중복 유무를 검사 - 중복된 경우 : 인위적 예외 발생 (우리가 만든 예외??예외클래스 만들어서 사용......)
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
//			실행하는 모든 오류 다잡아냄 포괄적..
			throw new RuntimeException("이미 사용중인 아이디 지롱");
		}
//		예외가 발생될 경우 하단에 존재하는 명령 미실행
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}
