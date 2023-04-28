package answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity_dao_sample.DBManager;

/**
 * departmentsテーブルを操作するDao.
 * 
 * @author igamasayuki
 *
 */
public class DepartmentDao {
	private static final String TABLE_NAME = "departments"; // テーブル名
	
	/**
	 * departmentsテーブルの主キーを元にDepartmentオブジェクトをロードする.
	 * 
	 * @param id departmentsテーブルの主キーであるidの値
	 * @return 主キーに対応するテーブルの行の情報を持つDepartmentオブジェクト
	 */
	public Department load(int id) {
		Connection con = DBManager.createConnection(); // 接続

		// 実行するSQL文 (fromの次とwhereの前に半角スペースを入れています)
		String sql = "SELECT id, name from " + TABLE_NAME + " where id = " + id;

		try { // SQLExceptionが発生するため例外処理
			PreparedStatement pstmt = con.prepareStatement(sql); // SQL発行準備
			ResultSet rs = pstmt.executeQuery(); // SQLの実行

			// 結果の取り出し
			if (rs.next()) {
				// 結果があった場合の処理
				Department department = new Department();
				department.setId(rs.getInt("id"));
				department.setName(rs.getString("name"));
				return department;
			}
			return null; // 指定idの行がない場合などはnullを返す
		} catch (SQLException ex) {
			System.err.println("SQL = " + sql); // 発行したSQLを出力
			throw new RuntimeException("load処理に失敗しました", ex);
		} finally {
			DBManager.closeConnection(con); // 切断
		}
	}
	
	/**
	 * 部署情報を追加する.
	 * 
	 * @param department 部署情報
	 * @return 更新した行数
	 */
	public int insert(Department department) {
		Connection con = DBManager.createConnection();
		String sql = "INSERT INTO " + TABLE_NAME 
				+ "       ( id, name)"
				+ " VALUES(  ?,    ?)";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			// SQLの 「?」 の部分にそれぞれ値をセットする
			pstmt.setInt(1, department.getId());
			pstmt.setString(2, department.getName());

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
	 * 部署情報を更新する.
	 * 
	 * @param department 従業員情報
	 * @return 更新した行数
	 */
	public int update(Department department) {
		Connection con = DBManager.createConnection();

		String sql = "UPDATE " + TABLE_NAME + " SET name = ? WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, department.getName()); // SET句の｢？｣にセット
			pstmt.setInt(2, department.getId());

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
	 * IDから部署を削除する.
	 * 
	 * @param id 削除したい部署ID
	 * @return 削除した件数
	 */
	public int deleteById(int id) {
		Connection con = DBManager.createConnection();
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);// SET句の｢？｣にセット
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
