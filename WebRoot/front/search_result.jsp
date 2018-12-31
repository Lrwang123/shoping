<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>图书列表-51商城</title>
<link rel="stylesheet" href="../front/css/mr-01.css" type="text/css">

<script src="../front/js/jsArr01.js" type="text/javascript"></script>
<script src="../front/js/module.js" type="text/javascript"></script>
<script src="../front/js/jsArr02.js" type="text/javascript"></script>
<script src="../front/js/tab.js" type="text/javascript"></script>
</head>

<body>
	<jsp:include page="index-loginCon.jsp" />
	<!-- 网站头部 -->
	<%@ include file="common-header.jsp"%>
	<!-- //网站头部 -->
	<div id="mr-mainbody" class="container mr-mainbody">
		<div class="row">

			<!-- 显示搜索到的图书列表 -->
			<div id="mr-content"
				class="mr-content col-xs-12 col-sm-12 col-md-9 col-md-push-3">

				<div id="system-message-container" style="display: none;"></div>

				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<ul class="breadcrumb">
						</ul>
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<div class="box_oc">
									<div class="box-heading">
										<h1 class="mrshop_heading_h1">搜索结果</h1>
									</div>
									<div class="box-content1">
										<hr>
										<div class="row">
											<c:forEach items="${searchResult}" var="product">
											<div
												class="product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12">
												<div class="product-thumb">
													<div class="actions">
														<div class="image">
															<a href="../goods/goodsDetail?productId=${product.productId }"><img
																src="../images/goods/${product.image }"
																class="img-responsive"> </a>
														</div>
														<div class="button-group btn-grid">
															<div class="cart">
																<button class="btn btn-primary btn-primary"
																	type="button" data-toggle="tooltip"
																	onclick='javascript:window.location.href="../cart/cartAdd?goodsID=${product.productId}&num=1"; '
																	style="display: none; width: 33.3333%;"
																	data-original-title="添加到购物车">
																	<i class="fa fa-shopping-cart"></i>
																</button>
															</div>
															<div class="wishlist">
																<button class="btn" type="button" data-toggle="tooltip"
																	title="收藏">
																	<i class="fa fa-heart"></i>
																</button>
															</div>
														</div>
													</div>
													<div>
														<div class="caption">
															<div class="name">
																<a href="../goods/goodsDetail?productId=${product.productId }" style="width: 95%">
																	<span style="color: #0885B1">书名：</span>${product.name }</a>
															</div>
															<p class="price">
																<span class="price-new">分类：</span> <span>${product.categoryDetail.name }</span>
																<span class="price-tax">价格: ${product.priceNow }元
																</span>
															</p>
														</div>
														
													</div>
												</div>
											</div>
											</c:forEach>
										</div>
										<div class="row pagination">
											<table width="100%" border="0" cellspacing="0"
												cellpadding="0">
												<tr>
													<td height="30" align="right">当前页数：[${pageNow }/${pageMax }]&nbsp;
													<!-- 当前页数大于一，显示第一页和上一页 -->
													<c:if test="${pageNow > 1 }">
														<a
														href="../goods/searchResult.php?Page=1&searchword=${searchword }">第一页</a>
														<a
														href="../goods/searchResult.php?Page=${pageNow - 1 }&searchword=${searchword}">上一页</a>
													</c:if>
													<c:if test="${pageNow < pageMax }">
														<a
														href="../goods/searchResult.php?Page=${pageNow + 1 }&searchword=${searchword}">下一页</a>
														<a
														href="../goods/searchResult.php?Page=${pageMax }&searchword=${searchword}">最后一页&nbsp;</a>
													</c:if>
													</td>
												</tr>
											</table>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- //显示搜索到的图书列表-->
			<!-- 显示左侧热门商品 -->
			<%-- <jsp:include page="leftHotGoods.jsp" /> --%>
			<%-- <jsp:include page="../goods/leftHotGoods.php" flush="true"/> --%>
			<%@ include file="leftHotGoods.jsp" %>
			<!-- // 显示左侧热门商品 -->

		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>