package com.example.answer.ex_member_management.intermediate;

import com.example.answer.ex_member_management.dao.EmployeeDao;
import com.example.answer.ex_member_management.entity.Employee;

/**
 * 従業員情報1件を取得する実行用クラス.
 * 
 * @author igamasayuki
 *
 */
public class Intermediate1 {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		Employee employee = dao.findById(1);
		System.out.println(employee);

	}

}