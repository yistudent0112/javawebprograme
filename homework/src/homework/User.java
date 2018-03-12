package homework;

public class User {
private String password;
private String name;
	public User(String password, String name) {
	super();
	this.password = password;
	this.name = name;
}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
