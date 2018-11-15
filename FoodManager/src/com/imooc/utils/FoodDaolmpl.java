package com.imooc.utils;

import com.imooc.domain.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FoodDaolmpl {
	private static Map<String, Food> db = new HashMap<String, Food>();

	public static boolean FoodExits(Food food) {
		boolean flag = false;
		if (db.containsKey(food.getFoodId())) {
			flag = true;
		}
		return flag;
	}

	public static boolean addFood(Map<String, String> temp) {
		boolean flag = false;
		Food food = new Food();
		food.setFoodId(temp.get("FoodId"));
		food.setFoodName(temp.get("FoodName"));
		food.setFoodPrice(temp.get("FoodPrice"));
		food.setFlavour(temp.get("Flavour"));
		food.setPath(temp.get("Path"));
		//System.out.println(temp.get("Path"));
		food.setFoodContext(temp.get("FoodContext"));
		if (!FoodExits(food)) {
			db.put(temp.get("FoodId"), food);
			flag = true;
		}
		return flag;
	}

	public static boolean DeleteFood(Map<String, String> temp) {
		boolean flag = false;
		if (db.remove(temp.get("FoodId")) != null)
			flag = true;
		return flag;
	}

	public static boolean UpdateFood(Map<String, String> temp) {
		boolean flag = false;
		Food food = db.get(temp.get("FoodId"));
		if (FoodExits(food)) {
			food.setFoodName(temp.get("FoodName"));
			food.setFoodPrice(temp.get("FoodPrice"));
			food.setFlavour(temp.get("Flavour"));
			food.setPath(temp.get("path"));
			food.setFoodContext(temp.get("FoodContext"));
			if (db.remove(temp.get("FoodId"), food)) {
				flag = true;
			}
		}
		return flag;
	}

	public static Map<String, Food> GetAllFood() {
		return db;
	}

	public static Food GetFoodByName(Map<String, String> temp) {
		Food food=new Food();
		//System.out.println(db);
		for(String foodid:db.keySet()) {
			if(db.get(foodid).getFoodName().equals(temp.get("FoodName"))) {
				food=db.get(foodid);
			}
		}
		return food;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("FoodId", "001");
		map.put("FoodName", "”„œ„»‚Àø");
		map.put("FoodPrice", "10.00");
		map.put("FoodContext", "∫√≥‘");
		map.put("Flavour", "œ„¿±");
		map.put("Path", "");
		//FoodDaolmpl d=new FoodDaolmpl();
		addFood(map);
	    Map<String,String>map1=new HashMap<String,String>();
	    map1.put("FoodName", "”„œ„»‚Àø");
	    Food food=GetFoodByName(map1);
	   
	    System.out.println(food);
	    //DeleteFood(map);
		Map<String,Food>t=new HashMap<String,Food>();
		t=GetAllFood();
		 //System.out.println(db.get("001"));
		//System.out.println("hello");
		for(String number:t.keySet()) {
			System.out.println(t.get(number));
		}
	}

}
