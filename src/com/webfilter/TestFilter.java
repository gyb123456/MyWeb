package com.webfilter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

//过滤器类，所有的资源调用时，都会进到该类
/**
 因为配置文件里已经配置了，所以这里就把注解注释掉了
 */
/* @WebFilter (filterName="TestFilter",urlPatterns={"/*"},
 
						initParams={
														@WebInitParam(name="logFileName",value="logTest.txt"),
														@WebInitParam(name="prefix",value=" url: ")
												}
						)
*/
public class TestFilter implements Filter{
	private PrintWriter logger;
	
	@Override
	public void destroy() {
		System.out.println("========filter关闭======");
		// TODO Auto-generated method stub
		if(logger!=null){
			logger.close();
		}
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		// TODO Auto-generated method stub
		//System.out.println("TestFilter========doFilter====");
		HttpServletRequest http = (HttpServletRequest) arg0;
		String referer = http.getHeader("referer");
		System.out.println("referrer = "+referer);
		logger.println(new Date()+"; url = "+http.getRequestURL());
		logger.flush();
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("Filter-init========"+arg0.getFilterName());
		String logFileName = arg0.getInitParameter("logFileName");
		String path = arg0.getServletContext().getRealPath("/");
		System.out.println("Filter-path========"+path);
		try {
			logger = new PrintWriter(new File(path, logFileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
