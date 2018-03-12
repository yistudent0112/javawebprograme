import java.io.File;
import java.io.IOException;

/**
 * @author admin
 *列出file类的一些常用操作，比如过滤遍历等
 */
public class Fileutils {
   public static void ListDirectory(File dir)throws IOException {
	   if(!dir.exists()) {
		   throw new IllegalArgumentException("不存在目录");
	   }
	   if(!dir.isDirectory()) {
		   throw new IllegalArgumentException(dir+"不是目录");
	   }
	   String[] filenames=dir.list();//返回的是字符串数组 直接子目录的名称，没有子目录下的内容
	   //list()函数功能是列出当前目录下的所有子目录和文件
	   for(String s:filenames) {
		   System.out.println(s);
	   }
	   //如果要遍历子目录下的内容，就要对file对象做递归操作，listFiles()即返回子目录的file对象数组
	   File[] filename=dir.listFiles();//返回的是子目录的对象
	   if(filename!=null&&filename.length>0) {
		   for(File temp:filename) {
			   if(temp.isDirectory()) {
				   //递归
				   ListDirectory(temp);
			   }
			   else {
				   System.out.println(temp);
			   }
		   }
	   }
   }


}
