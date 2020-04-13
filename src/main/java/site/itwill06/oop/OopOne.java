package site.itwill06.oop;

public class OopOne {
//	중복된 코드 최소화 하는 방법
//	메소드의 중복된 코드가 존재할 경우 : 중복되는 코드가 작성된 메소드를 선언하여 호출하여 사용 
//	 => 중복코드를 최소화하여 유지보수의 효율성 증가
	/*
	public void beforeLog() {
		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
	}
	*/
	
//	OopOne과 OopLogger은 is a, has a도 아닌관계!! 관계설정이 될 수 없는데 중복된 코드를 최소화하기 위해서 일부러 맺어쥰 관계
//	 => 객체지향의 기본적인 관계를 벗어난것, 객체지향으로 볼수 없는것이 정석임!!! 
//	 => 객체지향은 관계를 맺기위한 조건이 존재해야함 
//	 => AOP를 사용하면 중복된 코드를 최소화하고, 객체지향 개념을 위반하지 않고 작성하는 방법!!
	private OopLogger logger=new OopLogger();
	
	public void display1() {
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display1()메소드의 명령 실행 ***");
	}
	
	public void display2() {
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display2()메소드의 명령 실행 ***");
	}	
	
	public void display3() {
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne 클래스의 display3()메소드의 명령 실행 ***");
	}	
	
}
