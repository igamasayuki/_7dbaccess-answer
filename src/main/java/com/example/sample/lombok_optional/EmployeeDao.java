package com.example.sample.lombok_optional;

import com.example.sample.util.DBManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class EmployeeDao {
	private static final String TABLE_NAME = "employees"; // テーブル名

	/**
	 * employeesテーブルの主キーを元にEmployeeオブジェクトを取得する.
	 *
	 * @param id employeesテーブルの主キーであるidの値
	 * @return 指定されたIDに対応するEmployeeオブジェクトを含むOptional。
	 * 存在しない場合はOptional.empty()を返します。
	 * @throws RuntimeException SQLエラーが発生した場合にスローされます。
	 */
	public Optional<Employee> findById(Long id) {
		Connection con = DBManager.createConnection(); // 接続

		// 実行するSQL文
		String sql = "SELECT id, name, age, gender, department_id FROM " + TABLE_NAME + " WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql); // SQL発行準備
			// SQLの １番目の「?」 の部分に値(id)をセットする
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery(); // SQLの実行

			// 結果の取り出し
			if (rs.next()) {
				// 結果があった場合の処理
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setAge((Integer) rs.getObject("age"));
				employee.setGender(rs.getString("gender"));
				employee.setDepartmentId(rs.getLong("department_id"));

				return Optional.of(employee); // Optionalでラップして返す
			}

			return Optional.empty(); // 指定idの行がない場合はOptional.empty()を返す

		} catch (SQLException ex) {
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("findById処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con); // 切断
		}
	}

}