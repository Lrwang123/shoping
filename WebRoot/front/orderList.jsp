<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<title>我的购物车-51商城</title>
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
			<!-- 显示订单列表 -->
			<div id="mr-content" class="mr-content col-xs-12">
				<div id="mrshop" class="mrshop common-home">
					<div class="container_oc">
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<h1>我的订单</h1>
									<div class="table-responsive cart-info">
										<table class="table table-bordered">
											<thead>
												<tr>
													<td class="text-center image">订单号</td>
													<td class="text-center name">产品名称</td>
													<td class="text-center name">购买数量</td>
													<td class="text-center name">单价</td>
													<td class="text-center name">消费金额</td>
													<td class="text-center quantity">收货人姓名</td>
													<td class="text-center price">收货人手机</td>
													<td class="text-center total">下单日期</td>
												</tr>
											</thead>
											<tbody>
												<c:forEach items="${orders }" var="order">
												<c:forEach items="${order.orderDetails }" var="orderDetail">
												<tr>
													<td class="text-center image" width="10%">${order.orderId }
													</td>
													<td class="text-center name">${orderDetail.product.name } </td>
													<td class="text-center quantity">${orderDetail.num }件</td>
													<td class="text-center quantity">${orderDetail.price }元</td>
													<td class="text-center quantity">${orderDetail.price * orderDetail.num }元</td>
													<td class="text-center quantity">${order.consignee }</td>
													<td class="text-center quantity">${order.tel }</td>
													<td class="text-center quantity">${order.createDate }</td>
												</tr>
												</c:forEach>
												</c:forEach>
											</tbody>
										</table>
									</div>
							</div>
						</div>
						<br /><br />
						<div class="row">
							<div id="content_oc" class="col-sm-12">
								<br />
								<br />
								<div class="buttons">
									<div class="pull-right">
										<a href="../goods/index.php" class="tigger btn btn-primary btn-primary">继续购物</a>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		<!-- //显示订单列表 -->
		</div>
	</div>
	<!-- 版权栏 -->
	<%@ include file="common-footer.jsp"%>
	<!-- //版权栏 -->
</body>
</html>
