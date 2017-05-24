package com.springmvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class BaseController {

	@ExceptionHandler
	public String handleException(Exception ex , HttpServletRequest request){
		request.setAttribute("error", ex.getMessage());
		return "error";
	}
}
