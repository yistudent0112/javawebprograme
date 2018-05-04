package com.imooc.domain;

/**
 * 
 * @ClassName: Book
 * @Description: TODO(书本的抽象类)
 * @author yi
 * @date 2018年4月12日
 *
 */
public class Book {
	private String Id;
	private String BookName;
	private String CatgoryName;
	private String Price;
	private String Description;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getBookName() {
		return BookName;
	}

	public void setBookName(String bookName) {
		BookName = bookName;
	}

	public String getCatgoryName() {
		return CatgoryName;
	}

	public void setCatgoryName(String catgoryName) {
		CatgoryName = catgoryName;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
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
