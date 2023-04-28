package answer;

public class UpdateExercise {
	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();

		System.out.println("-----更新前-----");
		// 更新したい部署情報をまずload()メソッドを使って取得する
		Department department = dao.load(1000);
		System.out.println("id = " + department.getId());
		System.out.println("name = " + department.getName());

		// 部署名を更新する
		department.setName("IT事業部");
		dao.update(department);

		System.out.println("-----更新後-----");
		department = dao.load(1000);
		System.out.println("id = " + department.getId());
		System.out.println("name = " + department.getName());
	}
}
