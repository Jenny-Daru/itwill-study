package site.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.UserinfoDAO;
import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;

@Service
public class UserinfoServiceImpl implements UserinfoService {
	
	@Autowired
	private UserinfoDAO userinfoDAO;

	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws UserinfoExistsException {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {    // 아이디가 중복된다면
			throw new UserinfoExistsException(userinfo, "이미 사용중인 아이디얌!");
		}
		
//		입력되어 전달된 비밀번호는 암호화 처리하여 변경
//		 => 암호화 처리해주는 라이브러리 빌드 pom.xml
//		 => 요청처리 메소드 또는 JavaBean(DTO) 클래스의 Setter 메소드에서 작업이 가능
//		BCrypt.hashpw(String password, String salt) 
//		 : 전달받은 비밀번호에 첨가물을 이용하여 암호화 처리하여 반환하는 메소드
//		   => 똑같은 비밀번호라 하더라도 서로 다르게 암호화 처리됨
//		BCrypt.gensalt(int log_rounds)
//		 : 첨가물의 길이를 전달받아 첨가물을 생성하여 반환하는 메소드
//		   => 매개변수에 첨가물의 길이 전달 생략 가능 - 기본값 존재(10)
		userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt(10)));
//		회원상태는 1(일반계정)으로 변경 , 변경하지 않으면 기본값(0)이 들어가므로 NOOOOOOOOO!!!
		userinfo.setStatus(1);
		
		userinfoDAO.insertUserinfo(userinfo);
 	}

	@Transactional
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 업쬬!");
		}
		String password=userinfo.getPassword();
		if(password!=null &&!password.equals("")) {
			userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt()));
		}
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 업쬬!");
		}		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException{
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("아이디의 회원정보가 업쬬!");
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

//	인증처리 메소드 : 예외가 발생되면 인증 실패, 예외가 발생되지 않으면 인증 성공
	@Override
	public void loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		if(authUserinfo==null) {
			throw new LoginAuthFailException(userinfo.getUserid(), "아이디의 회원정보가 업쬬!");
		}
		
//		BCrypt.checkpw(String plaintext, String hashed) 
//		 : 일반 문자열과 암호화 처리된 문자열을 비교하여 같은 경우 true를 반환하는 메소드
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException(userinfo.getUserid(), "아이디가 없거나 비밀번호 다루거든???");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
