package site.itwill02.factory;

//데이터를 처리하는 클래스는 반드시 팩토리 디자인 패턴이 들어간 인터페이스를 상속받아야한다.
public class HiMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hi!하잉!";
	}
	

}
