package com.imooc.domain;

public class User {
private String username;
private String password;
private String nickname;
private String sex;
private String hobby;
private String path;
	public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getHobby() {
	return hobby;
}
public void setHobby(String hobby) {
	this.hobby = hobby;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
	public User(String username, String password, String nickname, String sex, String hobby, String path) {
	super();
	this.username = username;
	this.password = password;
	this.nickname = nickname;
	this.sex = sex;
	this.hobby = hobby;
	this.path = path;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
