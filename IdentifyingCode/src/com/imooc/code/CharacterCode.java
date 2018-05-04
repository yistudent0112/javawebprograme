package com.imooc.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

import com.sun.prism.Image;



/**
 * 
    * @ClassName: CharacterCode  
    * @Description: TODO(��֤�빤����)
    * �����ַ�����֤��  
    * @author yi 
    * @date 2018��4��27��  
    *
 */
public class CharacterCode {
public static String DrawImage(HttpServletResponse response) {
	//1.����һ�������ַ���ƴ�ӵ�StringBuilder��
	StringBuilder builder=new StringBuilder();
	//2.��������Ϊ4������ַ���
	for(int i=0;i<4;i++) {
		builder.append(RamdonChar());
	}
	String word=builder.toString();
	//3.����ͼƬ�Ŀ�Ⱥ͸߶�
	int width=120;
	int height=25;
	//����BufferImage����,�ƶ�ͼƬ�ĳ��ȺͿ�Ⱥ�ɫ��
	BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	//4.����Graphics2D���ƶ��󣬿�ʼ������֤��
	Graphics2D g=bi.createGraphics();
	//�������ֵ�����ʹ�С
	Font font=new Font("΢���ź�",Font.PLAIN,20);
	//�����������ɫ
	Color color=new Color(0,0,0);
	//���ñ�����ɫ
	Color background=new Color(226, 226, 240);
	//�����ƶ��������������ɫ������ʹ�С
	g.setColor(color);
	g.setFont(font);
	g.setBackground(background);
	//��ʼ���ƶ���
	g.clearRect(0, 0, width, height);
	//������״����þ��ζ���
	FontRenderContext context=g.getFontRenderContext();
	Rectangle2D bounds=font.getStringBounds(word, context);
	//�����ļ�������ͼ��
	double x=(width-bounds.getWidth())/2;
	double y=(height-bounds.getHeight())/2;
	double ascent=bounds.getY();
	double BaseY=y-ascent;
	g.drawString(word, (int)x,(int) BaseY);
	//��������
	g.dispose();
	try {
		ImageIO.write(bi, "jpg", response.getOutputStream());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return word;
}
/**
 * 
    * @Title: DrawImageVerificate  
    * @Description: TODO(����һ���������ʽ��֤��)  
    * 1.�����ߵĲ���
    * 2.�����Χ�ڲ����������ɫ
    * @param @param response
    * @param @return    ����  
    * @return String    ��������  
    * @throws
 */
public static String DrawImageVerificate(HttpServletResponse response) {
	//������֤��ĳ��ȺͿ��
	int height=30;
	int width=200;
	//���ڴ��д���ͼƬ
	BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	//����ͼƬ��������
	Graphics2D g=image.createGraphics();
	//����һ��������󣬴���������������������
	Random random=new Random();
	//���ñ���
    g.setColor(GetRandomColor(240, 250));
    //��������
    g.setFont(new Font("΢���ź�", Font.PLAIN, 22));
    //��ʼ����
    g.fillRect(0, 0, width, height);
    
    //�����ߵĻ��ƣ���ʼ���Ƹ�����
    for(int i=0;i<5;i++) {
    	int x=random.nextInt(width);
    	int y=random.nextInt(height);
    	int x1=random.nextInt(60);
    	int y1=random.nextInt(60);
    	g.drawLine(x, y, x1, y1);
 
    	 g.setColor(GetRandomColor(0, 10));
    }
    //��ʼ����������֤��
    int result=0;
    int number1=random.nextInt(9)+1;
    int number2=random.nextInt(9)+1;
    int fuhao=random.nextInt(3);
    String fuhaostr="";
    switch(fuhao) {
    case 0:fuhaostr=number1+" + "+number2+" =  ?";result=number1+number2;break;
    case 1:fuhaostr=number1+" - "+number2+" =  ?";result=number1-number2;break;
    case 2:fuhaostr=number1+" * "+number2+" =  ?";result=number1*number2;break;
    }
    //���������ɫ
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
    //���Ʊ��ʽ
    g.drawString(fuhaostr, 5, 25);
    //��������
    g.dispose();
	try {
		ImageIO.write(image, "jpg", response.getOutputStream());
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return String.valueOf(result);
}
/**
 * 
    * @Title: GetRandomColor  
    * @Description: TODO(�ڸ�����Χ������һ�������ɫ)  
    * @param @param fc
    * @param @param bc
    * @param @return    ����  
    * @return Color    ��������  
    * @throws
 */
public static Color GetRandomColor(int fc,int bc) {
	//����һ�����������
	Random random=new Random();
	if(fc>255)
		fc=255;
	if(bc>255)
		bc=255;
	//���ɶ�Ӧ����ԭɫ���������red,green,blue
	int red=fc+random.nextInt(bc-fc);
	int green=fc+random.nextInt(bc-fc);
	int blue=fc+random.nextInt(bc-fc);
	return new Color(red, green, blue);
}
/**
 * 
    * @Title: RamdonChar  
    * @Description: TODO(����һ�����char���͵�Ӣ�Ļ�����)  
    * @param @return    ����  
    * @return char    ��������  
    * @throws
 */
public static char RamdonChar() {
	String word="qwertyuiopasdfghjklzxcvbnm1234567890";
	 Random r=new Random();
	return word.charAt(r.nextInt(word.length()));
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*System.out.println(DrawImage(null));
System.out.println(new Date());*/
/*		Random random=new Random();
		for(int i=0;i<100;i++) {
			System.out.println(random.nextInt(10));
		}*/
	}

}
