<%@ page contentType="text/html; charset=UTF-8" language="java"
	import="java.sql.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>51商城――后台管理</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="../manage/CSS/style.css" rel="stylesheet">
	</head>

	<body>
		<jsp:include page="banner.jsp" />
		<table width="1280" height="288" border="0" align="center"
			cellpadding="0" cellspacing="0" bgcolor="#FFFFFF">
			<tr>

				<td align="center" valign="top">
					<table width="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td width="18" height="45" align="right">
								&nbsp;
							</td>
							<td colspan="3" class="tableBorder_B_dashed">
								<img src="../manage/images/manage_ico1.GIF" width="11" height="11">
								&nbsp;
								<a href="type_super_list.php"> [大分类信息管理]</a>&nbsp;&nbsp;&nbsp;
								<img src="../manage/images/manage_ico2.GIF" width="11" height="11">
								&nbsp;
								<a href="type_sub_list.php">[小分类信息管理]</a>&nbsp;&nbsp;&nbsp;
								<img src="../manage/images/manage_ico3.GIF" width="12" height="12">
								&nbsp;
								<a href="product_add.php">[添加商品信息]</a>
							</td>
							<td width="24">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td align="right">
								&nbsp;
							</td>
							<td height="10" colspan="3">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
						<tr>
							<td height="29" align="right">
								&nbsp;
							</td>
							<td width="10" background="../manage/images/manage_leftTitle_left.GIF">
								&nbsp;
							</td>
							<td width="989" align="center"
								background="../manage/images/manage_leftTitle_mid.GIF" class="word_white">
								<b>商品列表</b>
							</td>
							<td width="10" background="../manage/images/manage_leftTitle_right.GIF">
								&nbsp;
							</td>
							<td>
								&nbsp;
							</td>
						</tr>
					</table>
					<!---->
					<table width="92%" height="192" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td valign="top">
								<table width="100%" height="14" border="0" cellpadding="0"
									cellspacing="0">
									<tr>
										<td height="13" align="center">
											&nbsp;
										</td>
									</tr>

								</table>
								<table width="100%" height="60" border="1" cellpadding="0"
									cellspacing="0" bordercolor="#FFFFFF" bordercolordark="#FFFFFF"
									bordercolorlight="#E6E6E6">
									<tr bgcolor="#eeeeee">
										<td width="40%" height="24" align="center">
											商品名称
										</td>
										<td width="22%" align="center">
											价格
										</td>
										<td width="11%" align="center">
											是否新品
										</td>
										<td width="11%" align="center">
											是否特价
										</td>
										<td width="8%" align="center">
											修改
										</td>
										<td width="8%" align="center">
											删除
										</td>
									</tr>
									
									<c:forEach items="${paper.list }" var="product">
									<tr>
										<td><a href="product_detail.php?productId=${product.productId}">${product.name }</a></td>
										<td>${product.priceNow }</td>
										<td>${product.isNew }</td>
										<td>${product.isPromotion }</td>
										<td><a href="product_modify.php?productId=${product.productId }">修改</a></td>
										<td><a href="product_delete?productId=${product.productId }">删除</a></td>
									</tr>
									</c:forEach>

								</table>
								<table width="100%" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td height="30" align="right">
											当前页数：&nbsp;[${paper.pageNumber }/${paper.pages }]
											<c:if test="${!paper.firstPage }">
												<a href="index.php?Page=1">第一页</a>
												<a href="index.php?Page=${paper.pageNumber-1 }">上一页</a>
											</c:if>
											<c:if test="${!paper.lastPage }">
												<a href="index.php?Page=${paper.pageNumber+1 }">下一页</a>
												<a href="index.php?Page=${paper.pages }">最后一页&nbsp;</a>
											</c:if>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
					<!---->
				</td>

				<td width="182" valign="top">
					<table width="100%" height="431" border="0" cellpadding="0"
						cellspacing="0">
						<tr>
							<td width="199" valign="top" bgcolor="#FFFFFF">
							<jsp:include
									page="navigation.jsp" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<jsp:include page="copyright.jsp" />
	</body>
</html>
