package com.example.sample.entity_dao;

public class LoadExample {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();
		Employee employee = dao.load(2);
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gender = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());
	}
}
