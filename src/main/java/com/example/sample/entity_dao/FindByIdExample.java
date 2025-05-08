package com.example.sample.entity_dao;

public class FindByIdExample {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.findById(2L);
		if(employee == null) {
			System.out.println("指定されたデータは存在しません");
			return;
		}
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gender = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());
	}
}
