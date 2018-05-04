package com.imooc.domain;
/*
 * 
    * @ClassName: User  
    * @Description: TODO(User类的抽象类)  
    * @author yi 
    * @date 2018年4月11日  
    *
 */

public class User {
	private String Username;
	private String Password;
	private String PhoneNumber;
	private String Email;

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
