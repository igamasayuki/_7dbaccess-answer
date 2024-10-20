package com.example.sample.entity_dao;

import java.util.Optional;

public class FindByIdExample2 {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		Optional<Employee> optional = dao.findById2(2);
		if(optional.isEmpty()) { // Optionalが空かどうか判定
			System.out.println("指定されたデータは存在しません");
			return;
		}
		Employee employee = optional.get(); // OptionalからEmployeeオブジェクトを取得
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gender = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());
	}
}
