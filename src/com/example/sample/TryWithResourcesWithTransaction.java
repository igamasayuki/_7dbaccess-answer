package com.example.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * try-with-resources構文+トランザクション処理のサンプル.
 * 
 * @author igamasayuki
 *
 */
public class TryWithResourcesWithTransaction {

	public static void main(String[] args) {
		// 接続情報
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		String sql = "insert into employees(name, age) values('テスト太郎', 19);";

		// 接続と実行準備(JDK7から導入されたtry-with-resourcesを使いcloseし忘れを防ぐ)
		try (Connection con = DriverManager.getConnection(url, user, password);) {
			// トランザクション開始
			con.setAutoCommit(false);
			try (PreparedStatement pstmt = con.prepareStatement(sql);) {
				int numOfUpdate = pstmt.executeUpdate(); // insertの場合、結果は1
				// 結果の出力 (行数のみ表示)
				System.out.println(numOfUpdate + "件のデータを操作しました。");
				// 成功！コミット
				con.commit();
			} catch (SQLException e) {
				// 失敗！ロールバック
				con.rollback();
			}
		} catch (SQLException ex) {
			System.err.println("例外が発生しました");
			System.err.println("発行したSQLは「" + sql + "」");
			ex.printStackTrace();
		}
	}
}