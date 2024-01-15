package com.example.answer.ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Advanced6 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		StringBuilder sql = new StringBuilder();
		sql.append("DROP TABLE members;");
		sql.append("DROP TABLE colors;");
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());){
			
			pstmt.executeUpdate();
			
			System.out.println("成功しました。");
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		}

	}

}
