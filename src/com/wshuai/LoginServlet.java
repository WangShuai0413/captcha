package com.wshuai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���Ȼ�ȡԭ������֤����Ϣ
		String piccode = (String) request.getSession().getAttribute("piccode");
		//��ȡ�û���д����֤��
		String checkcode = request.getParameter("checkcode");
		//���÷��ؽ�����ַ���
		response.setContentType("text/html;charset=gbk");
		//�������������
		PrintWriter out = response.getWriter();
		//�ж���֤���Ƿ���ȷ
		//ʹ��equalsIgnoreCase()�����Ƚ��ַ������Ժ��Դ�Сд
		if (checkcode.equalsIgnoreCase(piccode)) {
			out.print("��֤��������ȷ!");
		}else {
			out.print("��֤���������!");
		}
		//ˢ�²��ر���
		out.flush();
		out.close();
	}
}
