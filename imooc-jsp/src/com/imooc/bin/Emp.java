package com.imooc.bin;

public class Emp {
private String Account;
private String Name;
private String Password;;
private String Email;

public Emp(String account, String name, String password, String email) {
	super();
	Account = account;
	Name = name;
	Password = password;
	Email = email;
}
public String getAccount() {
	return Account;
}
public void setAccount(String account) {
	Account = account;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getEmail() {
	return Email;
}
public void setEmail(String email) {
	Email = email;
}
}
