import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class brbw {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
    BufferedReader bf=new BufferedReader(
    	new InputStreamReader(
    			new FileInputStream("f://test.txt")));
    BufferedWriter bw=new BufferedWriter(
    		new OutputStreamWriter(
    				new FileOutputStream("f://test5.txt")));
    String b;
    while((b=bf.readLine())!=null) {
    	System.out.print(b);//һ�ζ�һ�У�������ʶ���з�
    	bw.write(b);
    	//����д������
    	bw.newLine();//���в���
    	bw.flush();
    }
    bf.close();
    bw.close();
	}

}
