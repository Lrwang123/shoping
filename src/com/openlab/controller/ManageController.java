package com.openlab.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.openlab.domain.ProductBean;
import com.openlab.service.CommonService;
import com.openlab.tool.Paper;

@Controller
@RequestMapping("manage")
public class ManageController {

	@Autowired
	@Qualifier("commonServiceImpl")
	private CommonService commonService;

	@RequestMapping("login.php")
	public String loginPage() {
		return "manage/Login_M";
	}

	@RequestMapping("login")
	public String login(@RequestParam(value = "manager") String manager,
			@RequestParam("PWD") String password, HttpSession session) {
		if ("manager".equals(manager) && "123456".equals(password)) {
			session.setAttribute("manager", manager);
			return "redirect:index.php";
		} else {
			throw new RuntimeException("账号或密码错误");
		}
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:login.php";
	}

	// 同时也是商品列表
	@RequestMapping("index.php")
	public String indexPage(
			@RequestParam(value = "Page", required = false) Integer pageNum,
			Model model) {
		pageNum = (pageNum == null) ? 1 : pageNum;//第几页
		int limit = 10;//每页数量
		int total = commonService.getProductTotalQuantity();
		Paper<ProductBean> paper = new Paper<>(total, pageNum);
		paper.setList(commonService.getAllProduct(limit * (pageNum-1), limit));
		model.addAttribute("paper", paper);
		return "manage/index";
	}

	@RequestMapping("user_list.php")
	public String userListPage(Model model,
			@RequestParam(value="Page", required=false)Integer pageNum) {
		pageNum = (pageNum == null) ? 1 : pageNum;//第几页
		int limit = 10;//每页数量
		int total = commonService.countAllUser();
		Paper<ProductBean> paper = new Paper<>(total, pageNum, limit);
		paper.setList(commonService.getAllUser(limit * (pageNum-1), limit));
		model.addAttribute("paper", paper);
		return "manage/membermanage";
	}

	@RequestMapping("user_detail.php")
	public void userDetailPage() {

	}

	@RequestMapping("product_top_list.php")
	public void productTopListPage() {

	}

	@RequestMapping("product_detail.php")
	public String productDetailPage(@RequestParam("productId")int productId, Model model) {
		model.addAttribute("product", commonService.getProduct(productId));
		return "manage/goods_detail";
	}

	@RequestMapping("product_add.php")
	public String productAddPage(Model model) {
		model.addAttribute("categoryList", commonService.getAllCategory());
		return "manage/goods_add";

	}

	@RequestMapping("product_add")
	@ResponseBody
	public String productAdd(@Valid ProductBean product, Errors errors,
			HttpServletRequest request) {
		if (errors.hasErrors()){
			throw new RuntimeException(errors.getFieldError().getDefaultMessage());
		}
		MultipartHttpServletRequest mhsr = (MultipartHttpServletRequest)request;
		MultipartFile file = mhsr.getFile("picture");
		String format = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		if (!".jpg".equals(format)){
			throw new RuntimeException("图片仅支持jpg格式");
		}
		String fileName = UUID.randomUUID()+format;
		product.setImage(fileName);
		File dest = new File(fileName);
		try {
			//保存文件
			file.transferTo(dest);
		} catch (IllegalStateException | IOException e) {
		}
		commonService.addProduct(product);
		return "<script>alert(\"product add success" + "\");window.location.href=\"../manage/index.php\"</script>";
	}

	@RequestMapping("product_delete")
	public void productDelete() {

	}

	@RequestMapping("product_modify.php")
	public String productModifyPage(@RequestParam("productId")int productId,
			Model model) {
		model.addAttribute("product", commonService.getProduct(productId));
		model.addAttribute("categoryList", commonService.getAllCategory());
		return "manage/goods_modify";
	}

	@RequestMapping("product_modify")
	public void productModify() {

	}

	@RequestMapping("type_super_list.php")
	public String typeSuperListPage(Model model) {
		model.addAttribute("categoryList", commonService.getAllCategory());
		return "manage/superType";
	}

	@RequestMapping("type_super_add.php")
	public String typeSuperAddPage() {
		return "manage/super_add";
	}

	@RequestMapping("type_super_add")
	public String typeSuperAdd(@RequestParam("typename")String name) {
		commonService.addCategory(name);
		return "redirect:type_super_list.php";
	}

	@RequestMapping("type_super_delete")
	public void typeSuperDelete() {

	}

	@RequestMapping("type_sub_list.php")
	public String typeSubListPage(Model model) {
		model.addAttribute("categoryDetailList", commonService.getAllCategoryDetail());
		return "manage/subType";
	}
	
	@RequestMapping("type_sub_list.part")
	public String typeSubListPart(@RequestParam("superID")int categoryId,
			Integer categoryDetailId,
			Model model) {
		categoryDetailId = (categoryDetailId==null) ? -1 : categoryDetailId;
		model.addAttribute("categoryDetailId", categoryDetailId);
		model.addAttribute("categoryDetailList", commonService.getCategoryDetailByCategoryId(categoryId));
		return "manage/selSubType";
	}

	@RequestMapping("type_sub_add.php")
	public String typeSubAddPage(Model model) {
		model.addAttribute("categoryList", commonService.getAllCategory());
		return "manage/sub_add";
	}

	@RequestMapping("type_sub_add")
	public String typeSubAdd(@RequestParam("superid")int categoryId,
			@RequestParam("typename")String name) {
		commonService.addCategoryDetail(categoryId, name);
		return "redirect:type_sub_list.php";
	}

	@RequestMapping("type_sub_delete")
	public void typeSubDelete(Integer[] delid) {
		//收到数组，进行事务删除
		for (Integer i: delid) 
			System.out.print(i+",");
	}

	@RequestMapping("order_list.php")
	public void orderListPage() {

	}

	@RequestMapping("order_detail.php")
	public void orderDetailPage() {

	}
}
