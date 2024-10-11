package com.example.sample.entity_dao;

public class InsertExample {
	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();

		// 追加するデータをあらわすEntity
		Employee employee = new Employee();
		employee.setId(1000L);
		employee.setName("テスト太郎");
		employee.setAge(22);
		employee.setGender("男");
		employee.setDepartmentId(2L);

		// 先ほど作成したEntityをテーブル時追加！
		dao.insert(employee);

		// 追加したデータを取り出してきちんと追加されているかを確認する
		employee = dao.findById(1000); 
		System.out.println("id = " + employee.getId());
		System.out.println("name = " + employee.getName());
		System.out.println("age = " + employee.getAge());
		System.out.println("gendar = " + employee.getGender());
		System.out.println("department_id = " + employee.getDepartmentId());
	}
}
