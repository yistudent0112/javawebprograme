import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutPutStreamdemo {
	public static void write(String filename) throws IOException {
		// ������ļ��������򴴽����ļ�������ļ�������appendΪfalse����ɾ��ԭ�ļ����½�һ���ļ���
		// ���appendΪtrue�������ļ��󲿲���������
		FileOutputStream out = new FileOutputStream(filename);
		out.write('A');// ֻд����A�ĵͰ�λ
		out.write('B');// ֻд����B�ĵͰ�λ
		int a = 10;// int����ռ��4���ֽڣ�Ҫ���Ĵ�д��
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] b = "�й�".getBytes();
		out.write(b);
		out.flush();
		out.close();
		FileInputStreamdemo.PrintHex(filename);
	}

	public static void CopyByBytes(File srcFile, File copyFile) throws IOException {
		long start = System.currentTimeMillis();
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(copyFile);
		byte[] buf = new byte[10 * 1024];
		in.read(buf, 0, buf.length);
		out.write(buf, 0, buf.length);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		in.close();
		out.close();
	}

	public static void Copy(File srcFile, File copyFile) throws IOException {
		long start = System.currentTimeMillis();
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(copyFile);
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		in.close();
		out.close();
	}

	public static void CopyByBuffer(File srcFile, File copyFile) throws IOException {
		long start = System.currentTimeMillis();
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("�ļ���" + srcFile + "������");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "�����ļ�");
		}
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(srcFile));
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(copyFile));
		int b;
		while ((b = in.read()) != -1) {
			out.write(b);
			out.flush();
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		in.close();
		out.close();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		// write("f://new.text");
		Copy(new File("f://˼ά��ͼ"), new File("f://new2.text"));
		CopyByBytes(new File("f://˼ά��ͼ"), new File("f://new3.text"));
		CopyByBuffer(new File("f://˼ά��ͼ"), new File("f://new4.text"));
		//DataOutputStream out = new DataOutputStream(new FileOutputStream("f://new.text"));
		// out.writeInt(1);
	}

}
