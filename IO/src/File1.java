import java.io.File;
import java.io.IOException;

public class File1 {

	public static void main(String[] args) {
		// 了解构造函数的方式，查帮助
		 File file=new File("F:\\JavaWeb程序");
		 
		java.io.File file1 = new java.io.File("F:\\JavaWeb程序\\test1");
		//System.out.println(file1.exists());
		if(!file1.exists()) {
			file1.mkdirs();
		}else {
			file1.delete();
		}
		//判断是否为目录，true表示目录存在，false表示目录不存在或者不是目录
		System.out.println(file1.isDirectory());
		//判断是否为文件
		System.out.println(file1.isFile());
		//File file2=new File("F:\\JavaWeb程序\\日记.text");
        File file2=new File("F:\\\\JavaWeb程序","日记.text");
		if(!file2.exists()) {
			try {
				file2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			file2.delete();
			//常用的file对象api
			System.out.println(file2);//打印的file的toString函数
			System.out.println(file2.getAbsolutePath());//打印的file的绝对路径函数
			System.out.println(file2.getName());
			System.out.println(file2.getParent());
			System.out.println(file1.getName());
			System.out.println(file1.getParent());
		}
	}

}
