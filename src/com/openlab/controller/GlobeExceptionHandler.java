package com.openlab.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.openlab.exception.NotLoginException;

@ControllerAdvice
public class GlobeExceptionHandler {

	@ExceptionHandler(NotLoginException.class)
	public String notLoginException(NotLoginException e){
		return "front/exception_notlogin";
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String runtimeException(Model model, RuntimeException e){
		e.printStackTrace();
		model.addAttribute("message",e.getMessage());
		return "front/exception_runtime";
	}
	
	@ExceptionHandler(MissingServletRequestParameterException.class)
	public String missingServletRequestParameterException(Model model) {
		model.addAttribute("message","请求缺少参数！");
		return "front/exception_runtime";
	}
	
	@ExceptionHandler(Exception.class)
	public String runtimeException(Model model, Exception e){
		e.printStackTrace();
		model.addAttribute("message", e.getMessage());
		return "front/exception_other";
	}

}
