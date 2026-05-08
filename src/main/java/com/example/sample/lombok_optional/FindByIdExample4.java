package com.example.sample.lombok_optional;


public class FindByIdExample4 {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        // Optionalを使ってデータが存在しない場合の処理を記述
        dao.findById(1000L).ifPresentOrElse(
            // データが存在する場合の処理
            employee -> {
                System.out.println("id = " + employee.getId());
                System.out.println("name = " + employee.getName());
                System.out.println("age = " + employee.getAge());
                System.out.println("gender = " + employee.getGender());
                System.out.println("department_id = " + employee.getDepartmentId());
            },
            // データが存在しない場合の処理
            () -> System.out.println("指定されたデータは存在しません")
        );
    }
}
