
public class Iotest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "慕课ABC";
		byte[] bytes1 = s.getBytes();// 转换成字节序列使用的是默认编码方式GBK
		for (byte b : bytes1) {
			// 把字节(转换成int类型),以十六进制表示
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println();
		byte[] bytes2=s.getBytes("gbk");
		//GBK编码方式中文占用两个字节，英文占用一个字节
		for(byte b:bytes2) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		System.out.println();
		//utf-8编码方式中文占用三个字节，英文占用一个字节
		byte[] bytes3=s.getBytes("utf-8");
		for(byte b:bytes3) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		System.out.println();
		//java是双字节编码 使用的utf-16be编码方式
		//utf-16be中文占用两个字符，英文占用两个字符
		byte[]bytes4=s.getBytes("utf-16be");
		for(byte b:bytes4) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		/*
		 * 当你的字节序列是某种编码方式时，这个时候把字节序列变回为字符串是也要使用相同的编码方式，不然会产生乱码
		 */
		String str=new String(bytes4);//使用页面默认的编码方式即GBK
		System.out.println(str);
		String str1=new String(bytes4,"utf-16be");
		System.out.println(str1);
		/*
		 * 文本文件 就是字节序列
		 * 可以是任意编码的字节序列
		 * 如果我们在中文机器上直接创建文本文件那只认识ansi编码
		 */
	}
}
