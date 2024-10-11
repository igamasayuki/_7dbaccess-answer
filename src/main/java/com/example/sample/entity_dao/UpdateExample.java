package com.example.sample.entity_dao;

public class UpdateExample {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();

		System.out.println("-----更新前-----");
		// 更新したい従業員をまずfindById()メソッドを使って取得する
		Employee employee = dao.findById(1000);
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gender = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());

		// 名前、年齢、部署IDを更新する
		employee.setName("伊賀");
		employee.setAge(18);
		employee.setDepartmentId(4L);
		dao.update(employee);

		System.out.println("-----更新後-----");
		employee = dao.findById(1000);
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gender = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());
	}
}