package com.openlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.openlab.dao.CommonDao;
import com.openlab.domain.CategoryBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;
import com.openlab.exception.InputValidException;


@Service("commonServiceImpl")
public class CommonServiceImpl implements CommonService {

	@Autowired
	@Qualifier("commonDao")
	private CommonDao commonDao;
	
	public UserBean getUserByUsername(String username, String password) {
		if (username == null || password == null)
			throw new InputValidException("账号密码不能为空");
		else
			return commonDao.getUserByUsername(username, password);
	}
	
	public ProductBean getProductByProductId(int productId) {
		return commonDao.getProductByProductId(productId);
	}

	public List<ProductBean> getTopProductByCategoryId(int categoryId) {
		return commonDao.getTopProductByCategoryId(categoryId);
	}

	public List<ProductBean> getPromotionProduct() {
		return commonDao.getPromotionProduct();
	}

	public List<ProductBean> getNewProduct() {
		return commonDao.getNewProduct();
	}

	public List<ProductBean> getHotProduct() {
		return commonDao.getHotProduct();
	}
	
	public List<ProductBean> getHotProduct7() {
		return commonDao.getHotProduct7();
	}

	public List<ProductBean> getProductByCategoryId(int categoryId, int start, int num) {
		return commonDao.getProductByCategoryId(categoryId, start, num);
	}

	public int getProductTotalQuantity(int categoryId) {
		return commonDao.getProductTotalQuantity(categoryId);
	}

	public CategoryBean getCategory(int categoryId) {
		return commonDao.getCategoryByCategoryId(categoryId);
	}

	public List<ProductBean> getSearchResult(String searchWord, int start,
			int num) {
		return commonDao.getSearchResult(searchWord, start, num);
	}

	public int getSearchTotalQuantity(String searchWord) {
		return commonDao.getSearchTotalQuantity(searchWord);
	}
}
