package answer_ex_member_management.advanced;

import java.util.List;

import answer_ex_member_management.dao.StudentDao;
import answer_ex_member_management.entity.Hobby;
import answer_ex_member_management.entity.Student;

/**
 * 全件取得する実行用クラス.
 * 
 * @author igamasayuki
 *
 */
public class Advanced3 {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		List<Student> studentList = dao.findAll();

		for (Student student : studentList) {
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

			System.out.println();
		}

	}
}