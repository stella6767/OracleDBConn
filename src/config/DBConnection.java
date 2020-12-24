package config;

import java.sql.Connection;
import java.sql.DriverManager;

import oracle.jdbc.driver.OracleDriver;

public class DBConnection {
	
	public static Connection getInstance() {
		Connection conn = null;
		//thin 과 oci의 차이
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "SCOTT";
		String password = "TIGER";
		
			
		//OracleDriver 클래스를 메모리에 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//OracleDriver c = new OracleDriver();
			conn = DriverManager.getConnection(url, username, password);
			System.out.println("DB연결 성공");
			return conn;
		} catch (Exception e) {
			// 문자열 입력부분은 틀릴 수 있으므로 보통 try-catch 강제
			e.printStackTrace();
		}
		System.out.println("DB연결 실패");
		return null;
	}		
	
}
