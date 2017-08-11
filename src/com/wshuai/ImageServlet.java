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
		//1.����BufferedImage���󣬲���(��ȣ��߶ȣ�ͼƬ����)
		BufferedImage bi = new BufferedImage(68, 22, BufferedImage.TYPE_INT_RGB);
		//2.���Graphics����
		Graphics g = bi.getGraphics();
		//3.������ɫ
		Color c = new Color(200,150,255);
		//4.����ɫ��g����
		g.setColor(c);
		//5.����
		g.fillRect(0, 0, 68, 22);
		
		//6.ָ����֤������
		char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
		//7.����random��������ȡ��֤��
		Random r = new Random();
		int len = ch.length; //��ȡch����
		int index; //����һ�������������
		StringBuffer sb = new StringBuffer(); //���ڱ�����֤���ֵ
		//ͨ��ѭ�����ȡ��λ
		for (int i = 0; i < 4; i++) {
			index = r.nextInt(len);
			//�����ַ������ɫ
			g.setColor(new Color(r.nextInt(88),r.nextInt(188),r.nextInt(255)));
			//�����ַ����λ��
			g.drawString(ch[index]+"", (i*15)+3, 18);
			//����֤����ӵ�sb������
			sb.append(ch[index]);
		}
		//����֤�뱣�浽Session�����У�����֮�������֤
		request.getSession().setAttribute("piccode", sb.toString());
		ImageIO.write(bi, "JPG", response.getOutputStream());
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
