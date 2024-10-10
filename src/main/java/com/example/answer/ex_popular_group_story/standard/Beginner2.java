package com.example.answer.ex_popular_group_story.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Beginner2 {
	public static void main(String[] args) {
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("insert into members (name, birth_day, gender, color_id) values ('大野 智','1980-11-26','男',1);");
		sql.append("insert into members (name, birth_day, gender, color_id) values ('櫻井 翔','1982-1-25','男',2);");
		sql.append("insert into members (name, birth_day, gender, color_id) values ('相葉 雅紀','1982-12-24','男',3);");
		sql.append("insert into members (name, birth_day, gender, color_id) values ('二宮 和也','1983-6-17','男',4);");
		sql.append("insert into members (name, birth_day, gender, color_id) values ('松本 潤','1983-8-30','男',5);");

//		String sql2 = "insert into members (name, birth_day, gender, color_id) values ('大野 智','1980-11-26','男',1);";
//		sql2 += "insert into members (name, birth_day, gender, color_id) values ('櫻井 翔','1982-1-25','男',2);";
				
		try {
			con = DriverManager.getConnection(url, user, password);
			
			pstmt = con.prepareStatement(sql.toString());

			int numOfUpdate = pstmt.executeUpdate();
			System.out.println(numOfUpdate + "件実施されました");
			
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		} finally {
			try {
				if (con != null) {
					con.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
