package site.itwill10.exception;

//회원 인증실패시 발생되는 예외 클래스 
public class LoginAuthFailException extends Exception {

	private static final long serialVersionUID = 1L;
	
//	입력페이지에 아이디를 다시 전달하기위해 
	private String userid;
	
	public LoginAuthFailException() {
		// TODO Auto-generated constructor stub
	}

	public LoginAuthFailException(String userid, String message) {
		super(message);
		this.userid = userid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
