package answer_ex_member_management.beginner;

import java.time.LocalDate;

import answer_ex_member_management.dao.MemberDao;
import answer_ex_member_management.entity.Member;

public class Beginner1 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		Member member1 = new Member(null, "大野智", LocalDate.of(1980, 11, 26), "男", 1);
		int affected1 = memberDao.insert(member1);
		System.out.println(affected1 + "件登録しました");
		
		Member member2 = new Member(null, "櫻井翔", LocalDate.of(1982, 1, 25), "男", 2);
		int affected2 = memberDao.insert(member2);
		System.out.println(affected2 + "件登録しました");
		
		Member member3 = new Member(null, "相葉雅紀", LocalDate.of(1982, 12, 24), "男", 3);
		int affected3 = memberDao.insert(member3);
		System.out.println(affected3 + "件登録しました");
		
		Member member4 = new Member(null, "二宮和也", LocalDate.of(1984, 6, 17), "男", 4);
		int affected4 = memberDao.insert(member4);
		System.out.println(affected4 + "件登録しました");
		
		Member member5 = new Member(null, "松本潤", LocalDate.of(1983, 8, 30), "男", 5);
		int affected5 = memberDao.insert(member5);
		System.out.println(affected5 + "件登録しました");

	}

}
