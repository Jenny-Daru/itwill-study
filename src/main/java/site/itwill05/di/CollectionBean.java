package site.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
//	인스턴스를 저장하는 변수는 부모로 작성하는 것을 권장 => 유지보수에 훨~~~편하지
	private List<String> nameList;
	private Set<String> nameSet;
//	List에 Login, Logout, List다 저장하고싶어 => 인터페이스 만들어라 (controller)
//	제네링의 자료형을 인터페이스로 설정할 경우 자식 인스턴스를 콜렉션 요소로 저장가능
//	private List<LoginController> controllerList;
	private List<Controller> controllerList;
	
	private Set<Controller> controllerSet;
	
//	키를 통해 저장	
	private Map<String, Controller> controllerMap;
	
//	Properties : 콜렉션과 동일한 기능, 값저장 불가 // 파일을 읽어들여 load메소드를 통해 값저장 // 키를 통해 저장가능한 것이 문자열만 가능 
//				 내부적으로는 Map이 부모 , Map형태의 객체 => Map이 가지고 있는 메소드 사용 가능 
	private Properties properties;
	
	public CollectionBean() {
		System.out.println("### CollectionBean 클래스의 기본 생성자 호출 ###");
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

//	Set에 대한 setter,getter
	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

//	Controller에 대한 setter.getter
	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	
//	controllerMap에 대한 setter,getter

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

//	properties에 대한 setter,getter
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
	
	
	
	

}
