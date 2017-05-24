package com.springmvc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.Global;

public class LoginIntegrceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntegrceptor----------preHandle");
		Object user = arg0.getSession().getAttribute(Global.user_session);
		if(user == null){
			String path = arg0.getContextPath();
			arg1.sendRedirect(path);
//			path+"/jsp/login.jsp"
			return false;
		}
		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntegrceptor----------postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("LoginIntegrceptor----------afterCompletion");
	}

}
