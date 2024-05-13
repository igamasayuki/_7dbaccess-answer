package com.example.answer;

public class FindByIdExercise {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();
		Department department = dao.findById(1);
		System.out.println("id = " + department.getId());
		System.out.println("name = " + department.getName());
	}

}
