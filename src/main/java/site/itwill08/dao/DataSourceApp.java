package site.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Data Suorce를 얻어오는 클래스 작성
//Bean Configuraion File을 읽어 Spring Bean 사용
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		
		System.out.println("========================================================================================");
		
		DataSource apacheDataSource=context.getBean("apacheDataSource", DataSource.class);
		Connection apacheConnection=apacheDataSource.getConnection();
//		SQLException 발생 >> 원래는 try~catch 하지만 떠넘기기 
		System.out.println("Apache Connection = "+apacheConnection);
		
		System.out.println("========================================================================================");
		
		DataSource springDataSource=context.getBean("springDataSource", DataSource.class);
		Connection springConnection=springDataSource.getConnection();
		System.out.println("Spring Connection = "+springConnection);
		
		
		((ClassPathXmlApplicationContext)context).close();
		
		
	}

}
