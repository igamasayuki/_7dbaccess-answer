package com.example.answer.ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Advanced1 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE colors (");
		sql.append("id bigint primary key,");
		sql.append("name text);");
		sql.append("CREATE TABLE members(");
		sql.append("id bigserial primary key,");
		sql.append("name text not null,");
		sql.append("birth_day date,");
		sql.append("gender varchar(1),");
		sql.append("color_id bigint REFERENCES colors (id))");
		
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
