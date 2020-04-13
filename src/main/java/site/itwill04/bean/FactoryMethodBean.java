package site.itwill04.bean;

//싱글톤 디자인 패턴을 적용하여 작성된 클래스, 즉 싱글톤 클래스
// 싱글톤 사용 목적 : 프로그램에 인스턴스를 하나만 제공하고 싶을 경우에 사용

//클래스를 사용하여 인스턴스 계속 생성하지만 , 가지고 있는 정보가 똑같을 경우 인스턴스는 하나만 필요하므로 싱글톤으로 작성 
//DAO클래스처럼 메소드만 가지고 있을 경우 프로그램에 메소드 호출을 위해 인스턴스 하나만 필요 => 메모리 효율 좋음

public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("★★★ FactoryMethodBean 클래스의 기본 생성자 호출 ★★★");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		System.out.println("●●● FactoryMethodBean 클래스의 getFactoryMethodBean() 메소드 호출 ●●●");
		return _bean;
	}

}
