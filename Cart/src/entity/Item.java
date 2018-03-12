package entity;

public class Item {
@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
	   boolean flag=false;
	   Item temp=(Item) obj;
	   if(temp.getName().equals(this.getName())&&temp.getLocation().equals(this.getLocation())) {
		   flag=true;
	   }
		return flag;
	}


	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.name.hashCode();
	}

private String name;
private String price;
private String location;
private String number;

	@Override
public String toString() {
	// TODO Auto-generated method stub
	return "the item name is "+this.name+".ths item price is "+this.price+
			".the item location is "+location;
}


	public Item(String name, String price, String location, String number) {
		super();
		this.name = name;
		this.price = price;
		this.location = location;
		this.number = number;
	}


	public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPrice() {
	return price;
}

public void setPrice(String price) {
	this.price = price;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("hello");
	}

}
