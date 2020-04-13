package site.itwill02.factory;

// 인터페이스를 상속받아 메소드를 오버라이드 해야하지만 하기싫으면 추상클래스로 만들어줘야함 .
public class HelloMessageObject implements MessageObject {

	@Override
	public String getMessage() {
		return "Hello!헬로!";
	}
	

}
