package com.example.sample.entity_dao;

public class DeleteExample {
	public static void main(String[] args) {
		// 削除
		EmployeeDao dao = new EmployeeDao();
		dao.deleteById(1000L);
		
		// 削除を確認
		Employee employee = dao.findById(1000L);
		// 消えていたらnullになります
		System.out.println(employee);
	}
}
