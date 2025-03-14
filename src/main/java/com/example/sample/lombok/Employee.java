package com.example.sample.lombok;


import lombok.*;

/**
 * 従業員情報を表すクラス.
 *
 * @author igamasayuki
 *
 */
@Getter  // Getterを自動生成
@Setter  // Setterを自動生成
@NoArgsConstructor // 引数なしのコンストラクタを自動生成
@AllArgsConstructor // 全てのフィールドを引数に持つコンストラクタを自動生成
@ToString // toString()メソッドを自動生成
@Builder // Builderパターンを適用
public class Employee {

    // テーブルの列に対応したフィールド変数の宣言
    /** ID */
    private Long id; // ← 参照データ型にする
    /** 名前 */
    private String name;
    /** 年齢 */
    private Integer age;
    /** 性別 */
    private String gender;
    /** 部署ID */
    private Long departmentId; // ←キャメルケースにする
}
