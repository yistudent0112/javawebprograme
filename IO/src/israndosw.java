import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class israndosw {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
    InputStreamReader in=new InputStreamReader(
    		new FileInputStream("f://test.txt"),"gbk");//Ĭ�ϱ��뷽ʽΪgbk,ʵ������б��뷽ʽӦ�ð����ļ��ĸ�ʽ�������趨
//    	int b;
//    	while((b=in.read())!=-1) {
//    		System.out.print((char)b);
//    	}
    /*
     * ������ȡ�ļ������뵽buffer����ַ�������ȥ������Ϊbuffer.length��
     * ���ص��Ƕ����ַ����ĸ���
     */
    OutputStreamWriter out=new OutputStreamWriter(
    		new FileOutputStream("f://test1.txt"));
    char[] buffer=new char[1024];
    int b;
 
    while((b=in.read(buffer, 0, buffer.length))!=-1) {
    	System.out.print(new String(buffer,0,b));
    	out.write(new String(buffer,0,b));
    	out.flush();
    }
	}

}
