package com.example.answer.ex_member_management.entity;

/**
 * 趣味情報を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Hobby {
	/** ID */
	private Long id;
	/** 名前 */
	private String name;
	/** 受講生ID */
	private Long studentId;

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", name=" + name + ", studentId=" + studentId + "]";
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
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

}