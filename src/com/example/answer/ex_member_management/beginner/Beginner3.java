package com.example.answer.ex_member_management.beginner;

import java.util.ArrayList;
import java.util.List;

import com.example.answer.ex_member_management.dao.MemberDao;
import com.example.answer.ex_member_management.entity.Member;

public class Beginner3 {

	public static void main(String[] args) {
		MemberDao memberDao = new MemberDao();

		List<Member> list = memberDao.findAll();

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
