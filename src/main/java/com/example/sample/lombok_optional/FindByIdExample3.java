package com.example.sample.lombok_optional;


public class FindByIdExample3 {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();

        // データが存在すれば取得し、存在しなければ()内の例外を発生させる
        Employee employee = dao.findById(1000L).orElseThrow(
                () -> new RuntimeException("指定されたデータは存在しません")
        );

        // 例外が発生しなかった場合のみ、以下の処理が実行される
        System.out.println("id = " + employee.getId());
        System.out.println("name = " + employee.getName());
        System.out.println("age = " + employee.getAge());
        System.out.println("gender = " + employee.getGender());
        System.out.println("department_id = " + employee.getDepartmentId());
    }
}
