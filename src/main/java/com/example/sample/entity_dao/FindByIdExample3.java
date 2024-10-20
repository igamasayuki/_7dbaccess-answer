package com.example.sample.entity_dao;

import java.util.Optional;

public class FindByIdExample3 {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        // Optionalを使ってデータが存在しない場合の処理を記述
        dao.findById2(1000).ifPresentOrElse(
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
