package com.openlab.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.CartBean;
import com.openlab.domain.OrderBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;
import com.openlab.service.CommonService;
import com.openlab.tool.CommonTool;

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
			mv.setViewName("front/cart_null");			
		} else {
			mv.setViewName("front/cart_see");
		}
		return mv;
	}
	
	@RequestMapping("cartAdd")
	public ModelAndView cartAdd(@RequestParam("goodsID")int goodsID, 
			@RequestParam("num")int num, @SessionAttribute("cart")CartBean cart){
		ModelAndView mv = new ModelAndView();
		ProductBean product = commonService.getProduct(goodsID);
		cart.add(product, num);
		mv.setViewName("redirect:cart.php");
		return mv;
	}
	
	@RequestMapping("clear")
	public String clear(@SessionAttribute("cart")CartBean cart) {
		cart.clear();
		return "redirect:../cart/cart.php";
	}
	
	@RequestMapping("addOrder")
	public String addOrder(OrderBean order, 
			@SessionAttribute("cart")CartBean cart,
			@SessionAttribute("username")String username) {
		order.setOrderId(CommonTool.getOrderIdByTime());//生成订单号
		order.setUsername(username);//添加订单所属用户	
		order.setCategoryNum(cart.getList().size()); //添加订单种类数量
		commonService.addOrder(order, cart);//插入订单
		cart.clear();
		return "redirect:../cart/orderList.php";
	}
	
	@RequestMapping("orderList.php")
	public ModelAndView orderList(@SessionAttribute("username")String username) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("front/orderList");
		UserBean user = commonService.getUser(username);
		mv.addObject("orders", user.getOrders());
		return mv;
	}
	
}
