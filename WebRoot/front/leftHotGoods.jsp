<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div
	class="mr-sidebar mr-sidebar-left col-xs-12 col-sm-4 col-sm-pull-8 col-md-3 col-md-pull-9  hidden-sm hidden-xs">
	<div class="mr-module module " id="Mod157">
		<div class="module-inner">
			<h3 class="module-title ">
				<span>热门商品</span>
			</h3>

			<div class="module-ct">
				<div class="mrshop">
					<div class="container_oc">
						<div class="box_oc">
							<div>
								 <div class="box-product product-grid">

									<c:forEach items="${leftHotGoods }" var="product">
									<div>
										<div class="image">
											<a href="../goods/goodsDetail?productId=${product.productId }"><img
												src="../images/goods/${product.image }" width="80px">
											</a>
										</div>
										<div class="name">
											<a href="../goods/goodsDetail?productId=${product.productId }"> ${product.name }
											</a>
										</div>
										<div class="rating">
											<span class="fa fa-stack"><i
												class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span> <span
												class="fa fa-stack"><i class="fa fa-star fa-stack-2x"></i><i
												class="fa fa-star-o fa-stack-2x"></i></span>
										</div>
										<div class="price">
											${product.priceNow }
											元
										</div>

									</div> 
									</c:forEach>
								
								</div> 
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>