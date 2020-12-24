import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import dao.DeptDao;
import model.Dept;

public class MainApp {
	

	
	
	public static void main(String[] args) {
		//추가(9);
		//삭제(1);
		//수정(8);
//		Dept dept = 찾기(10);
//		System.out.println(dept);

//List<Dept> depts = DeptDao.전체찾기(); //메서드가 static일때
		
		DeptDao dd = new DeptDao();
		List<Dept> depts = dd.전체찾기();

		
	}
}
