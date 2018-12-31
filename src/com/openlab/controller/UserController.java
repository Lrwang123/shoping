package com.openlab.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.CartBean;
import com.openlab.domain.UserBean;
import com.openlab.service.CommonService;
import com.tools.CheckCode;


@Controller
@RequestMapping("/user")
public class UserController {
	
	
	private CheckCode ck;//验证码生成器，线程安全
	
	@Autowired
	@Qualifier("commonServiceImpl")
	private CommonService commonService;
	
	public UserController() {
		super();
		System.out.println("【UserController】初始化");
		ck = new CheckCode();
	}
	
	@RequestMapping("/login.php")
	public String loginPage(){
		return "login";
	}
	
	@RequestMapping("/login")
	public ModelAndView login(String username, String checkCode, 
			@RequestParam("PWD")String password, 
			@SessionAttribute("randCheckCode") String realCheckCode, 
			HttpSession session){
		ModelAndView mv = new ModelAndView();
		if (checkCode != null && checkCode.toUpperCase().equals(realCheckCode)){
			UserBean user = commonService.getUserByUsername(username, password);
			if (user != null){
				session.setAttribute("username", user.getUsername());
				session.setAttribute("cart", new CartBean());
				System.out.println("登陆用户"+user);
				mv.setViewName("redirect:../goods/index.php");
			} else {
				//账号或密码错误
				System.out.println("账号或密码错误");
			}
		} else {
			//验证码错误
			System.out.println("验证码错误");
		}
		return mv;
	}
	
	@RequestMapping("/checkCode")
	public void checkCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ck.service(req, resp);
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../goods/index.php";
	}
	
}
