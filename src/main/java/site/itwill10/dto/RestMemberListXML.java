package site.itwill10.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//반드시 getter/setter 선언해야함 !!!
//회원정보를 저장하는 List필드가 선언된 클래스
@XmlRootElement(name = "member_list")
@XmlAccessorType(XmlAccessType.FIELD)
public class RestMemberListXML {
//	memberList안에 member엘리먼트가 여러개 존재, member엘리먼트에는 id,address,name이 존재
//	List 필드에 저장된 요소를 자식 엘리먼트로 표현
//	 => 요소의 갯수만큼 자식 엘리먼트 생성
	@XmlElement(name = "member")
	private List<RestMemberXML> restMemberList;
	
	public RestMemberListXML() {
		// TODO Auto-generated constructor stub
	}

	public List<RestMemberXML> getRestMemberList() {
		return restMemberList;
	}

	public void setRestMemberList(List<RestMemberXML> restMemberList) {
		this.restMemberList = restMemberList;
	}
	
	
}
