package com.springmvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.springmvc.Global;
import com.springmvc.bean.User;
import com.springmvc.service.FirstService;

@Controller
@RequestMapping("FirstController")
public class FirstController extends BaseController{

//	@Resource HttpServletRequest request;	
	@Autowired
//	@Resource
	FirstService firstService;
	
	/*@RequestMapping中属性，其中属性可以写多个，属性里的参数也可以是一个或多个
	value="xxx"
	method = RequestMethod.GET
	consumes = {"application/json","text/plain"}指定请求的提交内容类型；
	produces = {"application/json","text/plain"}指定返回的内容类型
	params = "paramName=paramValue"设置参数名为paramName，且参数值=paramValue，才触发该方法
	headers= {"content-type=text/*,Referer=http://www.baidu.com"} 设置当请求头中包含指定的值，才触发该方法
	*/
	@RequestMapping(method = RequestMethod.GET)
	public String hello(){
		//return "helloSpring";
		return "../index";
	}
	
	@RequestMapping("login")
//	@ResponseBody//这个注解使返回的数据不被认为是jsp页面的名称，访问后会直接返回数据
	public String login(String userName,String password, HttpServletRequest request ){
		System.out.println("userName========="+userName);
		System.out.println("password========="+password);
		User user  = firstService.login(userName,password);
		request.getSession().setAttribute(Global.user_session, user);
		return "../index";
	}
	
	@RequestMapping("exception")
	public void exception() throws MyException{
		throw new MyException("异常内容是xxx----------");
	}
	
	public class MyException extends Exception{ 
	 	private static final long serialVersionUID = 1L;
		public MyException(String msg) { 
        	super(msg);
            System.out.println("msg==="+msg); 
        } 
    } 
	
	@RequestMapping("getString")
	@ResponseBody
	public String getString( ){
		return "我是字符串helloTest";
	}
	
	@RequestMapping("getMap")
	@ResponseBody
	public  Map<String, Object> getMap(){
//		return "helloSpring";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("aaa", "mapValue1");
		map.put("bbb", "mapValue2");
		return map;
	}
	
	@RequestMapping("mav")
	@ResponseBody
	public ModelAndView mav(){
		return new ModelAndView("index.jsp");
	}
}
