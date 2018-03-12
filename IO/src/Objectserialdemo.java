import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Objectserialdemo {

	public static void main(String[] args)throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		String file = "demo/test.txt";
		ObjectOutputStream out=new ObjectOutputStream(
				new FileOutputStream(file));
		Student s=new Student("001","yi",20);
		out.writeObject(s);
		out.flush();
		ObjectInputStream in=new ObjectInputStream(
				new FileInputStream(file));
		Student temp=(Student)in.readObject();
		System.out.println(temp);
		Foo2 f=new Foo2();
		out.writeObject(f);
		//序列化会调用父类的构造函数
		out.close();
		in.close();
	}
/*
 * 一个类实现了序列化接口，那么其子类也能进行序列化
 * 对子类对象进行反序列化操作时，如果父类没有实现序列化接口，那么其构造函数将会被调用
 */
}
class Foo implements Serializable{
	public Foo() {
		System.out.println("Foo()");
	}
}
class Foo1 extends Foo{
	public Foo1() {
		System.out.println("Foo1()");
	}
}
class Foo2 extends Foo1{
	public Foo2() {
		System.out.println("Foo2()");
	}
}
