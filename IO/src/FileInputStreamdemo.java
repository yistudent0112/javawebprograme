import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamdemo {
	/*
	 * 读取指定文件内容，并按照16进制输出到控制台
	 * 每读取10个byte换行
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
		byte[] bytes=new byte[10*1024];//设置一个10K大小的byte数组
		/*
		 * 从in中批量读取字节，存放到bytes这个数组中去
		 * 从0的位置开始放，一共放入bytes.length个的数据
		 * b表示一共放进了多少个数组
		 */
		 //一次性读取方法
//		int b=in.read(bytes,0, bytes.length);//一次性读完，说明字节数组足够大
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
				int temp= (bytes[i]&0xff);//byte类型32位，int类型8位，为s避免数据出错，直接将数据&0xff，去除高24位数据
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
	   //FileInputStreamdemo.PrintHex("f://思维导图//上网原理.pdf");
	   FileInputStreamdemo.PrintHexByFile("f://思维导图//上网原理.pdf");
   }
}
