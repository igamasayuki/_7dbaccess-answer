package answer_ex_member_management.entity;

/**
 * 趣味情報を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Hobby {
	/** ID */
	private Integer id;
	/** 名前 */
	private String name;
	/** 受講生ID */
	private Integer studentId;

	@Override
	public String toString() {
		return "Hobby [id=" + id + ", name=" + name + ", studentId=" + studentId + "]";
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
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

}