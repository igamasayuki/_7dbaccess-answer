package answer;

public class InsertExercise {

	public static void main(String[] args) {
		DepartmentDao dao = new DepartmentDao();

		// 追加するデータをあらわすEntity
		Department department = new Department();
		department.setId(1000);
		department.setName("システム情報部");

		// 先ほど作成したEntityをテーブル時追加！
		dao.insert(department);

		// 追加したデータを取り出してきちんと追加されているかを確認する
		department = dao.load(1000); 
		System.out.println("id = " + department.getId());
		System.out.println("name = " + department.getName());

	}

}
