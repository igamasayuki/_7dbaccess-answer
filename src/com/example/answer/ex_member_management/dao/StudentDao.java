package com.example.answer.ex_member_management.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.answer.ex_member_management.common.DBManager;
import com.example.answer.ex_member_management.entity.Hobby;
import com.example.answer.ex_member_management.entity.Student;

/**
 * studentsテーブルとhobbiesテーブルを操作するDao.
 *
 * @author igamasayuki
 *
 */
public class StudentDao {

	/** テーブル名 */
	private static final String TABLE_STUDENTS = "students";
	/** テーブル名 */
	private static final String TABLE_HOBBIES = "hobbies";

	/**
	 * 主キー検索を行います. 検索された受講生情報には趣味リストが含まれます。
	 *
	 * @param id 主キー
	 * @return 受講生情報 データが存在しない場合nullが返ります。
	 */
	public Student findById(int id) {

		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT s.id s_id, s.name s_name, s.age s_age, h.id h_id, h.name h_name, h.student_id h_student_id ");
		sql.append("FROM " + TABLE_STUDENTS + " s ");
		sql.append("LEFT OUTER JOIN " + TABLE_HOBBIES + " h ");
		sql.append("ON s.id = h.student_id ");
		sql.append("WHERE s.id = ?;");

		try (Connection con = DBManager.createConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql.toString())) {

			pstmt.setInt(1, id);

			try (ResultSet rs = pstmt.executeQuery()) {

				List<Student> students = createStudentHobby(rs);

				if (students.isEmpty()) {
					// studentsリストの中身が空だったらnullを返す。
					return null;
				} else {
					// studentsリストの中身が空ではなかったら、先頭のインスタンスを返す。
					return students.get(0);
				}

			}
		} catch (Exception e) {
			throw new RuntimeException("失敗", e);
		}
	}

	/**
	 * 全件検索を行います. 検索された受講生情報には趣味リストが含まれます。
	 *
	 * @return 受講生情報一覧 データが存在しない場合、空のリストが返ります。
	 *
	 */
	public List<Student> findAll() {

		StringBuilder sql = new StringBuilder();
		sql.append(
				"SELECT s.id s_id, s.name s_name, s.age s_age, h.id h_id, h.name h_name, h.student_id h_student_id ");
		sql.append("FROM " + TABLE_STUDENTS + " s ");
		sql.append("LEFT OUTER JOIN " + TABLE_HOBBIES + " h ");
		sql.append("ON s.id = h.student_id ");
		sql.append("ORDER BY s.id;");

		try (Connection con = DBManager.createConnection();
			 PreparedStatement pstmt = con.prepareStatement(sql.toString());
			 ResultSet rs = pstmt.executeQuery()) {

			List<Student> studentList = createStudentHobby(rs);

			return studentList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**
	 * 受講生情報と趣味一覧の登録を行います.<br>
	 * このメソッドはsynchronizedキーワードを使って排他制御しています。
	 *
	 * @param student 受講生情報
	 */
	public synchronized void insert(Student student) {

		try (Connection con = DBManager.createConnection()) {

			// 受講生情報のインサート処理
			String insertStudentsSql = "INSERT INTO " + TABLE_STUDENTS + "(name, age) VALUES(?, ?);";
			try (PreparedStatement pstmt = con.prepareStatement(insertStudentsSql)) {
				pstmt.setString(1, student.getName());
				pstmt.setInt(2, student.getAge());
				pstmt.executeUpdate();
				System.out.println("INSERT成功,studentsテーブル");
			}

			// 今自動採番された受講生IDを取得する
			int newStudentId = 0;
			String selectMaxIdSql = "SELECT max(id) maxId FROM students;";
			try (PreparedStatement pstmt = con.prepareStatement(selectMaxIdSql); ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					newStudentId = rs.getInt("maxId");
				}
				System.out.println("SELECT成功,studentsテーブルのmaxId取得");
			}

			// 趣味情報のインサート処理
			String insertHobbiesSql = "INSERT INTO " + TABLE_HOBBIES + "(name, student_id) VALUES(?, ?);";
			try (PreparedStatement pstmt = con.prepareStatement(insertHobbiesSql)) {
				for (Hobby hobby : student.getHobbyList()) {
					pstmt.setString(1, hobby.getName());
					pstmt.setInt(2, newStudentId);
					pstmt.executeUpdate();
				}

				System.out.println("INSERT成功,hobbiesテーブル");
			}

		} catch (Exception e) {
			throw new RuntimeException("失敗");
		}

	}

	/*
	 * 検索結果であるResultSetオブジェクトから趣味一覧を含めた受講生一覧を検索します.
	 *
	 * @param rs 検索結果(ResultSetオブジェクト)
	 *
	 * @return 趣味一覧が含まれた受講生一覧
	 *
	 * @throws SQLException DB関連のエラーが起こった際に発生
	 */
	private List<Student> createStudentHobby(ResultSet rs) throws SQLException {

		Student student = null;
		Hobby hobby = null;

		List<Hobby> hobbyList = null;
		List<Student> studentList = new ArrayList<>();

		int preStudentId = -1;

		while (rs.next()) {
			int sutudentId = rs.getInt("s_id");

			// studentテーブルのidが切り替わったら行う処理,
			if (sutudentId != preStudentId) {
				student = new Student();
				student.setId(rs.getInt("s_id"));
				student.setName(rs.getString("s_name"));
				student.setAge((Integer)rs.getObject("s_age"));

				hobbyList = new ArrayList<>();
				student.setHobbyList(hobbyList);// 先にhobbyListをstudentにsetし、後から値をsetし参照している。

				studentList.add(student);
			}

			if (rs.getInt("h_id") != 0) {
				hobby = new Hobby();
				hobby.setId(rs.getInt("h_id"));
				hobby.setName(rs.getString("h_name"));
				hobby.setStudentId(rs.getInt("h_student_id"));

				hobbyList.add(hobby);
			}

			preStudentId = sutudentId;
		}

		return studentList;
	}

}
