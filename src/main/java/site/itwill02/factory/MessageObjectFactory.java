package site.itwill02.factory;

// Factory 디자인 패턴이 적용된 클래스 : Factory 클래스 또는 provider 클래스
// => 개발자가 원하는 클래스로 대신 인스턴스를 생성하여 반환해주는 클래스 
// => 싱글톤 클래스로 작성하는 것을 권장 (물건을 만들어주는 공장이 하나만 있어도 되는거처럼... )
public class MessageObjectFactory {
	public static MessageObjectFactory _factory;
	
	public MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}

	
//	개발자가 원하는 클래스로 인스턴스를 생성하여 반환하는 메소드
//	 => 인터페이스를 반환형으로 선언한 경우 자식인스턴스를 반환 
//  인스턴스는 자식으로 생성하지만 저장은 부모로할 것 
	
//	static메소드로 해도 상관없지만 가독성이 떨어짐 => 일반메소드로 작성 => 싱글톤 추천
	
	public MessageObject getMessageObject() {
//		얘가 객체를 대신 만들어줌 => 이것이 IOC
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new ByeMessageObject();
		return object;
	}
	
	
}
