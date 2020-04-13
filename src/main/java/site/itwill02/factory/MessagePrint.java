package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
//		Factory클래스로부터 인스턴스를 제공받아 저장 - IOC
//		 => 인터페이스를 상속받은 자식인스턴스가 반환
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		
//		인터페이스를 이용하여 메소드를 호출한 경우 자식 인스턴스에 메소드 호출
//		 => 객체의 형변환, 오버라이드에 의한 다형성
		String message=object.getMessage();
		System.out.println("message : "+message);
	}

}
