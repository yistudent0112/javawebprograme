import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class rafdemo {
    public static void main(String[]args) throws IOException {
    	File demo=new File("demo");
    	if(!demo.exists()) {
    		demo.mkdir();
    	}
    	File file=new File(demo,"raf.dat");
    	if(!file.exists()) {
    		file.createNewFile();
    	}
    	RandomAccessFile raf=new RandomAccessFile(file, "rw");
    	System.out.println(raf.getFilePointer());//��ӡָ��λ��
        int i=1024;
        raf.write(i>>>24);
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);
        raf.writeInt(i);//�����ǵײ�ʵ�ֵķ���
        System.out.println(raf.getFilePointer());
        String s="��";
        raf.writeChars(s);
        //���ļ������ָ����λ0
        raf.seek(0);
        //���ļ���һ���԰��ļ�������byte������ȥ
        byte[] contain=new byte[(int)raf.length()];
        raf.read(contain);
        
        String word=new String(contain);
        System.out.println(word);
    }
}
