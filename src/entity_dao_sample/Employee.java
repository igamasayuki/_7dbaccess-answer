package entity_dao_sample;

/**
 * 従業員情報を表すクラス.
 * 
 * @author igamasayuki
 *
 */
public class Employee {

	// テーブルの列に対応したフィールド変数の宣言
	/** ID */
	private Integer id; // ← 参照データ型にする
	/** 名前 */
	private String name;
	/** 年齢 */
	private Integer age;
	/** 性別 */
	private String gender;
	/** 部署ID */
	private Integer departmentId; // ←キャメルケースにする
	// getter / setter メソッドを定義
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
	public Integer getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", departmentId="
				+ departmentId + "]";
	}
	
}
