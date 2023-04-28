package answer_ex_member_management.beginner;

import java.util.List;

import answer_ex_member_management.dao.MemberDao;
import answer_ex_member_management.entity.Member;

public class Beginner3 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		List<Member> list = memberDao.findByName("和");
		for (Member element : list) {
			System.out.println("id:" + element.getId());
			System.out.println("name:" + element.getName());
			System.out.println("birthday:" + element.getBirthday());
			System.out.println("gender:" + element.getGender());
			System.out.println("color_id:" + element.getColorId());
		}
	}

}
