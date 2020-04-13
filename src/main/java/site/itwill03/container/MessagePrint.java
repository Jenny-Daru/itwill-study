package site.itwill03.container;

public class MessagePrint {
//	MessageObject 인터페이스를 상속받은 자식인스턴스를 저장하기 위한 필드
//	 => 포함관계(포함관계가 되기위해서는 필드에 인스턴스(자식인스턴스)가 저장되어 있어야한다!!)
//	 => 지금은 필드에 null 이지만 setter 메소드를 통해 변경
	private MessageObject object;

	public MessageObject getObject() {
		return object;
	}

	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		String message=object.getMessage();
		System.out.println("message : "+message);
	}


}
