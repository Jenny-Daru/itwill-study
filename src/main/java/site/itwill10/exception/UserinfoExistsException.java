package site.itwill10.exception;

import site.itwill10.dto.Userinfo;

//회원시 사용자가 입력한 아이디가 이미 존재할 경우 발생되는 예외클래스 
//에이젝스로 중복유무 검사 해도 상관없음 
public class UserinfoExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
//	Exception을 직접 처리하지 않고 ExceptionHandler에게 처리 주기
	
//	ExceptionHandler(예외처리메소드) 에게 예외 발생 관련 정보를 전달하기 위한 필드
//	메세지와 함께 입력페이지에 userinfo 정보를 전달하기위해 
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	
//	ExceptionHandler에게 사용자 정보와 예외메세지를 전달 => ExceptionHandler가 예외처리와 예외정보 제공, 사용자에게 view해쥼 
	public UserinfoExistsException(Userinfo userinfo, String message) {
		super(message);
		this.userinfo = userinfo;
	}

	public UserinfoExistsException(Userinfo userinfo) {
		super();
		this.userinfo = userinfo;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
