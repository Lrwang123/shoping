package com.openlab.service;

import java.util.List;

import com.openlab.domain.CartBean;
import com.openlab.domain.CategoryBean;
import com.openlab.domain.CategoryDetailBean;
import com.openlab.domain.OrderBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;


public interface CommonService {

	public UserBean getUser(String username, String password);
	
	public UserBean getUser(String username);

	public ProductBean getProduct(int productId);
	
	public List<ProductBean> getProduct(int type, int start, int num);
	/**
	 * @param categoryId 
	 * @param num 取出数量
	 */
	public List<ProductBean> getProduct(int categoryId, int num);

	public List<ProductBean> getTopProduct(int categoryId);

	public List<ProductBean> getPromotionProduct();

	public List<ProductBean> getNewProduct();

	public List<ProductBean> getHotProduct(int num);
	
	public int getProductTotalQuantity();
	
	public int getProductTotalQuantity(int categoryId);

	public CategoryBean getCategory(int categoryId);

	public List<ProductBean> getSearchResult(String searchWord, int start, int num);

	public int getSearchTotalQuantity(String searchWord);

	public boolean modifyMember(UserBean user, String password);

	public boolean register(UserBean user);

	public boolean addOrder(OrderBean order, CartBean cart);

	public List<ProductBean> getAllProduct(int start, int num);

	public List<CategoryDetailBean> getCategoryDetailByCategoryId(int categoryId);

	public CategoryDetailBean getCategoryDetail(int categoryDetailId);

	public List<CategoryBean> getAllCategory();

	public boolean addProduct(ProductBean product);

	public boolean addCategory(String name);

	public List<CategoryDetailBean> getAllCategoryDetail();

	public boolean addCategoryDetail(int categoryId, String name);

	public int countAllUser();

	public List<ProductBean> getAllUser(int start, int limit);
	
	
}
