package site.itwill03.container;

//팩토리에서 만들어진 인스턴스를 같은 저장소에 저장해야하기 때문에 인터페이스 사용
// => 스프링을 사용하여도 인터페이스 적용
public interface MessageObject {
	String getMessage();

}
