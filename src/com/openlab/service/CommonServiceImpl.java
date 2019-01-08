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
import com.openlab.domain.CategoryDetailBean;
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
	
	public ProductBean getProduct(int productId) {
		ProductBean product = commonDao.getProductByProductId(productId);
		if (product != null)
			commonDao.updateHitByProductId(productId);
		return product;
	}

	public List<ProductBean> getTopProduct(int categoryId) {
		return commonDao.getTopProductByCategoryId(categoryId);
	}

	public List<ProductBean> getPromotionProduct() {
		return commonDao.getPromotionProduct();
	}

	public List<ProductBean> getNewProduct() {
		return commonDao.getNewProduct();
	}

	public List<ProductBean> getHotProduct(int num) {
		return commonDao.getHotProduct(num);
	}
	
	public List<ProductBean> getProduct(int categoryId, int start, int num) {
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
		double totalMoney = 0;
		commonDao.insertOrder(order);
		OrderDetailBean orderDetail = new OrderDetailBean();
		orderDetail.setOrderId(order.getOrderId());
		for (CartItemBean cartItem: cart.getList()) {
			orderDetail.setProductId(cartItem.getProduct().getProductId());
			orderDetail.setPrice(cartItem.getProduct().getPriceNow());
			orderDetail.setNum(cartItem.getNum());
			commonDao.insertOrderDetail(orderDetail);
			totalMoney += orderDetail.getPrice() * orderDetail.getNum();
		}
		commonDao.updateUserGrade(order.getUsername(), (int)Math.floor(totalMoney));
		return true;
	}

	@Override
	public int getProductTotalQuantity() {
		return commonDao.countProductQuantity();
	}

	@Override
	public List<ProductBean> getAllProduct(int start, int num) {
		return commonDao.getAllProduct(start, num);
	}

	@Override
	public List<CategoryDetailBean> getCategoryDetailByCategoryId(int categoryId) {
		return commonDao.getCategoryDetailByCategoryId(categoryId);
	}

	@Override
	public CategoryDetailBean getCategoryDetail(int categoryDetailId) {
		return commonDao.getCategoryDetailByCategoryDetailId(categoryDetailId);
	}

	@Override
	public List<CategoryBean> getAllCategory() {
		return commonDao.getAllCategory();
	}

	@Override
	public boolean addProduct(ProductBean product) {
		return commonDao.insertProduct(product) > 0;
	}

	@Override
	public boolean addCategory(String name) {
		return commonDao.insertCategory(name) > 0;
	}

	@Override
	public List<CategoryDetailBean> getAllCategoryDetail() {
		return commonDao.getAllCategoryDetail();
	}

	@Override
	public boolean addCategoryDetail(int categoryId, String name) {
		return commonDao.insertCategoryDetail(categoryId, name) > 0;
	}

	@Override
	public int countAllUser() {
		return commonDao.countAllUser();
	}

	@Override
	public List<ProductBean> getAllUser(int start, int limit) {
		return commonDao.selectAllUser(start, limit);
	}

	
	
	
	
	
}
