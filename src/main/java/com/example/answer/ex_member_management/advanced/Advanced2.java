package com.example.answer.ex_member_management.advanced;

import java.util.List;

import com.example.answer.ex_member_management.dao.StudentDao;
import com.example.answer.ex_member_management.entity.Hobby;
import com.example.answer.ex_member_management.entity.Student;

/**
 * 一人分の情報を検索する実行クラス.
 * 
 * @author igamasayuki
 *
 */
public class Advanced2 {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		Student student = dao.findById(1);

		if (student == null) {
			System.out.println("検索結果は0件です");
			return;
		}

		System.out.println("name:" + student.getName());
		System.out.println("age:" + student.getAge());
		System.out.print("hobby:");

		List<Hobby> hobbyList = student.getHobbyList();
		for (int i = 0; i < hobbyList.size(); i++) {

			Hobby hobby = hobbyList.get(i);

			// 最後の趣味の表示は,を表示させない
			if (i == hobbyList.size() - 1) {
				System.out.println(hobby.getName());
			} else {
				System.out.print(hobby.getName() + ", ");
			}

		}

	}

}