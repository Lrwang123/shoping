package com.openlab.domain;

import java.util.ArrayList;
import java.util.List;

public class CartBean {
	private List<CartItemBean> list;

	public CartBean() {
		super();
		list = new ArrayList<CartItemBean>();
	}

	/**
	 * @return the list
	 */
	public List<CartItemBean> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(List<CartItemBean> list) {
		this.list = list;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CartBean [list=" + list + "]";
	}
	
	public void add(ProductBean product, int num){
		for (CartItemBean temp: list) {
			if (temp.getProduct().getProductId() == product.getProductId()){
				temp.setNum(temp.getNum() + num);
				return;
			}
		}
		CartItemBean cartItem = new CartItemBean();
		cartItem.setNum(num);
		cartItem.setProduct(product);
		list.add(cartItem);
	}
	
}
