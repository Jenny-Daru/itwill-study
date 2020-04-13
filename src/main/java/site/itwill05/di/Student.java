package site.itwill05.di;

//어떤 관점에서 보느냐에 따라 이름이 달라진다. 
//학생정보를 저장하기 위한 클래스 : VO , DTO(JDBC-DAO에서 가져다 사용하기 위한 클래스), JavaBean(WEB에서 사용자 입력값을 저장하기 위한 클래스)
public class Student {
//	값들을 저장하기 위한 필드(정보)
	private int num;
	private String name;
	private String email;
	
//	생성자는 오버로드 가능 (매개변수만 다르다면)
	public Student() {
		System.out.println("### Student 클래스의 기본 생성자 호출 ###");
	}

	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student 클래스의 매개변수(학번)가 선언된 생성자 호출 ###");
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student 클래스의 매개변수(학번,이름)가 선언된 생성자 호출 ###");
	}

	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student 클래스의 매개변수(학번,이름,이메일)가 선언된 생성자 호출 ###");
	}

//	은닉화 되어 있는 필드에 대한 setter,getter >> 이것을 통해 접근가능
//	 => 접근할 수 없도록 숨기는 것 (필드와 메소드 은닉화 가능)
//   => 캡슐화 (객체자체가 값을 가지거나 기능을 가지는것) // 객체지향과 자바의 캡슐화의 개념은 좀 달라 
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("### Student 클래스의 setNum(int num) 메소드 호출 ###");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("### Student 클래스의 setName(String name) 메소드 호출 ###");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("### Student 클래스의 setEmail(String email) 메소드 호출 ###");
	}
	
	@Override
		public String toString() {
			return "학번 = "+num+", 이름 = "+name+", 이메일 = "+email;
		}
	

	
	
	
}
