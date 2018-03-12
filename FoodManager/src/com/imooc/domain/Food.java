package com.imooc.domain;
/*
 * 食物实体类
 */
public class Food {
private String foodId;
private String foodName;
private String path;
private String flavour;
private String foodPrice;
private String foodContext;
	@Override
public String toString() {
	return "Food [foodId=" + foodId + ", foodname=" + foodName + ", path=" + path + ", flavour=" + flavour
			+ ", foodPrice=" + foodPrice + ", foodContext=" + foodContext + "]";
}
	public String getFoodId() {
	return foodId;
}
public void setFoodId(String foodId) {
	this.foodId = foodId;
}
public String getFoodName() {
	return foodName;
}
public void setFoodName(String foodname) {
	this.foodName = foodname;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public String getFlavour() {
	return flavour;
}
public void setFlavour(String flavour) {
	this.flavour = flavour;
}
public String getFoodPrice() {
	return foodPrice;
}
public void setFoodPrice(String foodPrice) {
	this.foodPrice = foodPrice;
}
public String getFoodContext() {
	return foodContext;
}
public void setFoodContext(String foodContext) {
	this.foodContext = foodContext;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
