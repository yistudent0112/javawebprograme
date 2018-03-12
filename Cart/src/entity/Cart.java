package entity;

import java.util.HashMap;
import java.util.Set;

public class Cart {
private static HashMap<Item,Integer>cart;
private static double Countsum;
public Cart() {
	 cart=new HashMap<Item,Integer>();
	 Countsum=0.0;
}
public static double getCountsum() {
	return Countsum;
}
public static void setCountsum(double countsum) {
	Countsum = countsum;
}
public boolean addItem(Item i,int number) {
  boolean flag=false;
  if(cart.containsKey(i)) {
	  cart.put(i, number+cart.get(i));
	  flag=true;
  }
  else {
	  cart.put(i, number);
	  flag=true;
  }
  countAll();
  return flag;
}
public boolean deleteItem(Item i) {
	boolean flag=false;
	 if(cart!=null&&cart.size()>0) {
		  cart.remove(i);
		  flag=true;
	  }
    countAll();
	return flag;

}

public double countAll() {
	double sum=0.0;
   Set<Item>temp=cart.keySet();
   for(Item i:temp) {
	   sum=sum+Integer.parseInt((i.getPrice()))*cart.get(i);
	  // System.out.println(sum);
   }
   setCountsum(sum);
   return sum;
}
public void showAll() {
	Set<Item>temp=cart.keySet();
	for(Item i:temp) {
		System.out.println(i+"the number of item is "+cart.get(i));
	}
	System.out.println("the total price is "+countAll());
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("hello");
    Item i1=new Item("运动鞋","150","上海","500");
    Item i2=new Item("运动衣","50","北京","500");
    Item i3=new Item("运动裤","250","广州","500");
    Item i4=new Item("运动裤","250","广州","500");
    Cart c=new Cart();
    c.addItem(i1, 1);
    c.addItem(i1, 3);
    c.addItem(i2, 2);
    c.addItem(i3, 3);
    c.addItem(i4, 1);
    c.showAll();
    c.deleteItem(i2);
    c.showAll();
	}

}
