package answer_ex_member_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import answer_ex_member_management.common.DBManager;
import answer_ex_member_management.entity.Department;
import answer_ex_member_management.entity.Employee;

/**
 * employeesテーブルを操作するDao.
 * 
 * @author igamasayuki
 *
 */
public class EmployeeDao {
	/** テーブル名 */
	private final static String SELECT_STATEMENT = "SELECT e.id e_id, e.name e_name, e.age e_age, e.gender e_gender, e.department_id e_department_id, d.id d_id, d.name d_name";
	private final static String FROM_STATEMENT = "FROM employees e INNER JOIN departments d ON e.department_id = d.id";

	/**
	 * 主キー検索をする.
	 * 
	 * @param id employeesテーブルの主キーであるidの値
	 * @return 主キーに対応するテーブルの行の情報を持つEmployeeオブジェクト
	 */
	public Employee load(int id) {

		String sql = SELECT_STATEMENT + " " + FROM_STATEMENT + " WHERE e.id = ?";

		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {

			// SQLの １番目の「?」 の部分に値(id)をセットする
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Employee employee = createEmployee(rs);
					return employee;
				}
				return null; // 指定idの行がない場合などはnullを返す
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("load処理に失敗しました", e);
		}
	}

	/**
	 * 全件検索を行います.
	 * 
	 * @return 従業員情報一覧
	 */
	public ArrayList<Employee> findAll() {
		String sql = SELECT_STATEMENT + " " + FROM_STATEMENT + " ORDER BY age";
		try (Connection com = DBManager.createConnection();
				PreparedStatement pstmt = com.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

			ArrayList<Employee> list = new ArrayList<>();
			while (rs.next()) {
				Employee employee = createEmployee(rs);
				list.add(employee);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("全件検索に失敗しました", e);
		}
	}

	/**
	 * 部署に所属している従業員一覧を取得する.
	 * 
	 * @param departmentId 部署ID
	 * @return 指定した部署IDの部署に所属する従業員一覧
	 */
	public List<Employee> findByDepartmentId(int departmentId) {
		String sql = SELECT_STATEMENT + " " + FROM_STATEMENT + " WHERE e.department_id = ? ORDER BY age";

		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			// SQLの １番目の「?」 の部分に値(id)をセットする
			pstmt.setInt(1, departmentId);
			try (ResultSet rs = pstmt.executeQuery();) {

				ArrayList<Employee> list = new ArrayList<>();
				while (rs.next()) {
					Employee employee = createEmployee(rs);
					list.add(employee);
				}
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("検索に失敗しました", e);
		}
	}

	/*
	 * 部署情報が含まれた従業員情報を返す.
	 * 
	 * @param rs 検索結果
	 * 
	 * @return 部署情報が含まれた従業員情報
	 * 
	 * @throws SQLException SQL関連のエラー時に発生
	 */
	private Employee createEmployee(ResultSet rs) throws SQLException {
		Employee employee = new Employee();
		employee.setId(rs.getInt("e_id"));
		employee.setName(rs.getString("e_name"));
		employee.setAge(rs.getInt("e_age"));
		employee.setGender(rs.getString("e_gender"));
		employee.setDepartmentId(rs.getInt("e_department_id"));
		Department department = new Department();
		department.setId(rs.getInt("d_id"));
		department.setName(rs.getString("d_name"));
		employee.setDepartment(department);
		return employee;
	}

}
