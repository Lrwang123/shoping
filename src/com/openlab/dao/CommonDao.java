package com.openlab.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.openlab.domain.CategoryBean;
import com.openlab.domain.CategoryDetailBean;
import com.openlab.domain.OrderBean;
import com.openlab.domain.OrderDetailBean;
import com.openlab.domain.ProductBean;
import com.openlab.domain.UserBean;


@Repository
public interface CommonDao {

	public UserBean getUserByUsernameAndPassword(@Param("username")String username, @Param("password")String password);

	public UserBean getUserByUsername(@Param("username")String username);
	
	public int updateUser(@Param("user")UserBean user, @Param("password")String password);
	
	public int insertUser(@Param("user")UserBean user);
	
	public List<OrderBean> getOrdersByUsername(@Param("username")String username);
	
	public List<OrderDetailBean> getOrderDetailsByOrderId(@Param("orderId")int orderId);
	
	public ProductBean getProductByProductId(@Param("productId")int productId);
	
	public void updateHitByProductId(@Param("productId")int productId);
	
	public CategoryDetailBean getCategoryDetailByCategoryDetailId(@Param("categoryDetailId")int categoryDetailId);
	
	public CategoryBean getCategoryByCategoryId(@Param("categoryId")int categoryId);

	public List<ProductBean> getTopProductByCategoryId(@Param("categoryId")int categoryId);

	public List<ProductBean> getPromotionProduct();

	public List<ProductBean> getNewProduct();

	public List<ProductBean> getHotProduct(@Param("num")int num);
	
	public List<ProductBean> getProductByCategoryId(@Param("categoryId")int categoryId, 
			@Param("start")int start, @Param("num")int num);

	public int getProductTotalQuantity(@Param("categoryId")int categoryId);

	public List<ProductBean> getSearchResult(@Param("searchWord")String searchWord, @Param("start")int start,
			@Param("num")int num);

	public int getSearchTotalQuantity(@Param("searchWord")String searchWord);

	public List<ProductBean> getProductByCategoryIdAndNum(@Param("categoryId")int categoryId, @Param("num")int num);

	public int insertOrder(@Param("order")OrderBean order);

	public int insertOrderDetail(@Param("orderDetail")OrderDetailBean orderDetail);

	public int countProductQuantity();

	public List<ProductBean> getAllProduct(@Param("start")int start, @Param("num")int num);

	public List<CategoryDetailBean> getCategoryDetailByCategoryId(@Param("categoryId")int categoryId);

	public List<CategoryBean> getAllCategory();

	public int insertProduct(@Param("product")ProductBean product);

	public int insertCategory(@Param("name")String name);

	public List<CategoryDetailBean> getAllCategoryDetail();

	public int insertCategoryDetail(@Param("categoryId")int categoryId, @Param("name")String name);

	public int countAllUser();

	public List<ProductBean> selectAllUser(@Param("start")int start, @Param("limit")int limit);

	public int updateUserGrade(@Param("username")String username, @Param("grade")int grade);
}
