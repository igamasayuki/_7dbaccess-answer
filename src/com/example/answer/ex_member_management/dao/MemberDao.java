package com.example.answer.ex_member_management.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.answer.ex_member_management.common.DBManager;
import com.example.answer.ex_member_management.entity.Member;

/**
 * membersテーブルを操作するDao.
 * 
 * @author igamasayuki
 *
 */
public class MemberDao {
	/** テーブル名 */
	private final static String TABLE_NAME = "members";

	/**
	 * 主キー検索を行います.
	 * 
	 * @param id 主キー
	 * @return メンバー情報
	 */
	public Member findById(int id) {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "SELECT id, name, birth_day, gender, color_id FROM " + TABLE_NAME + " WHERE id = ?";

		try {
			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);
			// ?に値をセット※
			pstmt.setInt(1, id);

			// 手順４：SQL実行※
			ResultSet rs = pstmt.executeQuery();

			// 手順５：結果の操作※
			if (rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getDate("birth_day").toLocalDate());
				member.setGender(rs.getString("gender"));
				member.setColorId(rs.getInt("color_id"));
				return member;
			}

			return null;
		} catch (SQLException e) {
			throw new RuntimeException("主キー検索に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 曖昧検索を行います.
	 * 
	 * @param name 検索する名前
	 * @return メンバ情報一覧
	 */
	public List<Member> findByName(String name) {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "SELECT id, name, birth_day, gender, color_id from " + TABLE_NAME + " WHERE name LIKE ?  order by birth_day desc";

		try {

			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ?に値をセット※
			pstmt.setString(1, "%" + name + "%");
			// 手順４：SQL実行※
			ResultSet rs = pstmt.executeQuery();

			// 手順５：結果の操作※
			ArrayList<Member> list = new ArrayList<>();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getDate("birth_day").toLocalDate());
				member.setGender(rs.getString("gender"));
				member.setColorId(rs.getInt("color_id"));
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("曖昧検索に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 全件検索を行います.
	 * 
	 * @return メンバー情報一覧
	 */
	public ArrayList<Member> findAll() {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "SELECT id, name, birth_day, gender, color_id from " + TABLE_NAME + " order by birth_day desc";
		try {

			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);

			// 手順４：SQL実行※
			ResultSet rs = pstmt.executeQuery();

			// 手順５：結果の操作※
			ArrayList<Member> list = new ArrayList<>();
			while (rs.next()) {
				Member member = new Member();
				member.setId(rs.getInt("id"));
				member.setName(rs.getString("name"));
				member.setBirthday(rs.getDate("birth_day").toLocalDate());
				member.setGender(rs.getString("gender"));
				member.setColorId(rs.getInt("color_id"));
				list.add(member);
			}
			return list;
		} catch (SQLException e) {
			throw new RuntimeException("全件検索に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}

	/**
	 * メンバー情報の登録を行います.
	 * 
	 * @param member メンバー情報
	 * @return 登録件数
	 */
	public int insert(Member member) {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "INSERT INTO " + TABLE_NAME + " (name, birth_day, gender, color_id)VALUES(?,?,?,?)";

		try {
			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ?に値をセット※
			Date birthday = Date.valueOf(member.getBirthday());
			pstmt.setString(1, member.getName());
			pstmt.setDate(2, birthday);
			pstmt.setString(3, member.getGender());
			pstmt.setInt(4, member.getColorId());

			// 手順４：SQL実行※
			int affected = pstmt.executeUpdate();
			// 手順５：結果の操作※
			return affected;
		} catch (SQLException e) {
			throw new RuntimeException("登録処理に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 更新処理を行います.
	 * 
	 * @param member 更新したいメンバー情報
	 * @return 更新件数
	 */
	public int update(Member member) {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "UPDATE " + TABLE_NAME + " SET name = ?, birth_day = ?, gender = ?, color_id = ? WHERE id = ?";

		try {

			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ?に値をセット※
			pstmt.setString(1, member.getName());
			pstmt.setDate(2, Date.valueOf(member.getBirthday()));
			pstmt.setString(3, member.getGender());
			pstmt.setInt(4, member.getColorId());
			pstmt.setInt(5, member.getId());

			// 手順４：SQL実行※
			int affected = pstmt.executeUpdate();
			// 手順５：結果の操作※
			return affected;

		} catch (SQLException e) {
			throw new RuntimeException("更新処理に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}

	/**
	 * 削除を行います.
	 * 
	 * @param id 削除したい行のID
	 * @return 削除件数
	 */
	public int deleteById(int id) {
		// 手順１：接続
		Connection con = DBManager.createConnection();

		// 手順２：SQL作成※
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

		try {
			// 手順３：SQL実行準備
			PreparedStatement pstmt = con.prepareStatement(sql);

			// ?に値をセット※
			pstmt.setInt(1, id);

			// 手順４：SQL実行※
			int affected = pstmt.executeUpdate();
			// 手順５：結果の操作※
			return affected;
		} catch (SQLException e) {
			throw new RuntimeException("削除処理に失敗しました", e);
		} finally {
			// 手順６：切断
			DBManager.closeConnection(con);
		}
	}
}
