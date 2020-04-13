package site.itwill00.log;

public class HelloWorldApp {
//	호출하지 않아도 JVM에 의해 알아서 호출됨
//	Java는 클래스로 인스턴스를 만들고 그 인스턴스로 메소드를 호출하여 원하는 결과를 출력하면 그것이 끝 
	public static void main(String[] arg) {
//		메소드가 시작되고 종료되는것을 기록 >> 많아질수록 가독성이 떨어짐 >> 
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 시작");
		HelloWorld hw=new HelloWorld();
		
		String message = hw.hello("꿈다루");
		System.out.println("message = "+message);
		System.out.println("HelloWorldApp 클래스의 main 메소드 - 종료");
	}

}
