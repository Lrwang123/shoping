package com.openlab.service;

import java.util.List;

import com.openlab.domain.CategoryBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;


public interface CommonService {

	public UserBean getUserByUsername(String username, String password);

	public ProductBean getProductByProductId(int productId);

	public List<ProductBean> getTopProductByCategoryId(int categoryId);

	public List<ProductBean> getPromotionProduct();

	public List<ProductBean> getNewProduct();

	public List<ProductBean> getHotProduct();
	
	public List<ProductBean> getHotProduct7();

	public List<ProductBean> getProductByCategoryId(int type, int start, int num);

	public int getProductTotalQuantity(int categoryId);

	public CategoryBean getCategory(int categoryId);

	public List<ProductBean> getSearchResult(String searchWord, int start, int num);

	public int getSearchTotalQuantity(String searchWord);


}
