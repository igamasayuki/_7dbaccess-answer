package answer_ex_popular_group_story.standard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Beginner5 {

	public static void main(String[] args) {

		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		Connection con = null;
		PreparedStatement pstmt = null;

		String sql = "DELETE FROM members WHERE name = '伊賀将之' or name = '櫻井 翔';";

		try {
			con = DriverManager.getConnection(url, user, password);

			pstmt = con.prepareStatement(sql);

			int numOfUpdate = pstmt.executeUpdate();

			System.out.println(numOfUpdate + "件実施されました。");

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
