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
    * @Description: TODO(验证码工具类)
    * 产生字符串验证码  
    * @author yi 
    * @date 2018年4月27日  
    *
 */
public class CharacterCode {
public static String DrawImage(HttpServletResponse response) {
	//1.定义一个用于字符串拼接的StringBuilder类
	StringBuilder builder=new StringBuilder();
	//2.产生长度为4的随机字符串
	for(int i=0;i<4;i++) {
		builder.append(RamdonChar());
	}
	String word=builder.toString();
	//3.定义图片的宽度和高度
	int width=120;
	int height=25;
	//建立BufferImage对象,制定图片的长度和宽度和色彩
	BufferedImage bi=new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
	//4.创建Graphics2D绘制对象，开始绘制验证码
	Graphics2D g=bi.createGraphics();
	//设置文字的字体和大小
	Font font=new Font("微软雅黑",Font.PLAIN,20);
	//设置字体的颜色
	Color color=new Color(0,0,0);
	//设置背景颜色
	Color background=new Color(226, 226, 240);
	//给绘制对象设置字体的颜色，字体和大小
	g.setColor(color);
	g.setFont(font);
	g.setBackground(background);
	//开始绘制对象
	g.clearRect(0, 0, width, height);
	//绘制形状，获得矩形对象
	FontRenderContext context=g.getFontRenderContext();
	Rectangle2D bounds=font.getStringBounds(word, context);
	//计算文件的坐标和间距
	double x=(width-bounds.getWidth())/2;
	double y=(height-bounds.getHeight())/2;
	double ascent=bounds.getY();
	double BaseY=y-ascent;
	g.drawString(word, (int)x,(int) BaseY);
	//结束绘制
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
    * @Description: TODO(生成一个算数表达式验证码)  
    * 1.干扰线的产生
    * 2.随机范围内产生的随机颜色
    * @param @param response
    * @param @return    参数  
    * @return String    返回类型  
    * @throws
 */
public static String DrawImageVerificate(HttpServletResponse response) {
	//定义验证码的长度和宽度
	int height=30;
	int width=200;
	//在内存中创建图片
	BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	//创建图片的上下文
	Graphics2D g=image.createGraphics();
	//产生一个随机对象，此随机对象用于生成随机数
	Random random=new Random();
	//设置背景
    g.setColor(GetRandomColor(240, 250));
    //设置字体
    g.setFont(new Font("微软雅黑", Font.PLAIN, 22));
    //开始绘制
    g.fillRect(0, 0, width, height);
    
    //干扰线的绘制，开始绘制干扰线
    for(int i=0;i<5;i++) {
    	int x=random.nextInt(width);
    	int y=random.nextInt(height);
    	int x1=random.nextInt(60);
    	int y1=random.nextInt(60);
    	g.drawLine(x, y, x1, y1);
 
    	 g.setColor(GetRandomColor(0, 10));
    }
    //开始绘制算术验证码
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
    //设置随机颜色
    g.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
    //绘制表达式
    g.drawString(fuhaostr, 5, 25);
    //结束绘制
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
    * @Description: TODO(在给定范围内生成一个随机颜色)  
    * @param @param fc
    * @param @param bc
    * @param @return    参数  
    * @return Color    返回类型  
    * @throws
 */
public static Color GetRandomColor(int fc,int bc) {
	//生成一个随机数对象
	Random random=new Random();
	if(fc>255)
		fc=255;
	if(bc>255)
		bc=255;
	//生成对应的三原色随机变量，red,green,blue
	int red=fc+random.nextInt(bc-fc);
	int green=fc+random.nextInt(bc-fc);
	int blue=fc+random.nextInt(bc-fc);
	return new Color(red, green, blue);
}
/**
 * 
    * @Title: RamdonChar  
    * @Description: TODO(生成一个随机char类型的英文或数字)  
    * @param @return    参数  
    * @return char    返回类型  
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
