package answer_ex_member_management.beginner;

import java.time.LocalDate;
import java.util.ArrayList;

import answer_ex_member_management.dao.MemberDao;
import answer_ex_member_management.entity.Member;

public class Beginner5 {

	public static void main(String[] args) {
		Member updateMember = new Member(1, "伊賀将之", LocalDate.of(1979, 7, 27), "男", 6);

		MemberDao memberDao = new MemberDao();
		int affected = memberDao.update(updateMember);
		System.out.println(affected + "件更新されました");

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
