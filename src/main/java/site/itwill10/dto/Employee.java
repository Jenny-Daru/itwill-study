package site.itwill10.dto;

//JavaBean & DTO의 역할을 하는 클래스
// 필드에 입력값 저장 => 규칙 : 입력페이지의 name속성값 = 필드명

public class Employee {
//	입력값(String)을 전달받아 자동으로 정수값으로 변환하여 필드에 저장 
//	 => 정수값으로 변환 불가 : 400에러 / NumberFormatException 발생하지 않음 => 원래 유효성 검사해야함
	private int num;
	private String name;
	private Phone phone;
/*	
	private String phone1;
	private String phone2;
	private String phone3;
*/	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

/*
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getPhone3() {
		return phone3;
	}

	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
*/

	public Phone getPhone() {
		return phone;
	}

	public void setPhone(Phone phone) {
		this.phone = phone;
	}	

}
