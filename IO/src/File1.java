import java.io.File;
import java.io.IOException;

public class File1 {

	public static void main(String[] args) {
		// �˽⹹�캯���ķ�ʽ�������
		 File file=new File("F:\\JavaWeb����");
		 
		java.io.File file1 = new java.io.File("F:\\JavaWeb����\\test1");
		//System.out.println(file1.exists());
		if(!file1.exists()) {
			file1.mkdirs();
		}else {
			file1.delete();
		}
		//�ж��Ƿ�ΪĿ¼��true��ʾĿ¼���ڣ�false��ʾĿ¼�����ڻ��߲���Ŀ¼
		System.out.println(file1.isDirectory());
		//�ж��Ƿ�Ϊ�ļ�
		System.out.println(file1.isFile());
		//File file2=new File("F:\\JavaWeb����\\�ռ�.text");
        File file2=new File("F:\\\\JavaWeb����","�ռ�.text");
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
			//���õ�file����api
			System.out.println(file2);//��ӡ��file��toString����
			System.out.println(file2.getAbsolutePath());//��ӡ��file�ľ���·������
			System.out.println(file2.getName());
			System.out.println(file2.getParent());
			System.out.println(file1.getName());
			System.out.println(file1.getParent());
		}
	}

}
