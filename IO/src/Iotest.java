
public class Iotest {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String s = "Ľ��ABC";
		byte[] bytes1 = s.getBytes();// ת�����ֽ�����ʹ�õ���Ĭ�ϱ��뷽ʽGBK
		for (byte b : bytes1) {
			// ���ֽ�(ת����int����),��ʮ�����Ʊ�ʾ
			System.out.print(Integer.toHexString(b & 0xff) + "  ");
		}
		System.out.println();
		byte[] bytes2=s.getBytes("gbk");
		//GBK���뷽ʽ����ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
		for(byte b:bytes2) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		System.out.println();
		//utf-8���뷽ʽ����ռ�������ֽڣ�Ӣ��ռ��һ���ֽ�
		byte[] bytes3=s.getBytes("utf-8");
		for(byte b:bytes3) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		System.out.println();
		//java��˫�ֽڱ��� ʹ�õ�utf-16be���뷽ʽ
		//utf-16be����ռ�������ַ���Ӣ��ռ�������ַ�
		byte[]bytes4=s.getBytes("utf-16be");
		for(byte b:bytes4) {
			System.out.print(Integer.toHexString(b&0xff)+" ");
		}
		/*
		 * ������ֽ�������ĳ�ֱ��뷽ʽʱ�����ʱ����ֽ����б��Ϊ�ַ�����ҲҪʹ����ͬ�ı��뷽ʽ����Ȼ���������
		 */
		String str=new String(bytes4);//ʹ��ҳ��Ĭ�ϵı��뷽ʽ��GBK
		System.out.println(str);
		String str1=new String(bytes4,"utf-16be");
		System.out.println(str1);
		/*
		 * �ı��ļ� �����ֽ�����
		 * ���������������ֽ�����
		 * ������������Ļ�����ֱ�Ӵ����ı��ļ���ֻ��ʶansi����
		 */
	}
}
