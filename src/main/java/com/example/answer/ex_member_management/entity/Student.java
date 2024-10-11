package com.example.answer.ex_member_management.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 受講生情報を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Student {
	/** ID */
	private Long id;
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** 趣味一覧 */
	private List<Hobby> hobbyList;

	public Student() {
		hobbyList = new ArrayList<>();
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", hobbyList=" + hobbyList + "]";
	}
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
	public List<Hobby> getHobbyList() {
		return hobbyList;
	}
	public void setHobbyList(List<Hobby> hobbyList) {
		this.hobbyList = hobbyList;
	}
}
