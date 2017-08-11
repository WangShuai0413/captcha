package com.wshuai;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ImageServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.定义BufferedImage对象，参数(宽度，高度，图片类型)
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//2.获得Graphics对象
		Graphics g = bi.getGraphics();
		//3.设置颜色
		Color c = new Color(200,150,255);
		//4.把颜色给g对象
		g.setColor(c);
		//5.画框
		g.fillRect(0, 0, 68, 22);
		
		//6.指定验证码内容
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//7.创建random随机对象获取验证码
		Random r = new Random();
		int len = ch.length; //获取ch长度
		int index; //创建一个随机索引变量
		StringBuffer sb = new StringBuffer(); //用于保存验证码的值
		//通过循环随机取四位
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			//设置字符随机颜色
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			//设置字符随机位置
			g.drawString(ch[index]+"", (i*15)+3, 18);
			//将验证码添加到sb对象中
			sb.append(ch[index]);
		}
		//将验证码保存到Session对象中，方便之后进行验证
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
