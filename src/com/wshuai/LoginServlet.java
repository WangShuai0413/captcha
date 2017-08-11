package com.wshuai;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//首先获取原来的验证码信息
		String piccode = (String) request.getSession().getAttribute("piccode");
		//获取用户填写的验证码
		String checkcode = request.getParameter("checkcode");
		//设置返回结果的字符集
		response.setContentType("text/html;charset=gbk");
		//创建输出流对象
		PrintWriter out = response.getWriter();
		//判断验证码是否正确
		//使用equalsIgnoreCase()方法比较字符串可以忽略大小写
		if (checkcode.equalsIgnoreCase(piccode)) {
			out.print("验证码输入正确!");
		}else {
			out.print("验证码输入错误!");
		}
		//刷新并关闭流
		out.flush();
		out.close();
	}
}
