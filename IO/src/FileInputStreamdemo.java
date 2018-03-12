import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamdemo {
	/*
	 * ��ȡָ���ļ����ݣ�������16�������������̨
	 * ÿ��ȡ10��byte����
	 */
	public static void PrintHex(String filename)throws IOException {
		FileInputStream in=new FileInputStream(filename);
		int b;
		int i=1;
		while((b=in.read())!=-1) {
			if(b<=0xf) {
				System.out.print("0");
			}
			System.out.print(Integer.toHexString(b)+" ");
			if((i++)%10==0) {
				System.out.println();
			}
		}
	}
	public static void PrintHexByFile(String filename)throws IOException{
		FileInputStream in=new FileInputStream(filename);
		byte[] bytes=new byte[10*1024];//����һ��10K��С��byte����
		/*
		 * ��in��������ȡ�ֽڣ���ŵ�bytes���������ȥ
		 * ��0��λ�ÿ�ʼ�ţ�һ������bytes.length��������
		 * b��ʾһ���Ž��˶��ٸ�����
		 */
		 //һ���Զ�ȡ����
//		int b=in.read(bytes,0, bytes.length);//һ���Զ��꣬˵���ֽ������㹻��
//		for(int j=0;j<b;j++) {
//			if(bytes[j]<=0xf) {
//				System.out.print("0");
//			}
//			System.out.print(Integer.toHexString(bytes[j])+" ");
//			if(j%10==0) {
//				System.out.println();
//			}
//		}
		int b=0;
		while((b=in.read(bytes,0, bytes.length))!=-1) {
			for(int i=0;i<bytes.length;i++) {
				int temp= (bytes[i]&0xff);//byte����32λ��int����8λ��Ϊs�������ݳ���ֱ�ӽ�����&0xff��ȥ����24λ����
				if(temp<=0xf) {
					System.out.print("0");
				}
				System.out.print(Integer.toHexString(temp)+" ");
				if(i%10==0) {
					System.out.println();
				}
			}
		}
	}
   public static void main(String[] args) throws IOException {
	   //FileInputStreamdemo.PrintHex("f://˼ά��ͼ//����ԭ��.pdf");
	   FileInputStreamdemo.PrintHexByFile("f://˼ά��ͼ//����ԭ��.pdf");
   }
}
