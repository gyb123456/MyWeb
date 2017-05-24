package com.struts2.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport{
	
		private static final long serialVersionUID = 1L;
		
		private String userName;
	    private String password;
	    private String msg; //结果信息属性

	    public String getMsg() {
	        return msg;
	    }
	    public void setMsg(String msg) {
	        this.msg = msg;
	    }
	    public String getUserName() {
	        return userName;
	    }
	    public void setUserName(String userName) {
	        this.userName = userName;
	    }
	    public String getPassword() {
	        return password;
	    }
	    public void setPassword(String password) {
	        this.password = password;
	    }
	   
	    /**
	     *处理用户请求的login()方法
	     *@return结果导航字符串
	     *@throwsException
	     */
		public String login() throws Exception{
	        if("aaa".equals(this.userName) && "aaa".equals(this.password)){
	            msg = "登录成功，欢迎" + this.userName;
	            System.out.println("login-msg===="+msg);
	            //获取ActionContext实例，通过它来访问Servlet API
	            ActionContext context = ActionContext.getContext();
	            //看session中是否已经存放了用户名，如果存放了：说明已经登录了；
	            //否则说明是第一次登录成功
	            if(null != context.getSession().get("userName")){
	                msg = this.userName + "：你已经登录过了!!!";
	            }else{
	                context.getSession().put("userName", this.userName);
	            }
	            return "success";
	        }else{
	            msg = "登录失败，用户名或密码错误";
	            System.out.println("login-msg===="+msg);
	            return "error";
	        }
	    
	    }
	   
	    public String regist() throws Exception{
	        //将用户名，密码添加到数据库中
	        //...
	        msg = "注册成功。";
	        System.out.println("regist-msg===="+msg);
//	        return this.SUCCESS;
	        return "success";  
	    }
	    
	    /*调用时不知名方法名时，将默认执行该execute()方法*/
	    @Override
	    public String execute() throws Exception{
	        if("test".equals(this.userName) && "test".equals(this.password)){
	            msg = "登录成功，欢迎" + this.userName;
	            System.out.println("execute-msg===="+msg);
	            //获取ActionContext实例，通过它来访问Servlet API
	            ActionContext context = ActionContext.getContext();
	            //看session中是否已经存放了用户名，如果存放了：说明已经登录了；
	//否则说明是第一次登录成功
	            if(null != context.getSession().get("uName")){
	                msg = this.userName + "：你已经登录过了!!!";
	            }else{
	                context.getSession().put("uName", this.userName);
	            }
	            return "success";  
	        }else{
	            msg = "登录失败，用户名或密码错";
	            System.out.println("execute-msg===="+msg);
	            return "error";
//	            return this.ERROR;
	        }
	    }
	    
}
