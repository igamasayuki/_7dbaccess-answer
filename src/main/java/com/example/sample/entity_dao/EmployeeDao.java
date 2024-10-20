package com.example.sample.entity_dao;

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
	 * employeesテーブルの主キーを元にEmployeeオブジェクトをロードする.
	 * 
	 * @param id employeesテーブルの主キーであるidの値
	 * @return 主キーに対応するテーブルの行の情報を持つEmployeeオブジェクト
	 */
	public Employee findById(int id) {
		Connection con = DBManager.createConnection(); // 接続

		// 実行するSQL文 (fromの次とwhereの前に半角スペースを入れています)
		String sql = "SELECT id, name, age, gender, department_id from " + TABLE_NAME + " where id = ?";

		try { // SQLExceptionが発生するため例外処理
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
				employee.setAge((Integer)rs.getObject("age"));
				employee.setGender(rs.getString("gender"));
				employee.setDepartmentId(rs.getLong("department_id"));
				return employee;
			}
			return null; // 指定idの行がない場合などはnullを返す
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("findById処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con); // 切断
		}
	}

	/**
	 * employeesテーブルの主キーを元にEmployeeオブジェクトを取得します。
	 *
	 * @param id employeesテーブルの主キーであるidの値
	 * @return 指定されたIDに対応するEmployeeオブジェクトを含むOptional。
	 *         存在しない場合はOptional.empty()を返します。
	 * @throws RuntimeException SQLエラーが発生した場合にスローされます。
	 */
	public Optional<Employee> findById2(int id) {
		Connection con = DBManager.createConnection();
		String sql = "SELECT id, name, age, gender, department_id FROM employees WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setAge((Integer) rs.getObject("age"));
				employee.setGender(rs.getString("gender"));
				employee.setDepartmentId(rs.getLong("department_id"));
				return Optional.of(employee); // Optionalでラップ
			}
			return Optional.empty(); // 値がない場合はOptional.empty()を返す

		} catch (SQLException ex) {
			throw new RuntimeException("findById処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 部署に所属している従業員一覧を取得する.
	 * 
	 * @param departmentId 部署ID
	 * @return 指定した部署IDの部署に所属する従業員一覧
	 */
	public List<Employee> findByDepartmentId(int departmentId) {
		Connection con = DBManager.createConnection();
		String sql = "SELECT id, name, age, gender, department_id FROM " + TABLE_NAME + " WHERE department_id = ? ORDER BY id";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			// SQLの １番目の「?」 の部分に値(departmentId)をセットする
			pstmt.setLong(1, departmentId);
			// SQLの実行
			ResultSet rs = pstmt.executeQuery();

			// 結果格納用のArrayList
			List<Employee> employeeList = new ArrayList<>();

			// 結果が複数ある可能性があるので、if文ではなくwhile文を使用
			while (rs.next()) {
				// 1行分のEntityを作成
				Employee employee = new Employee();
				employee.setId(rs.getLong("id"));
				employee.setName(rs.getString("name"));
				employee.setAge((Integer)rs.getObject("age"));
				employee.setGender(rs.getString("gender"));
				employee.setDepartmentId(rs.getLong("department_id"));
				employeeList.add(employee); // EntityをArrayListに追加
			}

			return employeeList; // Entityを含むArrayListを返す

		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("検索処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con); // 切断
		}
	}

	/**
	 * 従業員情報を追加する.
	 * 
	 * @param employee 従業員情報
	 * @return 更新した行数
	 */
	public int insert(Employee employee) {
		Connection con = DBManager.createConnection();
		String sql = "INSERT INTO " + TABLE_NAME + "       ( id, name, age, gender, department_id)"
				+ " VALUES(  ?,    ?,   ?,      ?,             ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			// SQLの 「?」 の部分にそれぞれ値をセットする
			pstmt.setLong(1, employee.getId());
			pstmt.setString(2, employee.getName());
			pstmt.setInt(3, employee.getAge());
			pstmt.setString(4, employee.getGender());
			pstmt.setLong(5, employee.getDepartmentId());

			int affected = pstmt.executeUpdate(); // SQLの実行
			return affected; // 更新した行数を返す
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("insert処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 従業員情報を更新する.
	 * 
	 * @param employee 従業員情報
	 * @return 更新した行数
	 */
	public int update(Employee employee) {
		Connection con = DBManager.createConnection();

		String sql = "UPDATE " + TABLE_NAME + " SET name = ?, age = ?, gender = ?, department_id = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, employee.getName()); // SET句の｢？｣にセット
			pstmt.setInt(2, employee.getAge());
			pstmt.setString(3, employee.getGender());
			pstmt.setLong(4, employee.getDepartmentId());

			pstmt.setLong(5, employee.getId());

			int affected = pstmt.executeUpdate();
			return affected;
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("update処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

	/**
	 * IDから従業員を削除する.
	 * 
	 * @param id 削除したい従業員ID
	 * @return 削除した件数
	 */
	public int deleteById(int id) {
		Connection con = DBManager.createConnection();
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, id);// SET句の｢？｣にセット
			int affected = pstmt.executeUpdate(); // DELETE文の実行

			return affected;
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql);
			throw new RuntimeException("delete処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con);
		}
	}

}
