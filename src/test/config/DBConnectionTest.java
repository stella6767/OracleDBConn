package test.config;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;

import org.junit.Test;

import config.DBConnection;

public class DBConnectionTest {
	@Test //junit
	public void 데이터베이스연결_테스트() {
		Connection conn = DBConnection.getInstance();
		Connection conn2 = null;
		assertNotNull(conn);
		//assertNotNull(conn2); //이걸로 테스트, 빨간색이면 널임
		
	}
}
