package site.itwill08.dao;

//STUDETN테이블에 저장하는 필드 생성
// => MyBatis가 아니므로 필드명과 컬럼명 같지 않아도 무관 
/*

이름       널?       유형           
-------- -------- ------------ 
NO       NOT NULL NUMBER(4)    
NAME              VARCHAR2(20) 
PHONE             VARCHAR2(15) 
ADDRESS           VARCHAR2(50) 
BIRTHDAY          DATE         

 */
public class Student {
	private int no;
	private String name;
	private String phone;
	private String address;
	private String birthday;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	

}
