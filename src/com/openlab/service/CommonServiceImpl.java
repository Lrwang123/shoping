package com.openlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.openlab.dao.CommonDao;
import com.openlab.domain.CartBean;
import com.openlab.domain.CartItemBean;
import com.openlab.domain.CategoryBean;
import com.openlab.domain.OrderBean;
import com.openlab.domain.OrderDetailBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;


@Service("commonServiceImpl")
public class CommonServiceImpl implements CommonService {

	@Autowired
	private CommonDao commonDao;
	
	public UserBean getUser(String username, String password) {
			return commonDao.getUserByUsernameAndPassword(username, password);
	}
	
	public UserBean getUser(String username) {
		return commonDao.getUserByUsername(username);
	}
	
	public ProductBean getProductByProductId(int productId) {
		ProductBean product = commonDao.getProductByProductId(productId);
		if (product != null)
			commonDao.updateHitByProductId(productId);
		return product;
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

	public List<ProductBean> getProduct(int categoryId, int num) {
		return commonDao.getProductByCategoryIdAndNum(categoryId, num);
	}

	public boolean modifyMember(UserBean user, String password) {
		return commonDao.updateUser(user, password) > 0;
	}

	public boolean register(UserBean user) {
		return commonDao.insertUser(user) > 0;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW, isolation=Isolation.SERIALIZABLE, timeout=3)
	public boolean addOrder(OrderBean order, CartBean cart) {
		commonDao.insertOrder(order);
		OrderDetailBean orderDetail = new OrderDetailBean();
		orderDetail.setOrderId(order.getOrderId());
		for (CartItemBean cartItem: cart.getList()) {
			orderDetail.setProductId(cartItem.getProduct().getProductId());
			orderDetail.setPrice(cartItem.getProduct().getPriceNow());
			orderDetail.setNum(cartItem.getNum());
			commonDao.insertOrderDetail(orderDetail);
		}
		return true;
	}

	
	
	
	
	
}
