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
 * membersテーブルを操作するDao(try-with-resourcesバージョン).
 * 
 * @author igamasayuki
 *
 */
public class MemberDao2 {
	/** テーブル名 */
	private final static String TABLE_NAME = "members";

	/**
	 * 主キー検索を行います.
	 * 
	 * @param id 主キー
	 * @return メンバー情報
	 */
	public Member findById(int id) {
		String sql = "SELECT id, name, birth_day, gender, color_id FROM " + TABLE_NAME + " WHERE id = ?";
		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Member member = new Member();
					member.setId(rs.getInt("id"));
					member.setName(rs.getString("name"));
					member.setBirthday(rs.getDate("birth_day").toLocalDate());
					member.setGender(rs.getString("gender"));
					member.setColorId(rs.getInt("color_id"));
					return member;
				}
			}
			return null;
		} catch (SQLException e) {
			throw new RuntimeException("主キー検索に失敗しました", e);
		}
	}

	/**
	 * 曖昧検索を行います.
	 * 
	 * @param name 検索する名前
	 * @return メンバ情報一覧
	 */
	public List<Member> findByName(String name) {
		String sql = "SELECT id, name, birth_day, gender, color_id from " + TABLE_NAME + " WHERE name LIKE ? order by birth_day desc";

		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			pstmt.setString(1, "%" + name + "%");
			try (ResultSet rs = pstmt.executeQuery()) {
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
			}
		} catch (SQLException e) {
			throw new RuntimeException("曖昧検索に失敗しました", e);
		}
	}

	/**
	 * 全件検索を行います.
	 * 
	 * @return メンバー情報一覧
	 */
	public ArrayList<Member> findAll() {
		String sql = "SELECT id, name, birth_day, gender, color_id from " + TABLE_NAME + " order by birth_day desc";
		try (Connection com = DBManager.createConnection();
				PreparedStatement pstmt = com.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();) {

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
		}
	}

	/**
	 * メンバー情報の登録を行います.
	 * 
	 * @param member メンバー情報
	 * @return 登録件数
	 */
	public int insert(Member member) {
		String sql = "INSERT INTO " + TABLE_NAME + " (name, birth_day, gender, color_id)VALUES(?,?,?,?)";
		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			Date birthday = Date.valueOf(member.getBirthday());
			pstmt.setString(1, member.getName());
			pstmt.setDate(2, birthday);
			pstmt.setString(3, member.getGender());
			pstmt.setInt(4, member.getColorId());
			int affected = pstmt.executeUpdate();
			return affected;
		} catch (SQLException e) {
			throw new RuntimeException("登録処理に失敗しました", e);
		}
	}

	/**
	 * 更新処理を行います.
	 * 
	 * @param member 更新したいメンバー情報
	 * @return 更新件数
	 */
	public int update(Member member) {
		String sql = "UPDATE " + TABLE_NAME + " SET name = ?, birth_day = ?, gender = ?, color_id = ? WHERE id = ?";

		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			pstmt.setString(1, member.getName());
			pstmt.setDate(2, Date.valueOf(member.getBirthday()));
			pstmt.setString(3, member.getGender());
			pstmt.setInt(4, member.getColorId());
			pstmt.setInt(5, member.getId());

			int affected = pstmt.executeUpdate();
			return affected;
		} catch (SQLException e) {
			throw new RuntimeException("更新処理に失敗しました", e);
		}
	}

	/**
	 * 削除を行います.
	 * 
	 * @param id 削除したい行のID
	 * @return 削除件数
	 */
	public int deleteById(int id) {
		String sql = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";

		try (Connection com = DBManager.createConnection(); PreparedStatement pstmt = com.prepareStatement(sql);) {
			pstmt.setInt(1, id);
			int affected = pstmt.executeUpdate();
			return affected;
		} catch (SQLException e) {
			throw new RuntimeException("削除処理に失敗しました", e);
		}
	}
}
