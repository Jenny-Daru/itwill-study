package site.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("★★★ InitDestroyMethodBean() 클래스의 기본 생성자 호출 ★★★");
	}
	
//	인스턴스 생성 후 초기화 작업을 위해 한번만 호출하기 위한 메소드 ~ ~ 로 사용하고 싶다.
	public void init() {
		System.out.println("●●● InitDestoryMethodBean의 init() 메소드 호출 ●●●");
	}
	
//	인스턴스 소멸 전 마무 작업을 위해 한번만 호출하기 위한 메소드 ~ ~ 로 사용하고 싶다.
	public void destroy() {
		System.out.println("●●● InitDestoryMethodBean의 destroy() 메소드 호출 ●●●");
	}
	
	public void display() {
		System.out.println("●●● InitDestoryMethodBean의 display() 메소드 호출 ●●●");
	}

}
