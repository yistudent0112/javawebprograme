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
    	System.out.println(raf.getFilePointer());//打印指针位置
        int i=1024;
        raf.write(i>>>24);
        raf.write(i>>>16);
        raf.write(i>>>8);
        raf.write(i);
        raf.writeInt(i);//上面是底层实现的方法
        System.out.println(raf.getFilePointer());
        String s="中";
        raf.writeChars(s);
        //读文件必须把指针置位0
        raf.seek(0);
        //读文件，一次性把文件都读到byte数组中去
        byte[] contain=new byte[(int)raf.length()];
        raf.read(contain);
        
        String word=new String(contain);
        System.out.println(word);
    }
}
