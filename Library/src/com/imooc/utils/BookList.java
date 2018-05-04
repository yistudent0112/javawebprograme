 package com.imooc.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.imooc.domain.Book;


/*
 * 
    * @ClassName: BookList  
    * @Description: TODO(用来存贮书本信息的数据类)  
    * @author yi 
    * @date 2018年4月12日  
    *
 */
public class BookList {
	/**
	 * 用来存放添加过的图书的图书表
	 */
	private static Map<String, Book>BookDB=new HashMap<String,Book>();
	/**
	 * 
	    * @Title: BookExits  
	    * @Description: TODO(用来判断图书是否被注册过)  
	    * @param @param book
	    * @param @return    参数  
	    * @return boolean    返回类型  
	    * @throws
	 */
public static boolean BookExits(Book book) {
	boolean flag=false;
	if(BookDB.containsKey(book.getId())) {
		flag=true;
	}
	return flag;
}
/**
 * 
    * @Title: AddBook  
    * @Description: TODO(给servlet调用，来添加书本到书本表中去，并判断是否与表中的书本重复)  
    * @param @param temp
    * @param @return    参数  
    * @return boolean    返回类型  
    * @throws
 */
public static boolean AddBook(Map<String,String> temp) {
	boolean flag=false;
	Book book=new Book();
	book.setId(temp.get("Id"));
	book.setBookName(temp.get("BookName"));
	book.setCatgoryName(temp.get("CatgoryName"));
	book.setDescription(temp.get("Description"));
	book.setPrice(temp.get("Price"));
	if(!(BookExits(book))) {
		BookDB.put(book.getId(), book);
		flag=true;
	}
	return flag;
}
/**
 * 
    * @Title: FindBookByName1  
    * @Description: TODO(在数据中通过书名来找书，并返回结果)  
    * @param @param name
    * @param @return    参数  
    * @return Book    返回类型  
    * @throws
 */
public static Book FindBookByName1(String name) {
	Book book=null;
	Set<String>key=BookDB.keySet();
	for(String temp:key) {
		if(BookDB.get(temp).getBookName().equals(name)) {
			book=BookDB.get(temp);
			break;
		}
	}
	return book;
}
/**
 * 
    * @Title: FindBookByName  
    * @Description: TODO(把找到的结果打包成前台可以使用的形式)  
    * @param @param name
    * @param @return    参数  
    * @return List<Map<String,String>>    返回类型  
    * @throws
 */
public static List<Map<String,String>>FindBookByName(String name){
	List<Map<String,String>> temp=new ArrayList<Map<String,String>>();
	Book book=FindBookByName1(name);
	if(book!=null) {
	 	Map<String,String>temp2=new HashMap<String,String>();
		temp2.put("Id", book.getId());
		temp2.put("BookName", book.getBookName());
	    temp2.put("CatgoryName", book.getCatgoryName());
	    temp2.put("Price", book.getPrice());
	    temp2.put("Description", book.getDescription());
	    temp.add(temp2);
		return temp;
		}else {
			return null;
		}
}
/**
 * 
    * @Title: FindBook  
    * @Description: TODO(在数据中通过Id查找一本书，并返回结果)  
    * @param @param id
    * @param @return    参数  
    * @return Book    返回类型  
    * @throws
 */
public static Book FindBook(String id) {
	Book temp=null;
	temp=BookDB.get(id);
	return temp;
}
/**
 * 
    * @Title: FindBookByName  
    * @Description: TODO(在数据中通过Id查找一本书，并返回结果)  
    * @param @param id
    * @param @return    参数  
    * @return List<Map<String,String>>    返回类型  
    * @throws
 */
public static List<Map<String,String>>FindBookById(String id){
	List<Map<String,String>> temp=new ArrayList<Map<String,String>>();
	Book book=FindBook(id);
	if(book!=null) {
 	Map<String,String>temp2=new HashMap<String,String>();
	temp2.put("Id", book.getId());
	temp2.put("BookName", book.getBookName());
    temp2.put("CatgoryName", book.getCatgoryName());
    temp2.put("Price", book.getPrice());
    temp2.put("Description", book.getDescription());
    temp.add(temp2);
	return temp;
	}else {
		return null;
	}
}
/**
 * 
    * @Title: GetBooks  
    * @Description: TODO(返回一个存有所有书籍信息的List)  
    * @param @return    参数  
    * @return List<Book>    返回类型  
    * @throws
 */
public static List<Book> GetBooks(){
	List<Book>temp=new ArrayList<Book>();
	Set<String>key=BookDB.keySet();
	for(String keyword:key) {
		temp.add(BookDB.get(keyword));
	}
	return temp;
}

/**
 * 
    * @Title: GetBookMap  
    * @Description: TODO(返回一个存有所有书籍信息的List)  
    * @param @return    参数  
    * @return List<Map<String,String>>    返回类型  
    * @throws
 */
public static List<Map<String,String>>GetBookMap(){
	List<Map<String,String>> temp=new ArrayList<Map<String,String>>();
    List<Book>books=GetBooks();
    for(Book book:books) {
    	Map<String,String>temp2=new HashMap<String,String>();
    	temp2.put("Id", book.getId());
    	temp2.put("BookName", book.getBookName());
        temp2.put("CatgoryName", book.getCatgoryName());
        temp2.put("Price", book.getPrice());
        temp2.put("Description", book.getDescription());
        temp.add(temp2);
    }
	return temp;
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    Book b1=new Book();
    Book b2=new Book();
    Book b3=new Book();

    b1.setBookName("1");
    b1.setId("1");
    b1.setPrice("10");
    b1.setDescription("1");
    
    b2.setBookName("2");
    b2.setId("2");
    b2.setPrice("20");
    b2.setDescription("2");
    
    b3.setBookName("3");
    b3.setId("3");
    b3.setPrice("20");
    b3.setDescription("3");
    
    BookDB.put(b1.getId(), b1);
    BookDB.put(b2.getId(), b2);
    BookDB.put(b3.getId(), b3);
    
 /*   List<Book>list=GetBooks();
    for(Book b:list) {
    	System.out.println(b.getId()+" "+b.getBookName());
    }*/
 /*   Book book1=FindBook("1");
    System.out.println(book1.getId()+book1.getBookName());
    Book book2=FindBookByName1("3");
    System.out.println(book2.getId()+book2.getBookName());*/
    List<Map<String,String>> temp=FindBookById("2");
    Map<String,String>map=temp.get(0);
    System.out.println(map.get("Id"));
    System.out.println(map.get("BookName"));
	}

}
