package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.DBConnection;
import model.Dept;

//Data Access Object(데이터에 접근하게 해주는 객체)
//static 함수에 붙이는 건 혼자 쓸 때만, 동시접근을 막기 위해
//전부 다 new해서
public class DeptDao {

	public void 추가(int id) { // static

		// 아주 보안에 안 좋은 코드
		// 작대기 두개도 못 막고, or 들어오는 것도 못 막음
//		if (id.contains(("--")) return;
//		String sql = "INSERT INTO test1(id) VALUES("+id+")";

		// ? 가 보안에 좋으니 써라.
		String sql = "INSERT INTO test1(id) VALUES(?)";
		Connection conn = DBConnection.getInstance();
		try {
//			PrintWriter pw = new PrintWriter(conn.geti)
//			pw.print
//			pw.flush
//										
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴 - 1값은 오류시에만 리턴
			System.out.println("result: " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 삭제(int id) {

		String sql = "DELETE FROM test1 WHERE id = ?";
		Connection conn = DBConnection.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴 - 1값은 오류시에만 리턴
			System.out.println("result: " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void 수정(int id) {

		String sql = "UPDATE test1 SET id = ? ";
		Connection conn = DBConnection.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			int result = pstmt.executeUpdate(); // 변경된 row count를 리턴 - 1값은 오류시에만 리턴
			System.out.println("result: " + result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Dept 찾기(int deptno) {

		String sql = "SELECT deptno,dname,loc FROM dept WHERE deptno=? ";
		Connection conn = DBConnection.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, deptno);

//----------------------방법 2 ---------------------------------			

			// 커서 한 칸씩 내리면서 찾아야한다.
			ResultSet rs = pstmt.executeQuery();
			// 일단 시작시 가리키는 위치를 한칸 내림
			if (rs.next()) {
				Dept dept = Dept.builder().deptno(rs.getInt("deptno")).dname(rs.getString("dname"))
						.loc(rs.getString("loc")).build();
				System.out.println(dept);
				return dept;

				// ---------------------방법 1-----------------------------------

//				int deptno2 = rs.getInt("deptno"); //실수의 여지를 줄이기 위해 변수에 넣음 
//				String dname = rs.getString("dname");
//				String loc = rs.getString("loc");
//				System.out.println(deptno2);
//				System.out.println(dname);
//				System.out.println(loc);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<Dept> 전체찾기() {
		String sql = "SELECT deptno,dname,loc FROM dept";
		Connection conn = DBConnection.getInstance();

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
//			pstmt.setInt(1, deptno); //물음표 완성필요없음

			ResultSet rs = pstmt.executeQuery();
			ArrayList<Dept> depts = new ArrayList<>();
			while (rs.next()) {
				Dept dept = Dept.builder().deptno(rs.getInt("deptno")).dname(rs.getString("dname"))
						.loc(rs.getString("loc")).build();
				// System.out.println(dept);
				depts.add(dept);
			}

			return depts;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
