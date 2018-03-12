import java.io.Serializable;

public class Student implements Serializable{
private String Stuno;
private String Stuname;
private transient int Stuage;
	public Student() {

}
	public Student(String stuno, String stuname, int stuage) {
		super();
		Stuno = stuno;
		Stuname = stuname;
		Stuage = stuage;
	}
	public String getStuno() {
	return Stuno;
}
public void setStuno(String stuno) {
	Stuno = stuno;
}
public String getStuname() {
	return Stuname;
}
public void setStuname(String stuname) {
	Stuname = stuname;
}
public int getStuage() {
	return Stuage;
}
public void setStuage(int stuage) {
	Stuage = stuage;
}

	@Override
public String toString() {
	// TODO Auto-generated method stub
	return "student name is "+Stuname+" number is "+Stuno+" age is "+Stuage;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
