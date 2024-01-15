package com.example.answer.ex_member_management.entity;

/**
 * 部署を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Department {
	/** ID */
	private Integer id;
	/** 部署名 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
