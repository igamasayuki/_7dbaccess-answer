package com.example.answer;

import com.example.sample.entity_dao.Employee;
import com.example.sample.entity_dao.EmployeeDao;

public class DeleteExercise {
	public static void main(String[] args) {
		// 削除
		EmployeeDao dao = new EmployeeDao();
		dao.deleteById(1000);

		// 削除を確認
		Employee employee = dao.findById(1000);
		// 消えていたらnullになります
		System.out.println(employee);
	}
}
