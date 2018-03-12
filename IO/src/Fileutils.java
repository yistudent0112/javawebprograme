import java.io.File;
import java.io.IOException;

/**
 * @author admin
 *�г�file���һЩ���ò�����������˱�����
 */
public class Fileutils {
   public static void ListDirectory(File dir)throws IOException {
	   if(!dir.exists()) {
		   throw new IllegalArgumentException("������Ŀ¼");
	   }
	   if(!dir.isDirectory()) {
		   throw new IllegalArgumentException(dir+"����Ŀ¼");
	   }
	   String[] filenames=dir.list();//���ص����ַ������� ֱ����Ŀ¼�����ƣ�û����Ŀ¼�µ�����
	   //list()�����������г���ǰĿ¼�µ�������Ŀ¼���ļ�
	   for(String s:filenames) {
		   System.out.println(s);
	   }
	   //���Ҫ������Ŀ¼�µ����ݣ���Ҫ��file�������ݹ������listFiles()��������Ŀ¼��file��������
	   File[] filename=dir.listFiles();//���ص�����Ŀ¼�Ķ���
	   if(filename!=null&&filename.length>0) {
		   for(File temp:filename) {
			   if(temp.isDirectory()) {
				   //�ݹ�
				   ListDirectory(temp);
			   }
			   else {
				   System.out.println(temp);
			   }
		   }
	   }
   }


}
