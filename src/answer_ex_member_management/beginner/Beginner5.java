package answer_ex_member_management.beginner;

import java.util.ArrayList;

import answer_ex_member_management.dao.MemberDao;
import answer_ex_member_management.entity.Member;

public class Beginner5 {

	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();

		int affected1 = memberDao.deleteById(1);
		System.out.println(affected1 + "件削除しました");
		int affected2 = memberDao.deleteById(2);
		System.out.println(affected2 + "件削除しました");
		System.out.println("");

		// 確認
		ArrayList<Member> list = memberDao.findAll();

		for (Member element : list) {
			System.out.println("id:" + element.getId());
			System.out.println("name:" + element.getName());
			System.out.println("birthday:" + element.getBirthday());
			System.out.println("gender:" + element.getGender());
			System.out.println("color_id:" + element.getColorId());
			System.out.println("");
		}
	}

}
