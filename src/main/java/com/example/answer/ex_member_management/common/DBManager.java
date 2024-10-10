package com.example.answer.ex_member_management.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	private final static String URL = "jdbc:postgresql://localhost:5432/student";
	private final static String USER_NAME = "postgres";
	private final static String PASSWORD = "postgres";

	/**
	 * データベース接続を行います.
	 * 
	 * @return 接続情報
	 */
	public static Connection createConnection() {
		try {
			Connection con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
			return con;
		} catch (Exception e) {
			throw new RuntimeException("DBの接続に失敗しました", e);
		}

	}
	
	/**
	 * データベースから切断します.
	 * 
	 * @param con 接続オブジェクト
	 */
	public static void closeConnection(Connection con) {
		// (6) メモリの解放(切断)
		try {
			if (con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("DBの接続に失敗しました", e);
		}
	}

}
