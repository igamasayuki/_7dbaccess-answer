package answer_ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Advanced5 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		StringBuilder sql = new StringBuilder();
		sql.append("DELETE FROM members WHERE name = '伊賀将之';");
		sql.append("DELETE FROM members WHERE name = '櫻井 翔';");
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql.toString());){
			
			int numOfUpdate = pstmt.executeUpdate();
			
			System.out.println(numOfUpdate + "件実施しました。");
			
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		}

	}

}
