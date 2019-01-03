package com.openlab.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.CartBean;
import com.openlab.domain.UserBean;
import com.openlab.service.CommonService;
import com.tools.CheckCode;

@Controller
@RequestMapping("/user")
public class UserController {

	private CheckCode ck;// 验证码生成器，线程安全

	@Autowired
	@Qualifier("commonServiceImpl")
	private CommonService commonService;

	public UserController() {
		super();
		System.out.println("【UserController】初始化");
		ck = new CheckCode();
	}

	@RequestMapping("/login.php")
	public String loginPage() {
		return "login";
	}

	@RequestMapping("/login")
	public ModelAndView login(@RequestParam("username") String username,
			@RequestParam("PWD") String password,
			@RequestParam("checkCode") String checkCode,
			@SessionAttribute("randCheckCode") String realCheckCode,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		if (checkCode.toUpperCase().equals(realCheckCode)) {
			UserBean user = commonService.getUser(username, password);
			if (user != null) {
				session.setAttribute("username", user.getUsername());
				session.setAttribute("cart", new CartBean());
				System.out.println("登陆用户" + user);
				mv.setViewName("redirect:../goods/index.php");
			} else {
				throw new RuntimeException("账号或密码错误");
			}
		} else {
			throw new RuntimeException("验证码错误");
		}
		return mv;
	}

	@RequestMapping("/checkCode")
	public void checkCode(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		ck.service(req, resp);
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:../goods/index.php";
	}
	
	@RequestMapping("/register.php")
	public String getRegisterPage() {
		return "register";
	}

	@RequestMapping("/register")
	@ResponseBody
	public String register(@Valid UserBean user, Errors errors) {
		if (errors.hasErrors()){
			throw new RuntimeException(errors.getFieldError().getDefaultMessage());
		}
		boolean res = commonService.register(user);
		if (res == true) {
			return "<script>alert(\"register success" + "\");window.location.href=\"../goods/index.php\"</script>";			
		} else {
			throw new RuntimeException("注册失败,请重试");						
		}
	}
	
	@RequestMapping("modifyMember.php")
	public String getModifyMemberPage(Model model,
			@SessionAttribute("username") String username) {
		model.addAttribute("user", commonService.getUser(username));
		return "modifyMember";
	}
	
	@RequestMapping("modifyMember")
	@ResponseBody
	public String modifyMember(UserBean user, @RequestParam("passwordOld")String password) {
		boolean res = commonService.modifyMember(user, password);
		if (res == true) {
			return "<script>alert(\"modify success" + "\");window.location.href=\"../goods/index.php\"</script>";			
		} else {
			throw new RuntimeException("修改失败,请重试");						
		}
	}


	@RequestMapping("test")
	@ResponseBody
	public String test(HttpServletRequest request){
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)request;
		MultipartFile file = mhsr.getFile("file");
		String fileName = file.getOriginalFilename();
		File dest = new File(fileName);
		try {
			//保存文件
			file.transferTo(dest);
			return "upload success";
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return "upload failed";
		}
	}
	
	@RequestMapping("test2")
	public String test2(){
		return "test2";
	}
	
}
