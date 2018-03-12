package homework;

import java.util.HashMap;
import java.util.Map;

public class Database {
public static Map<String,User>user=new HashMap<String,User>();
static {
	user.put("admin", new User("000000","admin"));
}
public static boolean SelectUserByPassword(User u) {
	boolean flag=false;
	for(String name:user.keySet()) {
		if(u.getName().equals(name)&&u.getPassword().equals(user.get(name).getPassword()))
			flag=true;
	}
	return flag;
}
public static boolean UserExits(User u) {
	boolean flag=false;
	for(String name:user.keySet()) {
		User temp=user.get(name);
		if(u.getName().equals(name)&&u.getPassword().equals(temp.getPassword()))
			flag=true;
	}
	return flag;
}
public static boolean AddUser(User u) {
	boolean flag=false;
	if(!UserExits(u)) {
		user.put(u.getName(), u);
		flag=true;
	}
	return flag;
}
public static void RemoveUser(String name) {
	user.remove(name); 
}
public static Map<String,Board>board=new HashMap<String,Board>();
static {
	board.put("101",new Board("101","Au","Au price is 280.00"));
	board.put("102",new Board("102","Ag","Ag price is 28.50"));
	board.put("103",new Board("103","Brass","Brass price is 5.30"));
	board.put("104",new Board("104","Al","Al price is 1.44"));
	board.put("105",new Board("105","asphalt","asphlat price is 0.28"));
}
public static boolean BoardExits(Board b) {
	boolean flag=false;
	for(String number:board.keySet()) {
		Board temp=board.get(number);
		if(temp.getNumber().equals(b.getNumber()))
			flag=true;
	}
	return flag;
}
public static boolean AddBoard(Board b) {
	boolean flag=false;
	if(!BoardExits(b)) {
		board.put(b.getNumber(), b);
		flag=true;
	}
	return flag;
}
public static boolean UpdateBoard(Board b) {
	boolean flag=false;
	if(BoardExits(b)) {
	board.replace(b.getNumber(), b);
	flag=true;
	}
	return flag;
}
public static void RemoveBoard(String number) {
	board.remove(number);
}
public static boolean SearchBoard(String number) {
	boolean flag=false;
	for(String temp:board.keySet()) {
		if(temp.equals(number)) {
			flag=true;
			break;
		}
	}
	return flag;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
User u=new User("000000","admin");
System.out.println(Database.SelectUserByPassword(u));
System.out.println(Database.UserExits(u));
Database.AddUser(new User("000000","yi"));
Database.RemoveUser("admin");
System.out.println(Database.user.keySet()+" "+Database.user.entrySet());
Board b1=new Board("105","美金","100");
Board b2=new Board("104","铝材","铝材现价为1.44");
Database.UpdateBoard(b1);
Database.RemoveBoard(b2.getNumber());
System.out.println(Database.board.keySet()+" "+Database.board.entrySet());
System.out.println(Database.SearchBoard("101"));
	}

}
