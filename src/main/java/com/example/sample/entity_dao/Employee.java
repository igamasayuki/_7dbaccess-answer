package com.example.sample.entity_dao;

/**
 * 従業員情報を表すクラス.
 * 
 * @author igamasayuki
 *
 */
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
	// getter / setter メソッドを定義
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Long getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", departmentId="
				+ departmentId + "]";
	}
	
}
