package com.openlab.service;

import java.util.List;

import com.openlab.domain.CartBean;
import com.openlab.domain.CategoryBean;
import com.openlab.domain.OrderBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;


public interface CommonService {

	public UserBean getUser(String username, String password);
	
	public UserBean getUser(String username);

	public ProductBean getProductByProductId(int productId);

	public List<ProductBean> getTopProductByCategoryId(int categoryId);

	public List<ProductBean> getPromotionProduct();

	public List<ProductBean> getNewProduct();

	public List<ProductBean> getHotProduct();
	
	public List<ProductBean> getHotProduct7();

	public List<ProductBean> getProductByCategoryId(int type, int start, int num);
	
	/**
	 * 
	 * @param categoryId 
	 * @param num 取出数量
	 * @return
	 */
	public List<ProductBean> getProduct(int categoryId, int num);

	public int getProductTotalQuantity(int categoryId);

	public CategoryBean getCategory(int categoryId);

	public List<ProductBean> getSearchResult(String searchWord, int start, int num);

	public int getSearchTotalQuantity(String searchWord);

	public boolean modifyMember(UserBean user, String password);

	public boolean register(UserBean user);

	public boolean addOrder(OrderBean order, CartBean cart);
	
	
	
	


}
