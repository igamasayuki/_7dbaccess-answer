package answer_ex_member_management.beginner;

import java.time.LocalDate;
import java.util.ArrayList;

import answer_ex_member_management.dao.MemberDao;
import answer_ex_member_management.entity.Member;

public class Beginner4 {

	public static void main(String[] args) {

		MemberDao memberDao = new MemberDao();
		
		// 更新対象のメンバーを１件取得
		Member updateMember = memberDao.load(1);
		updateMember.setName("伊賀将之");
		updateMember.setBirthday(LocalDate.of(1979, 7, 27));
		updateMember.setGender("男");
		updateMember.setColorId(6);

		// 更新処理
		int affected = memberDao.update(updateMember);
		System.out.println(affected + "件更新されました");

		// 確認
		ArrayList<Member> memberList = memberDao.findAll();

		for (Member member : memberList) {
			System.out.println("id:" + member.getId());
			System.out.println("name:" + member.getName());
			System.out.println("birthday:" + member.getBirthday());
			System.out.println("gender:" + member.getGender());
			System.out.println("color_id:" + member.getColorId());
			System.out.println("");
		}
	}

}
