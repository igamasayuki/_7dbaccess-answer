package entity_dao_sample;

import java.util.List;

public class FindByDepartmentIdExample {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDao();

		List<Employee> employeeList = dao.findByDepartmentId(2);

		for (Employee employee : employeeList) {
			System.out.println("name = " + employee.getName());
		}

	}

}
