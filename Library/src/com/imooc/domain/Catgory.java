package com.imooc.domain;

/**
 * 
 * @ClassName: Catgory
 * @Description: TODO(书本分类的抽象类)
 * @author yi
 * @date 2018年4月24日
 *
 */
public class Catgory {
	private String Id;
	private String Name;
	private String Description;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
