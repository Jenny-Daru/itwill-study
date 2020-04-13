package site.itwill.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//데이터소스를 만들고 잘만들었는지 확인(test프로그램 사용)해야 정석!!! 그 후에 DAO 작성  
//데이터 소스, SqlSessionFactory나 SqlSession을 테스트 하지 않음 
// => ★Service클래스 메소드를 테스트시 많이 사용 
// => 이것이 잘되었다면 연결된 모든것(DAO,DataSource,SqlSessionFactory,SqlSession등)들이 다 잘된것이니~~★

//@RunWith : 테스트 클래스를 실행하기 위한 클래스(Clazz)를 설정하는 어노테이션 
//			  >> 이 테스트 클래스를 어떤걸로 실행할까요???라고 해쥬는거 
//SpringJUnit4ClassRunner : JUnit 기능을 이용하여 테스트 클래스를 실행하는 Runner(부모가 Interface)클래스 
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : 테스트 클래스에서 사용하기 위한 Spring Bean을 등록하는 Bean Configuration File을 설정하는 어노테이션
//						   => ApplicationContext 객체(Spring Container)를 이용하여 Spring Bean을 관리
// 							  웹어플리케이션 컨텍스트가 아니고 어플리케이션 컨텍스트가 컨텍스트에 존재하는 모든 자원에 접근 가능 즉, 모든 디렉토리 읽어들이기 가능
//						   locations 속성 : Bean Configuration File 경로를 배열 형식의 속성값으로 설정 
//											 => 배열타입이 들어가야하는데!! ★배열타입은 [] 아닌 {} 객체타입으로 사용★
//											 => Bean Configuration File 경로는 file 접두사를 사용하여 설정
//												어플리케이션 컨텍스트가 파일을 읽어 TEST프로그램 안에서 Spring Bean 생성해준다.
//											    src: 프로젝트 폴더안에!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class DataSourceTest {
//	대부분 테스트 프로그램의 관련 로그는 logger이용
//	file을 읽어들이면 데이터 소스가 만들어지는데 달라고만 하면됨
	private static final Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
//	파일에 데이터 소스가 여러개라면 @Qualifier이용
//	DataSource 관련 클래스의 Spring Bean을 제공받아 필드에 인젝션 처리
	@Autowired
	private DataSource dataSource;
	
//	테스트 메소드 작성
//	@Test : 테스트 메소드를 설정하는 어노테이션 
//			 => Runner 클래스에 의해 호출되어 실행되는 메소드 설정
//				일종의 main과 같은것, main과 다른점은 Test메소드 여러개 작성 가능!! >> Runner클래스가 메소드를 자동호출되어 명령실행(Test해쥼) 
//	         => 실행 : Ctrl + F11 >> JUnit로 실행하기 
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+dataSource);
		logger.info("Connection = "+dataSource.getConnection());
	}
	
//	마이밥티스 이용시 SqlSessionFactoryBean 이나 SqlSession이 잘 이용되는지 확인해보기 
//	 >> 필드 더 만들고 인젝션 시켜서 메소드 작성 후 실행하면 끝 
}















