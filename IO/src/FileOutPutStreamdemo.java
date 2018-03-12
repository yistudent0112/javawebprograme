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
		// 如果该文件不存在则创建新文件，如果文件存在且append为false，则删除原文件，新建一个文件。
		// 如果append为true，则在文件后部插入新内容
		FileOutputStream out = new FileOutputStream(filename);
		out.write('A');// 只写进了A的低八位
		out.write('B');// 只写进了B的低八位
		int a = 10;// int类型占用4个字节，要分四次写入
		out.write(a >>> 24);
		out.write(a >>> 16);
		out.write(a >>> 8);
		out.write(a);
		byte[] b = "中国".getBytes();
		out.write(b);
		out.flush();
		out.close();
		FileInputStreamdemo.PrintHex(filename);
	}

	public static void CopyByBytes(File srcFile, File copyFile) throws IOException {
		long start = System.currentTimeMillis();
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
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
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
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
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
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
		Copy(new File("f://思维导图"), new File("f://new2.text"));
		CopyByBytes(new File("f://思维导图"), new File("f://new3.text"));
		CopyByBuffer(new File("f://思维导图"), new File("f://new4.text"));
		//DataOutputStream out = new DataOutputStream(new FileOutputStream("f://new.text"));
		// out.writeInt(1);
	}

}
