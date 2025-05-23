package com.example.answer;

/**
 * 部署を表すエンティティ.
 * 
 * @author igamasayuki
 *
 */
public class Department {
	/** ID */
	private Long id;
	/** 部署名 */
	private String name;

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

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
}
