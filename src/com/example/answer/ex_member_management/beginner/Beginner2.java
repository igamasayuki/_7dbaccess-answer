package com.example.answer.ex_member_management.beginner;

import com.example.answer.ex_member_management.dao.MemberDao;
import com.example.answer.ex_member_management.entity.Member;

public class Beginner2 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		Member member = memberDao.load(1);

		System.out.println("id:" + member.getId());
		System.out.println("name:" + member.getName());
		System.out.println("birthday:" + member.getBirthday());
		System.out.println("gender:" + member.getGender());
		System.out.println("color_id:" + member.getColorId());
	}

}
