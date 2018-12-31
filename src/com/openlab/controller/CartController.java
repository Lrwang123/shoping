package com.openlab.controller;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.CartBean;
import com.openlab.domain.ProductBean;
import com.openlab.service.CommonService;

@Controller
@RequestMapping("/cart")
public class CartController {

	@Autowired
	@Qualifier("commonServiceImpl")
	private CommonService commonService;
	
	
	@RequestMapping("cart.php")
	public ModelAndView getCartPage(@SessionAttribute("username")String username, 
			@SessionAttribute(value="cart",required=false)CartBean cart, HttpSession session){
		ModelAndView mv = new ModelAndView();
		if (cart.getList().size() == 0) {
			mv.setViewName("cart_null");			
		} else {
			mv.setViewName("cart_see");
		}
		return mv;
	}
	
	@RequestMapping("cartAdd")
	public ModelAndView cartAdd(@Param("goodsId")int goodsID, @Param("num")int num, @SessionAttribute("cart")CartBean cart){
		ModelAndView mv = new ModelAndView();
		ProductBean product = commonService.getProductByProductId(goodsID);
		cart.add(product, num);
		mv.setViewName("redirect:cart.php");
		return mv;
	}
}
