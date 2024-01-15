package com.example.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * try-with-resources構文サンプル.
 * Java7から導入された構文
 * tryの()の中にfinallyでclose()する必要があるオブジェクトを取得すれば、
 * close()を呼び出さなくても自動でclose()してくれる便利な構文
*/
public class TryWithResourcesSample {

	public static void main(String[] args) {
		// 接続情報
		String url = "jdbc:postgresql://localhost:5432/student";
		String user = "postgres";
		String password = "postgres";

		String sql = "select id, name, age from employees order by age;";
		
		// 接続と実行準備(Java7から導入されたtry-with-resourcesを使いcloseし忘れを防ぐ)
		try (Connection con = DriverManager.getConnection(url, user, password);
				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();){
					
			// 結果の操作
			while (rs.next()) {
				int id = rs.getInt("id"); 
				String name = rs.getString("name"); 
				int age = rs.getInt("age"); 

				System.out.print("id=" + id);
				System.out.print("  name=" + name);
				System.out.print("  age=" + age);
				System.out.println();
			}
		} catch (SQLException ex) {
			System.err.println("例外が発生しました");
			System.err.println("発行したSQLは「" + sql + "」");
			ex.printStackTrace();
		}
	}

}
