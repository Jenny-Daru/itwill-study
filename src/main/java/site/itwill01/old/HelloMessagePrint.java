package site.itwill01.old;

//helloMessage를 출력하는 메소드
// 어플리케이션 작성에 필요한 기능을 제공하기 위한 클래스 => 모듈
// => 모듈이 여러개 모여있는 집합체 => 컴퍼넌트 (다양한 기능을 제공)

// DAO에서 발생하는 많은 오류들이 있기 때문에 어플리케이션에서는 DAO를 가져다 사용하지 않고
//  service클래스를 가져다 사용함!!
//  => 제대로 동작하지 않으면 예외처리~~ MVC생각해라 
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject hello=new HelloMessageObject();
		String message=hello.getHelloMessage();
		System.out.println("message : "+message);
	}

}

