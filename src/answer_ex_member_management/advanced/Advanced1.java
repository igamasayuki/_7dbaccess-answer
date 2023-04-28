package answer_ex_member_management.advanced;

import java.util.ArrayList;
import java.util.List;

import answer_ex_member_management.dao.StudentDao;
import answer_ex_member_management.entity.Hobby;
import answer_ex_member_management.entity.Student;

/**
 * データをインサートする実行用のクラス.
 * 
 * @author igamasayuki
 *
 */
public class Advanced1 {

	public static void main(String[] args) {

		StudentDao dao = new StudentDao();

		// Igaさんの情報をインサート
		List<Hobby> igaHobbyList = new ArrayList<>();
		Hobby igaHobby1 = new Hobby();
		igaHobby1.setName("running");
		igaHobbyList.add(igaHobby1);
		
		Hobby igaHobby2 = new Hobby();
		igaHobby2.setName("swimming");
		igaHobbyList.add(igaHobby2);
		
		Hobby igaHobby3 = new Hobby();
		igaHobby3.setName("cycling");
		igaHobbyList.add(igaHobby3);
		
		Student igaStudent = new Student();
		igaStudent.setName("Iga");
		igaStudent.setAge(20);
		igaStudent.setHobbyList(igaHobbyList);
		
		dao.insert(igaStudent);
		
		// Taro さんの情報をインサート
		List<Hobby> taroHobbyList = new ArrayList<>();
		Hobby taroHobby1 = new Hobby();
		taroHobby1.setName("reading books");
		taroHobbyList.add(taroHobby1);
		
		Hobby taroHobby2 = new Hobby();
		taroHobby2.setName("watching movies");
		taroHobbyList.add(taroHobby2);
		
		Student taroStudent = new Student();
		taroStudent.setName("taro");
		taroStudent.setAge(35);
		taroStudent.setHobbyList(taroHobbyList);
		
		dao.insert(taroStudent);
		
		// Hanakoさんの情報をインサート
		List<Hobby> hanakoHobbyList = new ArrayList<>();
		Hobby hanakoHobby1 = new Hobby();
		hanakoHobby1.setName("football");
		hanakoHobbyList.add(hanakoHobby1);
		
		Hobby hanakoHobby2 = new Hobby();
		hanakoHobby2.setName("tennis");
		hanakoHobbyList.add(hanakoHobby2);
		
		Hobby hanakoHobby3 = new Hobby();
		hanakoHobby3.setName("baseball");
		hanakoHobbyList.add(hanakoHobby3);
		
		Student hanakoStudent = new Student();
		hanakoStudent.setName("Hanako");
		hanakoStudent.setAge(28);
		hanakoStudent.setHobbyList(hanakoHobbyList);
		
		dao.insert(hanakoStudent);
		
		// Yamadaさんの情報をインサート　山田さんは趣味なし
		Student yamadaStudent = new Student();
		yamadaStudent.setName("Yamada");
		yamadaStudent.setAge(50);
		
		dao.insert(yamadaStudent);

	}

}