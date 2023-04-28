package answer;

import entity_dao_sample.Employee;
import entity_dao_sample.EmployeeDao;

public class DeleteExercise {
	public static void main(String[] args) {
		// 削除
		EmployeeDao dao = new EmployeeDao();
		dao.deleteById(1000);

		// 削除を確認
		Employee employee = dao.load(1000);
		// 消えていたらnullになります
		System.out.println(employee);
	}
}