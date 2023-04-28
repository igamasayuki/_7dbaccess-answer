package answer_ex_popular_group_story.trywithresources;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Advanced4 {

	public static void main(String[] args) {
		
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";
		
		String sql = "update members  set name = '伊賀将之', birth_day='1979-07-27', gender='男', color_id = 6 where name = '大野 智'";
		
		try(Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement pstmt = con.prepareStatement(sql);){
			
			int numOfUpdate = pstmt.executeUpdate();
			
			System.out.println(numOfUpdate + "件実施しました。");
			
		} catch (SQLException e) {
			System.err.println("SQLExeptionが発生しました。" + sql);
			e.printStackTrace();
		}

	}

}
