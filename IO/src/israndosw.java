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
    		new FileInputStream("f://test.txt"),"gbk");//默认编码方式为gbk,实际情况中编码方式应该按照文件的格式来进行设定
//    	int b;
//    	while((b=in.read())!=-1) {
//    		System.out.print((char)b);
//    	}
    /*
     * 批量读取文件，放入到buffer这个字符数组中去，长度为buffer.length，
     * 返回的是读入字符数的个数
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
