package com.example.answer.ex_member_management.intermediate;

import java.util.List;

import com.example.answer.ex_member_management.dao.EmployeeDao;
import com.example.answer.ex_member_management.entity.Employee;

/**
 * 従業員情報一覧を取得する実行用クラス.
 * 
 * @author igamasayuki
 *
 */
public class Intermediate2 {

	public static void main(String[] args) {

		EmployeeDao dao = new EmployeeDao();

		List<Employee> employeeList = dao.findAll();

		for (Employee employee : employeeList) {
			System.out.println(employee);
		}

	}

}