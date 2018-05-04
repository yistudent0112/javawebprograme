package com.imooc.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.imooc.domain.Catgory;

/*
 * 
    * @ClassName: BookCatgoryList  
    * @Description: TODO(用来存贮书本分类信息的数据类)  
    * @author yi 
    * @date 2018年4月12日  
    *
 */
public class BookCatgoryList {
	/*
	 * 用来存放添加过的书籍分类的书籍分类表
	 */
	private static Map<String, Catgory> CatgoryDB = new HashMap<String, Catgory>();

	/**
	 * 
	 * @Title: CatgoryExits @Description: TODO(用来判断书籍分类是否被注册过) @param @param
	 *         catgory @param @return 参数 @return boolean 返回类型 @throws
	 */
	public static boolean CatgoryExits(Catgory catgory) {
		boolean flag = false;
		if (CatgoryDB.containsKey(catgory.getId())) {
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @Title: AddCatgory @Description: TODO(用来添加书本分类到数据库中去) @param @param
	 *         temp @param @return 参数 @return boolean 返回类型 @throws
	 */
	public static boolean AddCatgory(Map<String, String> temp) {
		boolean flag = false;
		Catgory catgory = new Catgory();
		catgory.setId(temp.get("Id"));
		catgory.setName(temp.get("Name"));
		catgory.setDescription(temp.get("Description"));
		if (!CatgoryExits(catgory)) {
			CatgoryDB.put(catgory.getId(), catgory);
			flag = true;
		}
		return flag;
	}

	/**
	 * 
	 * @Title: GetCatgorys @Description:
	 * TODO(以String数组的形式返回所有的书籍分类信息) @param @return 参数 @return String[] 返回类型 @throws
	 */
	public static String[] GetCatgorys() {
		Set<String> key = CatgoryDB.keySet();
		String[] Catgorys = new String[key.size()];
		System.out.println("key size :" + key.size());
		int i = 0;
		for (String temp : key) {
			Catgorys[i] = CatgoryDB.get(temp).getName();
			i++;
		}
		return Catgorys;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		Catgory c1 = new Catgory();
		Catgory c2 = new Catgory();
		Catgory c3 = new Catgory();
		Catgory c4 = new Catgory();
		Catgory c5 = new Catgory();
		Catgory c6 = new Catgory();
		c1.setId("1");
		c2.setId("2");
		c3.setId("3");
		c4.setId("4");
		c5.setId("5");
		c6.setId("6");

		c1.setName("11");
		c2.setName("12");
		c3.setName("13");
		c4.setName("14");
		c5.setName("15");
		c6.setName("16");

		CatgoryDB.put(c1.getId(), c1);
		CatgoryDB.put(c2.getId(), c2);
		CatgoryDB.put(c3.getId(), c3);
		CatgoryDB.put(c4.getId(), c4);
		CatgoryDB.put(c5.getId(), c5);
		CatgoryDB.put(c6.getId(), c6);

		String[] temp = GetCatgorys();
		for (String word : temp) {
			System.out.println(word);
		}*/
	}

}
