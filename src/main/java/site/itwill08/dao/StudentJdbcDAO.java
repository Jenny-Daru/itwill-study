package site.itwill08.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

//Bean Configuration File을 이용하여 등록된 Spring Bean은 기본적으로 Singleton으로 제공
// => 싱글톤 디자인 패턴을 적용한 클래스로 작성 불필요
public class StudentJdbcDAO implements StudentDAO {
//	Bean Configuration File에서 DataSource 관련 Spring Bean(08_dao.xml에 Spring제공과 Apache제공 2개존재)을 필드에 Injection  =>  DI(Dependency Injection)
//	 => Injection 처리된 DataSource로부터 Connection 인스턴스를 제공받아 사용
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

//	Injection을 위해 setter필요
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	@Override
	public int insertStudent(Student student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="insert into student values(?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, student.getNo());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getPhone());
			pstmt.setString(4, student.getAddress());
			pstmt.setString(5, student.getBirthday());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error]insertStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return rows;
	}
	
	@Override
	public int updateStudent(Student student) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="update student set name=?, phone=?, address=?, birthday=? where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getPhone());
			pstmt.setString(3, student.getAddress());
			pstmt.setString(4, student.getBirthday());
			pstmt.setInt(5, student.getNo());
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error]updateStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return rows;
	}
	
	@Override
	public int deleteStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		int rows=0;
		try {
			con=dataSource.getConnection();
			
			String sql="delete from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rows=pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("[error]deleteStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return rows;
	}
	
	@Override
	public Student selectStudent(int no) {
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=null;
		try {
			con=dataSource.getConnection();
			
			String sql="select * from student where no=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs=pstmt.executeQuery();
			
//			매핑처리
			if(rs.next()) {
				student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
			}
			
		} catch (SQLException e) {
			System.out.println("[error]selectStudent() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return student;
	}
	
	@Override
	public List<Student> selectStudentList(){
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Student student=null;
		List<Student> studentList=new ArrayList<Student>();
				
		try {
			con=dataSource.getConnection();
			
			String sql="select * from student order by no";
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				student=new Student();
				student.setNo(rs.getInt("no"));
				student.setName(rs.getString("name"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setBirthday(rs.getString("birthday"));
				studentList.add(student);
			}
			
		} catch (SQLException e) {
			System.out.println("[error]selectStudentList() 메소드의 SQL 오류 = "+e.getMessage());
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return studentList;
	}
	
	
}
















