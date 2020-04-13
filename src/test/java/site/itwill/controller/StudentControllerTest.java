package site.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//** : 0개 이상 
//테스트 클래스에서는 컨트롤러를 검사하기 위한 목적으로 작성 - 비권장
// 컨트롤러의 메소드를 MockMvc객체를 통해 간접적으로 요청하여 메소드가 제대로 작동되는 결과유무를 ModelAndView에 잘 전달되는지 확인 가능

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//와일드 문자(*)를 이용하여 Bean Configuration File 설정 가능
// => ** 형태로 디렉토리를 표현하면 0개 이상으로 처리 , 간단히 처리하는 방법 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentControllerTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentControllerTest.class);
	
//	WebApplicationContext : Web Application에서 사용하는 Spring Container 기능의 객체
//	 						달라고하기 => @Autowired 인젝션
//	여기에 필드에 Spring Bean이 저장 
//	필요한이유 => 얘한테 MockMvc 객체만들어서 달라고 하기위해서 
	@Autowired
	private WebApplicationContext wac;
	
//	테스트 에서만 쓰는 객체
//	MockMvc : 요청과 응답기능을 가상으로 제공하기 위한 클래스
//	 		  이 클래스로 객체를 만들어쥼 , 얘를 이용하며 WAS한테 요청해서 요청처리 메소드가 호출되는 똑같은 기능을 하는 클래스 
	private MockMvc mvc;
	
//	@Before : 테스트 메소드 호출 전 실행될 명령을 작성하는 메소드에 설정하는 어노테이션 
	//		  초기화 메소드 선언할 때 사용 & 생성자 역할을 해쥼!!, JUnit꺼 가져다 사용하기 
	@Before
	public void setup() {
//		요청과 응답기능을 제공하는 객체를 반환받아 필드에 저장
		
//		특정컨트롤러에 있는 요청 메소드만 요청가능 => standaloneSetup(controllers)
//		모든컨트롤러에 있는 요청 처리메소드 요청 가능 		
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
		logger.info("MockMvc 객체 생성");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
//		MockMvc.perform(ReqeustBuilder requestBuild) : 가상으로 Front Controller에게 원하는 기능을 요청하는 메소드 - ResultActions 객체 반환
//		MockMvcRequestBuilders.get(String uri) : URL 주소를 전달하여 GET방식으로 요청하는 메소드 - requestBuild 객체를 반환
//		ResultActions.andReturn () : 요청처리 메소드의 호출 결과(MvcResult결과)를 반환하는 메소드
//		andReturn : 요청 후 결과를 반환해쥬세요
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		logger.info(result.getModelAndView().getViewName());
		logger.info(result.getModelAndView().getModel().toString());
	}

}












