package com.imooc.db;

import java.util.HashMap;
import java.util.Map;

import com.imooc.bin.Emp;

public class Dbutil {
	public static Map<String, Emp> map = new HashMap<String, Emp>();
	static {
		map.put("101", new Emp("101", "aa", "123456", "aa@imooc.com"));
		map.put("102", new Emp("102", "bb", "123456", "bb@imooc.com"));
		map.put("103", new Emp("103", "cc", "123456", "cc@imooc.com"));
		map.put("104", new Emp("104", "dd", "123456", "dd@imooc.com"));
	}

	// 用来判断用户名与密码是否正确
	public static boolean SelectEmpByAccountAndPassword(Emp temp) {
		boolean flag = false;
		for (String e : map.keySet()) {
			Emp other = map.get(e);
			if (other.getAccount().equals(temp.getAccount()) && other.getPassword().equals(temp.getPassword())) {
				flag = true;
				break;
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		Emp e = new Emp("101", "aa", "123456", "aa@imooc.com");
		boolean a = Dbutil.SelectEmpByAccountAndPassword(e);
		System.out.println(a);
	}
}
