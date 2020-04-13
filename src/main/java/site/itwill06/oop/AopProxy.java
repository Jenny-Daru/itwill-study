package site.itwill06.oop;

//Proxy 클래스 : 핵심관심모듈과 횡단관심모듈을 결합하기 위한 클래스 - Aspect
//				  => 핵심관심코드에 횡단관심코드를 삽입한 메소드를 선언
//핵심관심코드를 기준으로 횡단관심코드를 삽입하는 메소드 작성
public class AopProxy implements AopInterface {

//	핵심관심 모듈을 저장하기 위한 필드, AopInterface를 상속받은 자식인스턴스 저장 가능
	private AopInterface target;

//	횡단관심 모듈을 저장하기 위한 필드
	private AopLogger logger;
	
//	핵심관심모듈과 횡단관심모듈을 전달받아 필드에 저장하는 생성자
	public AopProxy(AopInterface target) {
	this.target = target;
	this.logger=new AopLogger();
}

//	횡단관심코드를 핵심관심코드 전에 삽입한 메소드 - 삽입 위치 설정 : JoinPoint
//	 => 핵심관심코드와 횡단관심코드가 하나로 이루어진것, 실행될때 합쳐지는것 Weaving(결합)
//	 => weaving된 메소드들이 존재하는 클래스 - Proxy클래스
	@Override
	public void display1() {
//		횡단관심코드
		logger.beforeLog();
//		핵심관심코드
		target.display1();
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
		
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
