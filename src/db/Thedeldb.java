package db;

import java.sql.*;

import dto.ThedelTB;

public class Thedeldb {
	// try 없는 버전
	public static Connection condb() throws Exception {
		Connection conn = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection(DBConfig.DB_URL, DBConfig.DB_USER, DBConfig.DB_PW);
		return conn;

	}

	// 연결
	public static void conTest() throws Exception {
		// Connection 객체를 자동완성으로 import할 때는 com.mysql.connection이 아닌
		// java 표준인 java.sql.Connection 클래스를 import해야 한다.
		Connection conn = null;
		try {
			// 1. 드라이버 로딩
			// 드라이버 인터페이스를 구현한 클래스를 로딩
			// mysql, oracle 등 각 벤더사 마다 클래스 이름이 다르다.
			// mysql은 "com.mysql.jdbc.Driver"이며, 이는 외우는 것이 아니라 구글링하면 된다.
			// 참고로 이전에 연동했던 jar 파일을 보면 com.mysql.jdbc 패키지에 Driver 라는 클래스가 있다.

			// 2. 연결하기
			// 드라이버 매니저에게 Connection 객체를 달라고 요청한다.
			// Connection을 얻기 위해 필요한 url 역시, 벤더사마다 다르다.
			// mysql은 "jdbc:mysql://localhost/사용할db이름" 이다.

			// @param getConnection(url, userName, password);
			// @return Connection
			conn = Thedeldb.condb();
		} catch (SQLException e) {
			System.out.println("에러: " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 데이터 넣기
	public static void insert(String a, String b, int c){
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = Thedeldb.condb();
			String sql = "INSERT INTO user_tbl VALUES (?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, a);
			pstmt.setString(2, b);
			pstmt.setInt(3, c);

			int count = pstmt.executeUpdate();
			if (count == 0) {
				System.out.println("데이터 입력 실패");
			} else {
				System.out.println("데이터 입력 성공");
			}
		} catch (Exception e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 데이터 넣기
	public static void insert(int a, int b){
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = Thedeldb.condb();
			String sql = "INSERT INTO num_tb VALUES (?,?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, a);
			pstmt.setInt(2, b);
			
			int count = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 테이터 조건 보기
	public static String select(String a) {

		Connection conn = null;
		PreparedStatement pstmt = null; // 쿼리 생성
		ResultSet rs = null;
		ThedelTB TB = new ThedelTB();
		
		try {

			conn = Thedeldb.condb();
			String sql = "SELECT id FROM user_tbl WHERE id = ?";
			
			
			pstmt = conn.prepareStatement(sql); // 조건을 만족하는 행만 출력

			pstmt.setString(1, a);
			rs = pstmt.executeQuery();

			if (rs.next()) {

				String code = rs.getString(1);
				TB.setCode(code);

			}

		}

		catch (Exception e) {

			System.out.println(e.getMessage());

		}

		finally {

			try {

				pstmt.close();

				conn.close();

			} catch (Exception e) {

				System.out.println(e.getMessage());

			}

		}
		String id = TB.getCode();
		return id;
	}
	public static int ps(String a) {
		
		Connection conn = null;
		PreparedStatement pstmt = null; // 쿼리 생성
		ResultSet rs = null;
		ThedelTB TB = new ThedelTB();
		try {
			
			conn = Thedeldb.condb();
			String sql = "SELECT getpoint FROM user_tbl WHERE id = ?";
			
			
			pstmt = conn.prepareStatement(sql); // 조건을 만족하는 행만 출력
			
			pstmt.setString(1, a);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				int code = rs.getInt(1);
				TB.setHap(code);
				
			}
			
		}
		
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
		finally {
			
			try {
				
				pstmt.close();
				
				conn.close();
				
			} catch (Exception e) {
				
				System.out.println(e.getMessage());
				
			}
			
		}
		int code = TB.getHap();
		return code;
	}

	// 테이터 전체 보기
	public static void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = Thedeldb.condb();
			String sql = "SELECT * FROM num_tb";
			pstmt = conn.prepareStatement(sql); // 쿼리생성
			rs = pstmt.executeQuery(); //쿼리에 익스큐트

			System.out.println("num1" + " " + "num2");
			while (rs.next()) {
				int num1 = rs.getInt("num1");
				int num2 = rs.getInt("num2");
				System.out.println(num1 + "   " + num2);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (Exception e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				} // 열린 순서대로 닫아줘야함
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// 테이터 전체 보기
	public static int userselect(String a) {
		ThedelTB tb = new ThedelTB();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int point;
		try {
			conn = Thedeldb.condb();
			String sql = "SELECT getpoint FROM user_tbl WHERE id =?";
			pstmt = conn.prepareStatement(sql); // 쿼리생성
			pstmt.setNString(1, a);
			rs = pstmt.executeQuery(); //쿼리에 익스큐트
			
			if (rs.next()) {
				point = rs.getInt("getpoint");
				tb.setPoint(point);
			}
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (Exception e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
				if (conn != null && !conn.isClosed()) {
					conn.close();
				} // 열린 순서대로 닫아줘야함
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		point = tb.getPoint();
		return point; 
	}

	// 데이터 삭제
	public static void delret() {
		Connection conn = null; // 데이터 베이스와 연결을 위한 객체
		PreparedStatement pstmt = null; // SQL 문을 데이터베이스에 보내기위한 객체

		// 1. JDBC Driver Class - com.mysql.jdbc.Driver

		// 2. 데이터베이스에 연결하기 위한 정보

		String SQL = "delete from num_tb";

		try {
			// 1. JDBC 드라이버 로딩 - MySQL JDBC 드라이버의 Driver Class 로딩

			// 2. Connection 생성 - .getConnection(연결문자열, DB-ID, DB-PW)
			conn = Thedeldb.condb();
			// 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
			pstmt = conn.prepareStatement(SQL);

			// 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ...

			// 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
			int r = pstmt.executeUpdate();


		} catch (Exception e) {

			System.out.println("[SQL Error : " + e.getMessage() + "]");

		} finally {

			// 사용순서와 반대로 close 함
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	//업데이트
	public static void update(int a, String b) {
			Connection conn = null;                                     // 데이터 베이스와 연결을 위한 객체
	        PreparedStatement pstmt = null;                            // SQL 문을 데이터베이스에 보내기위한 객체



	        try {
	            // 1. JDBC 드라이버 로딩 - MySQL JDBC 드라이버의 Driver Class 로딩
	        	String SQL = "update user_tbl set getpoint=? WHERE id =?";

	            // 2. Connection 생성 - .getConnection(연결문자열, DB-ID, DB-PW)
	            conn = Thedeldb.condb();

	            // 3. PreParedStatement 객체 생성, 객체 생성시 SQL 문장 저장
	            pstmt = conn.prepareStatement(SQL);

	            // 4. pstmt.set<데이터타입>(? 순서, 값) ex).setString(), .setInt ...
	            pstmt.setInt(1, a);
	            pstmt.setString(2, b);

	            // 5. SQL 문장을 실행하고 결과를 리턴 - SQL 문장 실행 후, 변경된 row 수 int type 리턴
	            int r = pstmt.executeUpdate();                         


	        } catch (Exception e) {

	            System.out.println("[SQL Error : " + e.getMessage() + "]");

	        } finally {

	            //사용순서와 반대로 close 함
	            if (pstmt != null) {
	                try {
	                    pstmt.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }

	            if (conn != null) {
	                try {
	                    conn.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		
	}
}
