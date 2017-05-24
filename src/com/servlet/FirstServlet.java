package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class FirstServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	/*
	 * 当前端用post请求时，就会调用doPost方法
	*  当前端用get请求时，就会调用doGet方法
	*  form表单默认是get
	*  使用ajax时，也会指明type是post还是get的
	*/
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("=========================doPost");
		//super.doPost(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		System.out.println("=========================doGet");
		HttpSession session = req.getSession();
		/*下面这2行代码结果为null，因为用getAttribute必须是先setAttribute*/		
		String username1 = (String) session.getAttribute("username");
		String password1 = (String) session.getAttribute("password");
		
		Enumeration<String> list1 = req.getAttributeNames();//结果为[],没有值
		Enumeration<String> list2 = req.getParameterNames();//结果为 [username, password];

		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username===="+username);
		System.out.println("password===="+password);
		
		PrintWriter printWriter =resp.getWriter();
//		printWriter.write("ssssssss");
		printWriter.write("<script type='text/javascript'>alert('*******后台接收到的username="+username+"***************');</script>" );
//		resp.sendRedirect("index.jsp");
		 
	}
}
