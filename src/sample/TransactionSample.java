package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * JDBCでトランザクション処理をするサンプル.
 * 
 * @author igamasayuki
 *
 */
public class TransactionSample {

	public static void main(String[] args) {
		// 接続情報
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		Connection con = null; // 使用する変数の宣言
		PreparedStatement pstmt = null;
		String sql = null;

		try {
			// (1)データベースに接続
			con = DriverManager.getConnection(url, user, password);

			// トランザクション開始
			con.setAutoCommit(false);

			// (2)SQL文を作成
			sql = "insert into employees(name, age) values('テスト太郎', 19);";

			// (3)SQL実行準備
			pstmt = con.prepareStatement(sql);

			// (4)SQL実行
			int numOfUpdate = pstmt.executeUpdate(); // insertの場合、結果は1

			// (5)結果の出力 (行数のみ表示)
			System.out.println(numOfUpdate + "件のデータを操作しました。");

			// 成功！コミット
			con.commit();
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			ex.printStackTrace();
			try {
				// 失敗！ロールバック
				con.rollback();
			} catch (SQLException e) {
			}
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
