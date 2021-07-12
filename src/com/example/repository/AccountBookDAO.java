package com.example.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.domain.AccountBookData;


public class AccountBookDAO {

	// DB접속 정보
	private final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String user = "myuser";
	private final String password = "1234";

	// DB접속 후 커넥션 객체 가져오는 메소드
	private Connection getConnection() throws ClassNotFoundException, SQLException {
		Connection con = null;

		// 1단계. 드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2단계.
		con = DriverManager.getConnection(url, user, password);
		return con;
	}

	private void close(Connection con, PreparedStatement pstmt) {
		close(con, pstmt, null);
	}

	private void close(Connection con, PreparedStatement pstmt, ResultSet rs) {
		// JDBC 자원 닫기 (사용자 역순으로 닫음)
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // close

	public void insertData(AccountBookData abData) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = getConnection();

			String sql = "";
			sql += "INSERT INTO accountbook (num, time, inout, categories, amount, memo) ";
			sql += "VALUES(seq_accountbook.nextval,?,?,?,?,?)";

			pstmt = con.prepareStatement(sql);
			pstmt.setTimestamp(1, abData.getTime());
			pstmt.setString(2, abData.getInout());
			pstmt.setString(3, abData.getCategories());
			pstmt.setInt(4, abData.getAmount());
			pstmt.setString(5, abData.getMemo());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con, pstmt);
		}
	}
	public int income() {
		int num = 0;;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="";
			sql += "SELECT sum(amount) as sum ";
			sql += "FROM accountbook ";
			sql += "WHERE inout = 'income'";
			
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				num = rs.getInt("sum");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		
		
		
		return num;
	}
	public int monthincome(int a,int b) {
		int num = 0;;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="";
			sql += "SELECT sum(amount) as sum ";
			sql += "FROM accountbook ";
			sql += "WHERE time >= '2021/"+ a +"/01' and time < '2021/"+(b+1)+"/01' and inout = 'income'";
			// time >= '2021/"+ a +"/01' and time < '2021/"+(b+1)+"/01
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				num = rs.getInt("sum");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		
		return num;
	}
	
	public int expenses() {
		int num = 0;;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="";
			sql += "SELECT sum(amount) as sum ";
			sql += "FROM accountbook ";
			sql += "WHERE inout = 'expenses'";
			
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				num = rs.getInt("sum");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		return num;
	}
	public int monthexpenses(int a, int b) {
		int num = 0;;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = getConnection();
			
			String sql ="";
			sql += "SELECT sum(amount) as sum ";
			sql += "FROM accountbook ";
			sql += "WHERE time >= '2021/"+ a +"/01' and time < '2021/"+(b+1)+"/01' and inout = 'expenses'";
		
			pstmt = con.prepareStatement(sql);
			
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				num = rs.getInt("sum");
			
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		return num;
	}
	public List<AccountBookData> getIncomeDatas() {
		List<AccountBookData> list = new ArrayList<>();
		
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;
		
		try {
			con= getConnection();
			
			String sql = "select * from accountbook where inout = 'income'";
			
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AccountBookData abData = new AccountBookData();
				abData.setNum(rs.getInt("num"));
				abData.setTime(rs.getTimestamp("time"));
				abData.setInout(rs.getString("inout"));
				abData.setCategories(rs.getString("categories"));
				abData.setAmount(rs.getInt("amount"));
				abData.setMemo(rs.getString("memo"));
				
				
				list.add(abData);
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		
		return list;
	}
	public List<AccountBookData> getExpensesDatas() {
		List<AccountBookData> list = new ArrayList<>();
		
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;
		
		try {
			con= getConnection();
			
			String sql = "select * from accountbook where inout = 'expenses'";
			
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AccountBookData abData = new AccountBookData();
				abData.setNum(rs.getInt("num"));
				abData.setTime(rs.getTimestamp("time"));
				abData.setInout(rs.getString("inout"));
				abData.setCategories(rs.getString("categories"));
				abData.setAmount(rs.getInt("amount"));
				abData.setMemo(rs.getString("memo"));
				
				
				list.add(abData);
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		
		return list;
	}
	
	public List<AccountBookData> getMonthDatas(int a, int b) {
		List<AccountBookData> list = new ArrayList<>();
		
		Connection con = null; // 접속
		PreparedStatement pstmt = null; // sql 문장객체 타입
		ResultSet rs = null;
		
		try {
			con= getConnection();
			
			String sql = "select * from accountbook where time >= '2021/"+ a +"/01' and time < '2021/"+(b+1)+"/01'";
			
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AccountBookData abData = new AccountBookData();
				abData.setNum(rs.getInt("num"));
				abData.setTime(rs.getTimestamp("time"));
				abData.setInout(rs.getString("inout"));
				abData.setCategories(rs.getString("categories"));
				abData.setAmount(rs.getInt("amount"));
				abData.setMemo(rs.getString("memo"));
				
				
				list.add(abData);
			} // while
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(con,pstmt,rs);
		}
		
		return list;
	}
}
