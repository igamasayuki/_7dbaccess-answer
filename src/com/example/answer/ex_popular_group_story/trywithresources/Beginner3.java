package com.example.answer.ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Beginner3 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		String sql = "SELECT name, birth_day, gender, color_id FROM members";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()){
				String name = rs.getString("name");
				String birth_day = rs.getString("birth_day");
				String gender = rs.getString("gender");
				int color_id = rs.getInt("color_id");
				System.out.println(name + "\t" + birth_day + "\t" + gender + "\t" + color_id);
			}
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		}

	}

}
