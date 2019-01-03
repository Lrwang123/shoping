package com.openlab.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.openlab.domain.ProductBean;
import com.openlab.service.CommonService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	
	@Autowired
	@Qualifier("commonServiceImpl")
	private CommonService commonService;
	
	@RequestMapping("/index.php")
	public String getIndexPage(Model model){
		List<ProductBean> promotionProduct = commonService.getPromotionProduct();
		List<ProductBean> newProduct = commonService.getNewProduct();
		List<ProductBean> hotProduct = commonService.getHotProduct();
		model.addAttribute("promotionProduct", promotionProduct);
		model.addAttribute("newProduct", newProduct);
		model.addAttribute("hotProduct", hotProduct);
		return "index";
	}
	
	@RequestMapping("/goodsDetail")
	public ModelAndView goodsDetail(@Param("productId")int productId){
		ModelAndView mv = new ModelAndView();
		ProductBean product = commonService.getProductByProductId(productId);
		if (product == null)
			throw new RuntimeException("请求的商品不存在！");
		int relatedNum = 6;
		mv.addObject("product", product);
		mv.addObject("leftHotGoods", commonService.getTopProductByCategoryId(product.getCategoryDetail().getCategoryId()));
		mv.addObject("relatedGoods", commonService.getProduct(product.getCategoryDetail().getCategoryId(), relatedNum));
		mv.setViewName("goodsDetail");
		return mv;
	}
	
	//@param：大类号，第几页
	//@model：大类号，第几页，最大页数，num条产品，左侧热门商品
	@RequestMapping("/goodsList")
	public ModelAndView goodsList(@RequestParam("type")Integer type, 
			@RequestParam(value="Page",required=false)Integer page) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("goodsList");
		mv.addObject("leftHotGoods", commonService.getTopProductByCategoryId(type));
		page = page==null ? 1 : page;
		int productPerPage = 12;
		int start = (page - 1) * productPerPage;
		int num = productPerPage;
		mv.addObject("goodsList", commonService.getProductByCategoryId(type, start, num));
		mv.addObject("pageMax", commonService.getProductTotalQuantity(type)/productPerPage+1);
		mv.addObject("pageNow", page);
		mv.addObject("type", type);
		mv.addObject("typeName", commonService.getCategory(type).getName());
		return mv;
	} 	
	
	//@param：关键字，第几页
	//@model：关键字，第几页，最大页数，num条产品，左侧热门商品	
	@RequestMapping("/searchResult.php")
	public ModelAndView searchResult(@RequestParam("searchword")String searchWord, 
			@RequestParam(value="Page",required=false)Integer page){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("search_result");
		page = page==null ? 1 : page;
		int num = 8;
		int start = (page - 1) * num;
		mv.addObject("searchResult",commonService.getSearchResult(searchWord, start, num));
		mv.addObject("leftHotGoods", commonService.getHotProduct7());
		mv.addObject("searchword", searchWord);
		mv.addObject("pageNow", page);
		mv.addObject("pageMax", commonService.getSearchTotalQuantity(searchWord) / num + 1);
		return mv;
	}
}
