package com.example.answer.ex_member_management.entity;

import java.time.LocalDate;

/**
 * メンバー情報を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Member {
	/** ID */
	private Long id;
	/** 名前 */
	private String name;
	/** 誕生日 */
	private LocalDate birthday;
	/** 性別 */
	private String gender;
	/** カラーID */
	private Long colorId;

	public Member(){}
	
	public Member(Long id, String name, java.time.LocalDate birthday, String gender,Long colorId){
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.colorId = colorId;
	}
	
	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", birthday=" + birthday + ", gender=" + gender + ", colorId="
				+ colorId + "]";
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

	public java.time.LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(java.time.LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getColorId() {
		return colorId;
	}

	public void setColorId(Long colorId) {
		this.colorId = colorId;
	}

}
