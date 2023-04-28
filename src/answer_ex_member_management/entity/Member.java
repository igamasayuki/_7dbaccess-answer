package answer_ex_member_management.entity;

import java.time.LocalDate;

/**
 * メンバー情報を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Member {
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 誕生日 */
	private LocalDate birthday;
	/** 性別 */
	private String gender;
	/** カラーID */
	private Integer colorId;

	public Member(){}
	
	public Member(Integer id, String name, java.time.LocalDate birthday, String gender,Integer colorId){
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

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

}
