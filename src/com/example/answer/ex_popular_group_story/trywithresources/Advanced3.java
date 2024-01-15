package com.example.answer.ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Advanced3 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		String sql = "SELECT m.name m_name, m.birth_day m_birth_day, m.gender m_gender, c.name c_name FROM members m INNER JOIN colors c ON m.color_id = c.id";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();){
			
			while(rs.next()){
				String name = rs.getString("m_name");
				Date birth_day = rs.getDate("m_birth_day");
				String gender = rs.getString("m_gender");
				String color_name = rs.getString("c_name");
				System.out.println(name + "\t" + birth_day + "\t" + gender + "\t" + color_name);
			}
			
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		}

	}

}
