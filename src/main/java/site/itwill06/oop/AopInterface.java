package site.itwill06.oop;

//로그를 기록하기 위한 메소드를 설정하기 위해 인터페이스를 선언
// => 메소드를 실행하기 전에 로그를 기록할겁니다~ 라고 설정해쥬는거
// 횡단관심코드가 삽입될 메소드를 추상메소드로 선언 >> ★PointCut★(어떤메소드가 호출될때 횡단관심코드가 삽입될것 입니다!!!)
//  => 이 메소드에 횡단관심 코드가 삽입되는것, 핵심관심코드에서 어떤 메소드에 횡단관심코드를 삽입할 것이냐를 선택하는 것 
public interface AopInterface {
	void display1();
	void display2();
	void display3();

}
