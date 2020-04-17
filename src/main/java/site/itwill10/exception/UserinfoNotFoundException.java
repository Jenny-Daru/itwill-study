package site.itwill10.exception;

//회원정보 검색시 아이디의 회원정보가 존재하지 않을 경우 발생되는 예외 클래스  
// Mapper에서 아이디를 전달받아 회원정보를 검색하는데 해당 회원이 검색되지 않을경우 발생 => 삭제전 검색이나 변경전 검색시 사용
public class UserinfoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}	
	

}
