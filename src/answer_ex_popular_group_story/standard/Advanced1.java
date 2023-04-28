package answer_ex_popular_group_story.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Advanced1 {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		Connection con = null;
		PreparedStatement pstmt = null;

		StringBuilder sql = new StringBuilder();
		sql.append("CREATE TABLE colors (");
		sql.append("id integer primary key,");
		sql.append("name text);");
		sql.append("CREATE TABLE members(");
		sql.append("id serial primary key,");
		sql.append("name text not null,");
		sql.append("birth_day date,");
		sql.append("gender varchar(1),");
		sql.append("color_id integer REFERENCES colors (id))");

		try {
			con = DriverManager.getConnection(url, user, password);

			pstmt = con.prepareStatement(sql.toString());

			pstmt.executeUpdate();

			System.out.println("成功しました。");

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
